/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import managers.AES;
import managers.RandomString;
import managers.UserModel;
import model.HibernateUtil;
import model.TblUser;
import org.apache.tomcat.util.digester.ArrayStack;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Levi Barasa
 */
public class LoginSL {

    public boolean authenticate(String username, String password) {
        HibernateUtilHelper hibernateUtilHelper = new HibernateUtilHelper();
        CRUD crud = new CRUD(hibernateUtilHelper.getHibernateUtil());
        TblUser user = getUserByUserName(username);
        boolean result = false;
        try {
            if (user != null && user.getUsername().equals(username) && user.getPassword().equals(AES.encrypt(password))) {
                result =true;
            } else {
                result = false;
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public TblUser getUserByUserName(String username) {
        HibernateUtilHelper hibernateUtilHelper = new HibernateUtilHelper();
        CRUD crud = new CRUD(hibernateUtilHelper.getHibernateUtil());
        List<TblUser> user = crud.findByQueryString(username, "FROM TblUser where username =:qs");
        return user.get(0);
    }



    public List<UserModel> getListOfUsers() {
        HibernateUtilHelper hibernateUtilHelper = new HibernateUtilHelper();
        CRUD crud = new CRUD(hibernateUtilHelper.getHibernateUtil());
        List<Object> userList = crud.getObject("FROM TblUser");
        List<UserModel> formattedUserModels = new ArrayStack<UserModel>();
         RandomString string = new RandomString(8);
        for (Object users : userList) {
            TblUser tblUser = (TblUser) users;
            UserModel userModel = new UserModel();
            userModel.setId(tblUser.getId());
            userModel.setFirstName(tblUser.getFirstName());
            userModel.setLastName(tblUser.getLastName());
            userModel.setEmail(tblUser.getEmail());
            userModel.setPhone(tblUser.getPhone());
            userModel.setUsername("u");
           // userModel.setPassword("!@#");
            userModel.setGender(tblUser.getGender());
            userModel.setDob(tblUser.getDob());
            userModel.setActivationCode(tblUser.getActivationCode());
           // userModel.setActivationCode(tblUser.getActivationCode());
            userModel.setStatus(tblUser.isStatus());
            formattedUserModels.add(userModel);
        }
        return formattedUserModels;
    }
}
