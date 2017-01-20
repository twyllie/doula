package com.doula.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
				String headline = request.getParameter("headline");
				body = request.getParameter("body");
				Article article = new Article(title, headline, body);
				//TODO: Figure out images
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
	
	@RequestMapping(value = "admin/update", method = RequestMethod.GET)
	public String updateSelection(){
		return "admin_update";
	}
	
	@RequestMapping(value = "admin/update", method = RequestMethod.POST)
	public String updateSelection(HttpServletRequest request, Model model){
		String type = request.getParameter("type");
		switch(type){
			case "article":
				List<Article> articles = articleDao.findAll();
				model.addAttribute("articles", articles);
				break;
			case "definition":
				List<Definition> definitions = definitionDao.findAll();
				model.addAttribute("definitions", definitions);
				break;
			case "lesson":
				List<Lesson> lessons = lessonDao.findAllOrderByOrderIdAsc();
				model.addAttribute("lessons", lessons);
				break;
			default:
				break;
		}
		return "admin_update";
	}
	
	@RequestMapping(value = "admin/update/article/{uid}", method = RequestMethod.GET)
	public String updateArticleForm(Model model, @PathVariable int uid){
		Article article = articleDao.findByUid(uid);
		model.addAttribute("title", article.getTitle());
		model.addAttribute("body", article.getBody());
		//TODO: Figure out images
		return "admin_update_article";
	}
	
	@RequestMapping(value = "admin/update/article/{uid}", method = RequestMethod.POST)
	public String updateArticle(HttpServletRequest request, Model model, @PathVariable int uid){
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		Article article = articleDao.findByUid(uid);
		article.setBody(body);
		article.setTitle(title);
		article.modified();
		articleDao.save(article);
		//TODO: Figure out images
		return "redirect:/admin/article/" + uid;
	}
	
	@RequestMapping(value = "admin/article/{uid}", method = RequestMethod.GET)
	public String singleArticleView(Model model, @PathVariable int uid){
		Article article = articleDao.findByUid(uid);
		model.addAttribute("title", article.getTitle());
		model.addAttribute("body", article.getBody());
		return "admin_single_article";
	}
	
	@RequestMapping(value = "admin/update/definition/{uid}", method = RequestMethod.GET)
	public String updateDefinitionForm(Model model, @PathVariable int uid){
		Definition def = definitionDao.findByUid(uid);
		model.addAttribute("title", def.getTitle());
		model.addAttribute("body", def.getBody());
		return "admin_update_definition";
	}
	
	@RequestMapping(value = "admin/update/definition/{uid}", method = RequestMethod.POST)
	public String updateDefinition(HttpServletRequest request, Model model, @PathVariable int uid){
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		Definition def = definitionDao.findByUid(uid);
		def.setTitle(title);
		def.setBody(body);
		def.modified();
		definitionDao.save(def);
		return "redirect:/admin/definition/" + uid;
	}
	
	@RequestMapping(value = "admin/definition/{uid}", method = RequestMethod.GET)
	public String singleDefinitionView(Model model, @PathVariable int uid){
		Definition def = definitionDao.findByUid(uid);
		model.addAttribute("title", def.getTitle());
		model.addAttribute("body", def.getBody());
		return "admin_single_definition";
	}
	
	@RequestMapping(value = "admin/update/lesson/{uid}", method = RequestMethod.GET)
	public String updateLessonForm(HttpServletRequest request, Model model, @PathVariable int uid){
		Lesson lesson = lessonDao.findByUid(uid);
		model.addAttribute("title", lesson.getTitle());
		model.addAttribute("body", lesson.getBody());
		model.addAttribute("videoRef", lesson.getVideoRef());
		model.addAttribute("orderId", lesson.getOrderId());
		return "admin_update_single";
	}
	
	@RequestMapping(value = "admin/update/lesson/{uid}", method = RequestMethod.POST)
	public String updateLesson(HttpServletRequest request, Model model, @PathVariable int uid){
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String videoRef = request.getParameter("videoRef");
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		Lesson lesson = lessonDao.findByUid(uid);
		lesson.setTitle(title);
		lesson.setBody(body);
		lesson.setVideoRef(videoRef);
		lesson.setOrderId(orderId);
		lesson.modified();
		lessonDao.save(lesson);
		return "redirect:/admin/lesson/" + uid;
	}
	
	@RequestMapping(value = "admin/update/lessonorder", method = RequestMethod.GET)
	public String updateLessonOrderForm(Model model){
		List<Lesson> lessons = lessonDao.findAllOrderByOrderIdAsc();
		model.addAttribute("lessons", lessons);
		return "admin_update_lesson_order";
	}
	
	@RequestMapping(value = "admin/update/lessonorder", method = RequestMethod.POST)
	public String updateLessonOrder(HttpServletRequest request, Model model){
		//TODO: Implement
		return "admin_update_lesson_order";
	}
	
	@RequestMapping(value = "admin/lesson/{uid}", method = RequestMethod.GET)
	public String singleLessonView(Model model, @PathVariable int uid){
		Lesson lesson = lessonDao.findByUid(uid);
		model.addAttribute("title", lesson.getTitle());
		model.addAttribute("body", lesson.getBody());
		model.addAttribute("videoRef", lesson.getVideoRef());
		model.addAttribute("orderId", lesson.getOrderId());
		return "admin_single_lesson";
	}
}
