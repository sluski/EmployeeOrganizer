package organizerpro.pl;

import java.io.IOException;
import organizerpro.pl.binClasses.LoggedUsersBin;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlFilter implements Filter{

        @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, 
            ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        
        LoggedUsersBin userManager = (LoggedUsersBin) httpServletRequest
                .getSession().getAttribute("LoggedUsersBin");
        
        if (userManager != null) {
            if (userManager.isLoggedIn()) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                httpServletResponse.sendRedirect(
                        httpServletRequest.getContextPath()
                                + "userManager.xhtml");
            }
        } else {
            httpServletResponse.sendRedirect(
                    httpServletRequest.getContextPath() + "startpage.xhtml");
        }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}