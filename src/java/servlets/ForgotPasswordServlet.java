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
//        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        
        AccountService as = new AccountService();
        String path = getServletContext().getRealPath("/WEB-INF");
        User user = new User(email);
        
        if(as.forgotPassword(email, path)){
            request.setAttribute("alert", "Email sent");
//            GmailService gs = new GmailService();
//            try {
//                gs.sendMail(email, "Password Reset", "Your password is reset to passord", false);
//            } catch (MessagingException ex) {
//                Logger.getLogger(ForgotPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (NamingException ex) {
//                Logger.getLogger(ForgotPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }else{
            request.setAttribute("alert", "If the address you entered is valid, you will receive an email very soon. Please check your email for your password.");
        }
        
        // save email to a cookie
//        Cookie cookie = new Cookie("email", email);
//        cookie.setMaxAge(60 * 60 * 24 * 365 * 3);
//        response.addCookie(cookie);
//        
//        String path = getServletContext().getRealPath("/WEB-INF");
//        
//        if (user == null) {
//            request.setAttribute("email", email);
//            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//            return;
//        }
//        
//        HttpSession session = request.getSession();
//        session.setAttribute("email", email);
//        
//        if (user.getRole().getRoleId() == 1) {
//            response.sendRedirect("admin");
//        } else {
//            response.sendRedirect("notes");
//        }
    }

}
