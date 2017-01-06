package com.doula;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.doula.controllers.AbstractController;
import com.doula.models.User;
import com.doula.models.dao.UserDao;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        List<String> authPages = Arrays.asList("/home", "/plan", "/class", "/reference", "/blog");

        if ( authPages.contains(request.getRequestURI()) ) {

        	boolean isLoggedIn = false;
        	User user;
            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null) {
            	user = userDao.findByUid(userId);
            	
            	if (user != null) {
            		isLoggedIn = true;
            	}
            }

            if (!isLoggedIn) {
                response.sendRedirect("/login");
                return false;
            }
        }

        return true;
    }

}