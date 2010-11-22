package com.blueshiftlab.springdemo.test;

import java.io.File;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.appengine.api.mail.dev.LocalMailService;
import com.google.appengine.api.users.dev.LocalUserService;
import com.google.appengine.tools.development.ApiProxyLocalImpl;
import com.google.apphosting.api.ApiProxy;

/**
 * @see http://code.google.com/appengine/docs/java/howto/unittesting.html 
 */
public class LocalServiceTest {
    
    protected LocalMailService mailService;
    protected LocalUserService userService;

    @BeforeSuite(alwaysRun=true)
    public void setUp() {
        ApiProxy.setEnvironmentForCurrentThread(new TestEnvironment());
        ApiProxy.setDelegate(new ApiProxyLocalImpl(new File("./test-output")){});
        
        // create mock services
        ApiProxyLocalImpl proxy = (ApiProxyLocalImpl) ApiProxy.getDelegate();
        this.mailService = (LocalMailService) proxy.getService("mail");
        this.userService = (LocalUserService) proxy.getService("user");
    }

    @AfterSuite(alwaysRun=true)
    public void tearDown() {
        // not strictly necessary to null these out but there's no harm either
        ApiProxy.setDelegate(null);
        ApiProxy.setEnvironmentForCurrentThread(null);
    }
}