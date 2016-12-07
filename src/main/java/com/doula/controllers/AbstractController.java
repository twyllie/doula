package com.doula.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.doula.models.dao.ArticleDao;
import com.doula.models.dao.DefinitionDao;
import com.doula.models.dao.LessonDao;
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
	

}
