package com.chenx.filter;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.chenx.common.bean.User;
import com.chenx.common.util.JwtUtil;
import com.chenx.common.util.RegexUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminFilter implements Filter {

    private FilterConfig config;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if (config != null) {
            String ignore = config.getInitParameter("Ignore");
            if (RegexUtil.matchStrings(ignore, request.getServletPath())) {
                chain.doFilter(req, resp);
                return;
            }
        }

        String token = request.getHeader("authorization");
        if (token != null) {
            try {
                if (JwtUtil.verityToken(token)) {
                    User user = JwtUtil.stringToUser(token);
                    req.setAttribute("user", user);
                    chain.doFilter(req, response);
                    return;
                }
            } catch (TokenExpiredException e) {
                response.sendRedirect("auth/expired");
            } catch (AlgorithmMismatchException e) {
                response.sendRedirect("auth/error");
            }
        } else {
            response.sendRedirect("auth/exist");
        }


    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
