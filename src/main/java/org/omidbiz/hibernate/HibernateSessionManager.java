package org.omidbiz.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.jedlab.model.Comment;
import com.jedlab.model.Profile;
import com.jedlab.model.User;

public class HibernateSessionManager
{

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            return new AnnotationConfiguration().configure().addAnnotatedClass(User.class)
                    .addAnnotatedClass(Profile.class).addAnnotatedClass(Comment.class).buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static void shutdown()
    {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}