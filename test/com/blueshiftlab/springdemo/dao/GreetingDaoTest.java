package com.blueshiftlab.springdemo.dao;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Date;

import org.testng.annotations.Test;

import com.blueshiftlab.springdemo.dao.jdoimpl.GreetingDaoImpl;
import com.blueshiftlab.springdemo.dao.jdoimpl.PMF;
import com.blueshiftlab.springdemo.domain.Greeting;
import com.blueshiftlab.springdemo.test.LocalDatastoreTest;

/**
 * @see GreetingDao
 * @author harper
 */
public class GreetingDaoTest extends LocalDatastoreTest {
    
    private final GreetingDao greetingDao = new GreetingDaoImpl(PMF.get());
    
    @Test(groups = { "fast" })
    public void canCreateGreetings() {
        assertEquals(0, this.greetingDao.findAll().size());
        
        Date date = new Date();
        Greeting greeting1 = new Greeting(null, "greeting", date);
        this.greetingDao.create(greeting1);
        
        assertEquals(1, this.greetingDao.findAll().size());
        
        Date date2 = new Date();
        Greeting greeting2 = new Greeting(null, "greeting", date2);
        this.greetingDao.create(greeting2);
        
        assertEquals(2, this.greetingDao.findAll().size());
        
        // NOTE(max): this is from the google documentation.  Not sure what to make of it yet.
//        Query query = new Query(Greeting.class.getName());
//        assertEquals(1, DatastoreServiceFactory.getDatastoreService().prepare(query).countEntities());
    }
}