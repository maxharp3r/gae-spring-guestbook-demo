package com.blueshiftlab.springdemo.test;

import com.google.apphosting.api.ApiProxy;

/**
 * @see http://code.google.com/appengine/docs/java/howto/unittesting.html 
 */
class TestEnvironment implements ApiProxy.Environment {
    public String getAppId() {
        return "Unit Tests";
    }

    public String getVersionId() {
        return "1.0";
    }

    public void setDefaultNamespace(String s) { }

    public String getRequestNamespace() {
        return "gmail.com";
    }

    public String getDefaultNamespace() { 
        return "";
    }

    public String getAuthDomain() {
        return "gmail.com";
    }

    public boolean isLoggedIn() {
        return false;
    }

    public String getEmail() {
        return "";
    }

    public boolean isAdmin() {
        return false;
    }
}