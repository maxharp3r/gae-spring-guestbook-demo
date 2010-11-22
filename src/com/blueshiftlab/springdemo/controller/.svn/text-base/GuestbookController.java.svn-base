package com.blueshiftlab.springdemo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blueshiftlab.springdemo.domain.Greeting;
import com.blueshiftlab.springdemo.service.GuestbookService;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;

@Controller
public class GuestbookController {
    protected final static String ATTR_USER = "user";
    protected final static String ATTR_LINK_LOGIN = "loginHref";
    protected final static String ATTR_LINK_LOGOUT = "logoutHref";
    protected final static String ATTR_GREETING_LIST = "greetings";
    
    protected final static String URL_GB_INDEX = "/gb/";
    protected final static String URL_GB_CREATE = "/gb/new";
    
    private final GuestbookService guestbookService;
    private final UserService userService;
    
    @Autowired
    public GuestbookController(GuestbookService guestbookService, UserService userService) {
        this.guestbookService = guestbookService;
        this.userService = userService;
    }
    
    /**
     * TODO(max): refactor this hack to wire the default page to a reasonable view.
     */
    @RequestMapping("")
    public ModelAndView home(ModelMap model) {
        return index(model);
    }
    
    @RequestMapping(URL_GB_INDEX)
    public ModelAndView index(ModelMap model) {
        User user = userService.getCurrentUser();
        model.addAttribute(ATTR_USER, user);
        model.addAttribute(ATTR_LINK_LOGIN, userService.createLoginURL(URL_GB_INDEX));
        model.addAttribute(ATTR_LINK_LOGOUT, userService.createLogoutURL(URL_GB_INDEX));
        model.addAttribute(ATTR_GREETING_LIST, this.guestbookService.findAllGreetings());
        
        return new ModelAndView("gb", model);
    }
    
    @RequestMapping(value=URL_GB_CREATE, method=RequestMethod.POST)
    public ModelAndView create(@RequestParam("content") String content, ModelMap model) {
        User user = userService.getCurrentUser();
        Date date = new Date();
        Greeting greeting = new Greeting(user, content, date);
        guestbookService.addGreeting(greeting);
        
        return index(model);
    }

}
