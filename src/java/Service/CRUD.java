/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.*;

/**
 *
 *  
 */
public class CRUD
{
    SessionFactory sessionFactory = null;

    public CRUD() {
    }
    
    public CRUD(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    
    public boolean saveOrUpdate(Object object)
    {
        boolean status = false;
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {         
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
            
            status = true;
        }        
        catch(HibernateException ex)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }
        
        return status;
    }

    public boolean save(Object object)
    {
        boolean status = false;

        Session session = null;
        Transaction transaction = null;

        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();

            status = true;
        }
        catch(HibernateException ex)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }

            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }

        return status;
    }
    
    public boolean delete(Object object)
    {
        boolean status = false;
        
        Session session = null;
        Transaction transaction = null;
        
        try
        {         
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
            
            status = true;
        }        
        catch(HibernateException ex)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }
        
        return status;
    }
public List findByQueryString(Object object, String queryString)
    {
        List result = null;

        Session session = null;
        Transaction transaction = null;

        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(queryString);
            query.setParameter("qs", object);
            result = query.list();
            transaction.commit();


        }
        catch(HibernateException ex)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }

            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }

        return result;
    }

    public List findByPrimaryKey(Object object, String queryString)
    {
        List result = null;

        Session session = null;
        Transaction transaction = null;

        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(queryString);
            query.setParameter("pk", object);
            result = query.list();
            transaction.commit();


        }
        catch(HibernateException ex)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }

            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }

        return result;
    }
     public List<Object> getObject(String queryString)
    {
        List result = null;
 
        Session session = null;
        Transaction transaction = null;
 
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(queryString);
             
            result = query.list();
            transaction.commit();
        }
        catch(HibernateException ex)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
 
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }
 
        return result;
    }
     
    public List<Object> getObjectLazyLoad(String queryString)
    {
        List result = null;
 
        Session session = null;
        Transaction transaction = null;
 
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(queryString);
            result = query.list();
            transaction.commit();
        }
        catch(HibernateException ex)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
 
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(session != null)
            {
                //session.close();
            }
        }
 
        return result;
    }
}