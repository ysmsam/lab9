/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.AccountService;
import services.GmailService;

/**
 *
 * @author Administrater
 */
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        session.invalidate(); // just by going to the login page the user is logged out :-) 
//        
//        Cookie[] cookies = request.getCookies();
//        String email = CookieUtil.getCookieValue(cookies, "email");
//        request.setAttribute("email", email);
//        
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        
        AccountService as = new AccountService();
//        String path = getServletContext().getRealPath("/WEB-INF");
        User user = new User(email);
        
//        Boolean checkUserEmail = as.forgotPassword(email, path);
        Boolean checkUserEmail = as.forgotPassword(email);
        
        if(checkUserEmail){
            request.setAttribute("alert", "Email sent");
        }else{
            request.setAttribute("alert", "If the address you entered is valid, you will receive an email very soon. Please check your email for your password.");
        }
        

    getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }

}
