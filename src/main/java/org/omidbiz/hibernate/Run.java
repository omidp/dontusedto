package org.omidbiz.hibernate;

import org.hibernate.Session;
import org.omidbiz.core.axon.Axon;
import org.omidbiz.core.axon.AxonBuilder;
import org.omidbiz.core.axon.Filter;

import com.jedlab.model.User;
import com.jedlab.view.GoogleViewFilter;
import com.jedlab.view.JedlabViewFilter;

public class Run
{

    /**
     * this is called design pattern
     */
    private Filter jsonFilter;
    

    public Run(Filter jsonFilter)
    {
        this.jsonFilter = jsonFilter;
    }
    
    public void printJson()
    {
        // fail fast
        if (this.jsonFilter == null)
            throw new IllegalArgumentException("jsonfilter can not be null");
        
        Axon axon = new AxonBuilder().addFilter(this.jsonFilter).create();
        // fetch entity
        Session session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        User u = (User) session.createQuery("select u from User u left join fetch u.profile p left join fetch u.comments c")
                .setMaxResults(1).uniqueResult();
        
        String json = axon.toJson(u);
        System.out.println(json);
        
        session.getTransaction().commit();
        session.close();
    }

    
    /**
     * serialize User entity without DTO
     * @param args
     */
    public static void main(String[] args)
    {
        Run r = new Run(new GoogleViewFilter());
        r.printJson();
        System.out.println("Serialized  google view");
        System.out.println("=====================================");
        r = new Run(new JedlabViewFilter());
        r.printJson();
        System.out.println("Serialized  JEDLab view");
        
    }

}
