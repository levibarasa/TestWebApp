/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import model.TblUser;

/**
 *
 * @author Levi Barasa
 */
public class RegisterSL {
    HibernateUtilHelper hibernateUtilHelper = new HibernateUtilHelper();
    CRUD crud = new CRUD(hibernateUtilHelper.getHibernateUtil());
    
    public boolean register(TblUser tblUser){
        crud.save(tblUser);
        return true;
    }
    public boolean updateUser(TblUser tblUser){
        tblUser.setUsername(null);
        crud.save(tblUser);
        return true;
    }
    public boolean isUserExists(TblUser tblUser){
     List users = crud.getObject("FROM TblUser where email ='"+tblUser.getEmail()+"'");
        return users.size() > 0 ? true : false;
    }
    
}
