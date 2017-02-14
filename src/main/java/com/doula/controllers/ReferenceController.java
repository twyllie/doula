package com.doula.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doula.models.Article;
import com.doula.models.Definition;

/*
 * Description of functions:
 * Controls /reference, /reference/<uid>, /blog, /blog/<uid>.
 */

@Controller
public class ReferenceController extends AbstractController {

	@RequestMapping(value = "/reference", method = RequestMethod.GET)
	public String reference(Model model){
		List<Definition> definitions = definitionDao.findAllOrderByCreated();
		model.addAttribute("definitions", definitions);
		return "reference";
	}

	@RequestMapping(value = "/reference/{uid}", method = RequestMethod.GET)
	public String singleReference(@PathVariable int uid, Model model){
		model.addAttribute("def", definitionDao.findByUid(uid));
		return "single_reference";
	}

	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String blog(Model model){
		List<Article> articles = articleDao.findAllOrderByCreated();
		model.addAttribute("articles", articles);
		return "blog";
	}
	
	@RequestMapping(value = "/blog/{uid}", method = RequestMethod.GET)
	public String singleArticle(@PathVariable int uid, Model model){
		model.addAttribute("article", articleDao.findByUid(uid));
		return "single_article";
	}
}