package com.blueshiftlab.springdemo.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.appengine.api.datastore.dev.LocalDatastoreService;
import com.google.appengine.tools.development.ApiProxyLocalImpl;
import com.google.apphosting.api.ApiProxy;

/**
 * Provide a testing object with a clean datastore. 
 * 
 * @see http://code.google.com/appengine/docs/java/howto/unittesting.html
 */
public class LocalDatastoreTest extends LocalServiceTest {
    
    @Override
    @BeforeSuite(alwaysRun=true)
    public void setUp() {
        super.setUp();
        ApiProxyLocalImpl proxy = (ApiProxyLocalImpl) ApiProxy.getDelegate();
        proxy.setProperty(LocalDatastoreService.NO_STORAGE_PROPERTY, Boolean.TRUE.toString());
    }

    @Override
    @AfterSuite(alwaysRun=true)
    public void tearDown() {
        ApiProxyLocalImpl proxy = (ApiProxyLocalImpl) ApiProxy.getDelegate();
        LocalDatastoreService datastoreService = (LocalDatastoreService) proxy.getService("datastore_v3");
        datastoreService.clearProfiles();
        super.tearDown();
    }

}