package com.blueshiftlab.springdemo.service;

import java.util.List;

import com.blueshiftlab.springdemo.domain.Greeting;

public interface GuestbookService {
    /**
     * Adds a message to the guestbook
     */
    public void addGreeting(Greeting greeting);
    
    /**
     * Returns a list of messages in the guestbook
     */
    public List<Greeting> findAllGreetings();
}
