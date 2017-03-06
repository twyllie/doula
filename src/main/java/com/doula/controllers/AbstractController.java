package com.doula.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.doula.models.User;
import com.doula.models.dao.ArticleDao;
import com.doula.models.dao.DefinitionDao;
import com.doula.models.dao.LessonDao;
import com.doula.models.dao.PlanDao;
import com.doula.models.dao.UserDao;

public abstract class AbstractController {

	
	
	@Autowired
	protected ArticleDao articleDao;
	
	
	
	@Autowired
	protected DefinitionDao definitionDao;

	
	
	@Autowired
	protected LessonDao lessonDao;
	
	
	
	@Autowired
	protected UserDao userDao;
	
	
	
	@Autowired
	protected PlanDao planDao;
	
	
	
    public static final String userSessionKey = "user_id";

    
    
    protected User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findByUid(userId);
    }
    
    
    
    
    protected void setUserInSession(HttpSession session, User user) {
    	session.setAttribute(userSessionKey, user.getUid());
    }

}
