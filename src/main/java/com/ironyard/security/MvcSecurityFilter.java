package com.ironyard.security;

import com.ironyard.data.IronUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jasonskipper on 10/31/16.
 */
public class MvcSecurityFilter implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = ((HttpServletRequest) request);
        HttpServletResponse resp = ((HttpServletResponse) response);
        // check sessio
        IronUser usr = (IronUser) req.getSession().getAttribute("user");
        boolean authorized = (usr != null);

        if(authorized) {
            chain.doFilter(request, response);
        }else{
            resp.sendRedirect("/mvc/open/login.jsp");
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}