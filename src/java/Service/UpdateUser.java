/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import managers.UserModel;
import model.TblUser;

/**
 *
 * @author Levi Barasa
 */
public class UpdateUser {
    
HibernateUtilHelper hibernateUtilHelper = new HibernateUtilHelper();
    CRUD crud = new CRUD(hibernateUtilHelper.getHibernateUtil());
   public boolean updateUser(TblUser tblUser){
        tblUser.setUsername(null);
        crud.saveOrUpdate(tblUser);
        return true;
    }
}
