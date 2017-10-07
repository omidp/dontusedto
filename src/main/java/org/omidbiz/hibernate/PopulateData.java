package org.omidbiz.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.omidbiz.core.axon.Axon;
import org.omidbiz.core.axon.AxonBuilder;

import com.jedlab.model.Comment;
import com.jedlab.model.Profile;
import com.jedlab.model.User;

public class PopulateData
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        Session session = HibernateSessionManager.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        User u = new User();
        u.setActive(true);
        u.setExpired(false);
        u.setName("I am user");
        //
        Profile p =new Profile();
        p.setAge(20);
        u.setProfile(p);
        session.persist(p);
        //
        Comment c = new Comment();
        c.setCreatedDate(new Date());
        c.setContent("comment 1");
        session.persist(c);
        u.getComments().add(c);
        
        Comment c2 = new Comment();
        c2.setContent("comment 2");
        c2.setCreatedDate(new Date());
        session.persist(c2);
        u.getComments().add(c2);
        
        session.persist(u);
        //
        session.getTransaction().commit();
        session.close();

    }

}
