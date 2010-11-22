package com.blueshiftlab.springdemo.controller;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.blueshiftlab.springdemo.domain.Greeting;
import com.blueshiftlab.springdemo.service.GuestbookService;
import com.google.appengine.api.users.UserService;

/**
 * @see GuestbookController
 * @author harper
 */
public class GuestbookControllerTest {
    
    private GuestbookService guestbookServiceMock;
    private UserService userServiceMock;
    private GuestbookController guestbookController;
    
    @BeforeSuite(alwaysRun=true)
    public void setUp() {
        this.guestbookServiceMock = createMock("guestbookServiceMock", GuestbookService.class);
        this.userServiceMock = createMock("userServiceMock", UserService.class);
        this.guestbookController = new GuestbookController(guestbookServiceMock, userServiceMock);
    }

    @Test(groups = { "fast" })
    public void testIndexWhileAnonymous() {
        // create fixtures
        List<Greeting> listOfCurrentGreetings = new ArrayList<Greeting>();
        String loginLink = "/test_login_link";
        String logoutLink = "/test_logout_link";
        
        // define the expected behavior
        expect(userServiceMock.getCurrentUser()).andReturn(null);
        expect(userServiceMock.createLoginURL(GuestbookController.URL_GB_INDEX))
            .andReturn(loginLink);
        expect(userServiceMock.createLogoutURL(GuestbookController.URL_GB_INDEX))
            .andReturn(logoutLink);
        expect(guestbookServiceMock.findAllGreetings())
            .andReturn(listOfCurrentGreetings);
        replay(userServiceMock);
        replay(guestbookServiceMock);
        
        // confirm that behavior        
        ModelMap model = new ModelMap();
        ModelAndView mv = guestbookController.index(model);
        
        // test the resulting model
        model = mv.getModelMap();
        assertEquals(model.get(GuestbookController.ATTR_USER), null);
        assertEquals(model.get(GuestbookController.ATTR_LINK_LOGIN), loginLink);
        assertEquals(model.get(GuestbookController.ATTR_LINK_LOGOUT), logoutLink);
        assertEquals(model.get(GuestbookController.ATTR_GREETING_LIST), listOfCurrentGreetings);
        
        // test the redirection
        assertEquals(mv.getViewName(), "gb");
    }
    
}
