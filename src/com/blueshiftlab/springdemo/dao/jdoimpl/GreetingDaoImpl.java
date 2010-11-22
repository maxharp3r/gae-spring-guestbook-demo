package com.blueshiftlab.springdemo.dao.jdoimpl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blueshiftlab.springdemo.dao.GreetingDao;
import com.blueshiftlab.springdemo.domain.Greeting;

@Repository
public class GreetingDaoImpl implements GreetingDao {
    
    private final PersistenceManagerFactory pmf;
    
    @Autowired
    public GreetingDaoImpl(PersistenceManagerFactory pmf) {
        this.pmf = pmf;
    }
    
    @Override
    public void create(Greeting greeting) {
        PersistenceManager pm = this.pmf.getPersistenceManager();
        try {
            pm.makePersistent(greeting);
        } finally {
            pm.close();
        }
    }

    /**
     * XXX: There are appengine bugs here
     *  - http://code.google.com/p/datanucleus-appengine/issues/detail?id=24
     *  - http://groups.google.com/group/google-appengine-java/browse_thread/thread/945f6ca66c1c587e
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Greeting> findAll() {
        PersistenceManager pm = this.pmf.getPersistenceManager();
        List<Greeting> greetings;
        try {
            String query = "select from " + Greeting.class.getName();
            greetings = (List<Greeting>) pm.newQuery(query).execute();
            greetings.size(); // XXX: see above
            return greetings;
        } finally {
            pm.close();
        }
    }

}
