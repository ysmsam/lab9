package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import models.Role;
import models.User;
import services.AccountService;

/**
 *
 * @author Administrater
 */
public class AdminFilter implements Filter {

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)                                                  
            throws IOException, ServletException {
        
        // when it call this doFilter, it sends servlets request and response
        //which is not gonna give you the access to the session
        //or it is not gonna give you a proper method
        //so what i have to do is to Cast ServletRequest and ServletResponse
        //to http servlet reqeust and response      
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        
        //Check if the user is an admin or not.
        //here to add code: to do an if statement, and if true call doFilter, if false do a redicret to login page
        
        String email = (String)session.getAttribute("email");
//        String password = (String)session.getAttribute("password");
        
        AccountService userLogin = new AccountService();
        User loginUser = userLogin.login(email, "password");
        Role role = new Role();
        
        if(loginUser != null && loginUser.getRole().getRoleId()==1){
            
            //execute the servlet which mapping to (AdminServlet)
            chain.doFilter(request, response);
        }else{
            httpResponse.sendRedirect("login");
        }
        session.invalidate();
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        

    }
    
}
