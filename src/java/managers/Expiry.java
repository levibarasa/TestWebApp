/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 *
 * @author Levi Barasa
 */
public class Expiry {
    String message ="";
    public Expiry(){}
    public String getSession(String link){
        try{
   URL url = new URL(link);
    HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
    long date = httpCon.getExpiration();
    if (date == 0)
      message ="Expired";
    else
      message ="Expire in "+new Date();
        }
        catch(Exception ex){}
        return message;
    }
}
