package com.blueshiftlab.springdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueshiftlab.springdemo.dao.GreetingDao;
import com.blueshiftlab.springdemo.domain.Greeting;
import com.blueshiftlab.springdemo.service.GuestbookService;


@Service
public class GuestbookServiceImpl implements GuestbookService {
    private final GreetingDao greetingDao;
    
    @Autowired
    public GuestbookServiceImpl(GreetingDao greetingDao) {
        this.greetingDao = greetingDao;
        
        if (this.greetingDao == null) {
            throw new IllegalStateException("greetingDao not initialized by dependency injection");
        }
    }

    @Override
    public void addGreeting(Greeting greeting) {
        this.greetingDao.create(greeting);
    }
    
    @Override
    public List<Greeting> findAllGreetings() {
        return this.greetingDao.findAll();
    }

}
