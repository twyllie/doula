package com.doula.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doula.models.Article;
import com.doula.models.Definition;
import com.doula.models.Lesson;

@Controller
public class AdminController extends AbstractController {

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminForm(){
		return "admin";
	}
	
	@RequestMapping(value = "/admin/create", method = RequestMethod.GET)
	public String adminCreateForm(Model model){
		List<Lesson> orderedLessons = lessonDao.findAllOrderByOrderIdAsc();
		model.addAttribute("orderedLessons", orderedLessons);
		return "admin_create";
	}
	
	@RequestMapping(value = "/admin/create", method = RequestMethod.PUT)
	public String adminCreate(HttpServletRequest request ,Model model){
		String type = request.getParameter("type");
		String title;
		String body;
		switch(type){
			case "article":
				title = request.getParameter("title");
				body = request.getParameter("body");
				Article article = new Article(title, body);
				boolean image1 = Boolean.parseBoolean("image1"), image2 = Boolean.parseBoolean("image2"), image3 = Boolean.parseBoolean("image3");
				if(image1){
					String thumbnailRef = request.getParameter("thumbnailRef");
					article.setThumbnailRef(thumbnailRef);
				}
				if(image2){
					String headerRef = request.getParameter("headerRef");
					article.setHeaderRef(headerRef);
				}
				if(image3){
					String bodyImageRef = request.getParameter("bodyImageRef");
					article.setBodyImageRef(bodyImageRef);
				}
				articleDao.save(article);
				return "redirect:/admin";
			case "definition":
				title = request.getParameter("title");
				body = request.getParameter("body");
				Definition def = new Definition(title, body);
				definitionDao.save(def);
				return "redirect:/admin";
			case "lesson":
				title = request.getParameter("title");
				body = request.getParameter("body");
				int oid = Integer.parseInt(request.getParameter("oid"));
				String videoRef = request.getParameter("videoRef");
				Lesson lesson = new Lesson(title, body, oid, videoRef);
				lessonDao.save(lesson);
				return "redirect:/admin";
			default:
				break;
		}
		return "admin_create";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateForm(){
		return "admin_update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, Model model){
		return "admin_update";
	}
}
