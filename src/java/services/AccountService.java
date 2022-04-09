package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {
    
    
    public User login(String email, String password) {
        UserDB userDB = new UserDB();

        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }

        return null;
    }
    
        public boolean forgotPassword(String email){
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (user != null) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
                
                String to = user.getEmail();
                String subject = "Password Reset";
//                String template = path + "/emailtemplates/login.html";
//                
//                HashMap<String, String> tags = new HashMap<>();
//                tags.put("firstname", user.getFirstName());
//                tags.put("lastname", user.getLastName());
//                tags.put("date", (new java.util.Date()).toString());

                String body = "Your password is reset to password";
                
//                GmailService.sendMail(to, subject, template, tags);
                GmailService.sendMail(to, subject, body, false);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        }
       
        return false;
    }
    
    public User login(String email, String password, String path) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
                
                String to = user.getEmail();
                String subject = "Notes App Login";
                String template = path + "/emailtemplates/login.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString());
                
                GmailService.sendMail(to, subject, template, tags);
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public boolean forgotPassword(String email, String path){
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (user != null) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
                
                String to = user.getEmail();
                String subject = "Password Reset";
//                String template = path + "/emailtemplates/login.html";
//                
//                HashMap<String, String> tags = new HashMap<>();
//                tags.put("firstname", user.getFirstName());
//                tags.put("lastname", user.getLastName());
//                tags.put("date", (new java.util.Date()).toString());

                String body = "Your password is reset to password";
                
//                GmailService.sendMail(to, subject, template, tags);
                GmailService.sendMail(to, subject, body, false);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        }
       
        return false;
    }
}
