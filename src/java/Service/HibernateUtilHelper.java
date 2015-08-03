/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import model.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 *
 * @author Levi Barasa
 */
public class HibernateUtilHelper
{
    public HibernateUtilHelper()
    {
        
    }
    
    public SessionFactory getHibernateUtil()
    {
        return HibernateUtil.getSessionFactory();
    }
    
    
}
