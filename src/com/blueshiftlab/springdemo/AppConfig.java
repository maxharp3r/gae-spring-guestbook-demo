package com.blueshiftlab.springdemo;

import javax.jdo.PersistenceManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blueshiftlab.springdemo.dao.jdoimpl.PMF;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * Home for JavaConfig, including system properties and DI.
 * 
 * We choose to use Spring's "component scanning" to automatically
 * wire dependencies, rather than explicitly declaring beans
 * here.
 * 
 * @author harper
 *
 */
@Configuration
public class AppConfig {
    
    /**
     * Google's UserService is part of a jar, so we cannot use
     * Spring's "component scanning".  Thus, we explicitly
     * declare it as a bean for DI.
     */
    @Bean
    public UserService userService() {
        return UserServiceFactory.getUserService();
    }
    
    @Bean
    public PersistenceManagerFactory persistenceManagerFactory() {
        return PMF.get();
    }
    
}