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
import com.doula.models.Headline;
import com.doula.models.Lesson;

@Controller
public class AdminController extends AbstractController {

	
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminForm(Model model){
		return "admin";
	}
	
	
	
	@RequestMapping(value = "/admin/create", method = RequestMethod.GET)
	public String adminCreateForm(Model model){
		List<Lesson> orderedLessons = lessonDao.findAllByOrderByOrderId();
		model.addAttribute("orderedLessons", orderedLessons);
		return "admin_create_query";
	}
	
	
	
	@RequestMapping(value = "/admin/create", method = RequestMethod.POST)
	public String adminCreate(HttpServletRequest request ,Model model){
		String type = request.getParameter("type");
		switch(type){
			case "article":
				return "redirect:/admin/create/article";
			case "definition":
				return "redirect:/admin/create/definition";
			case "lesson":
				return "redirect:/admin/create/lesson";
			default:
				break;
		}
		return "admin_create";
	}
	
	
	
	@RequestMapping(value = "/admin/create/article", method = RequestMethod.GET)
	public String adminCreateArticleForm(){
		return "admin_create_article";
	}
	
	
	
	@RequestMapping(value = "/admin/create/article", method = RequestMethod.POST)
	public String adminCreateArticle(HttpServletRequest request, Model model){
		String title = request.getParameter("title");
		String headline = request.getParameter("headline");
		String body = request.getParameter("body");
		boolean error = false;
		String title_error;
		String headline_error;
		String body_error;
		
		
		if(title.isEmpty()){
			title_error = "Title field can not be empty";
			model.addAttribute("title_error", title_error);
			error = true;
		}
		if(headline.isEmpty()){
			headline_error = "Headline field can not be empty";
			model.addAttribute("headline_error", headline_error);
			error = true;
		}
		if(body.isEmpty()){
			body_error = "Body field can not be empty";
			model.addAttribute("body_error", body_error);
			error = true;
		}
		
		if(error){
			model.addAttribute("title", title);
			model.addAttribute("headline", headline);
			model.addAttribute("body", body);
			return "admin_create_article";
		}else{
			Article article = new Article(title, headline, body);
			articleDao.save(article);
			return "redirect:/admin/article/" + article.getUid();
		}
	}
	
	
	
	@RequestMapping(value = "/admin/create/definition", method = RequestMethod.GET)
	public String adminCreateDefinitionForm(){
		return "admin_create_definition";
	}
	
	
	
	@RequestMapping(value = "/admin/create/definition", method = RequestMethod.POST)
	public String adminCreateDefinition(HttpServletRequest request, Model model){
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String title_error;
		String body_error;
		boolean error = false;
		
		if(title.isEmpty()){
			title_error = "Title field can not be empty";
			model.addAttribute("title_error", title_error);
			error = true;
		}
		if(body.isEmpty()){
			body_error = "Body field can not be empty";
			model.addAttribute("body_error", body_error);
			error = true;
		}

		if(error){
			model.addAttribute("title" , title);
			model.addAttribute("body", body);
			return "admin_create_definition";
		}else{
			Definition definition = new Definition(title, body);
			definitionDao.save(definition);
			return "redirect:/admin/definition/" + definition.getUid();
		}
	}
	
	
	
	@RequestMapping(value = "/admin/create/lesson", method = RequestMethod.GET)
	public String adminCreateLessonForm(){
		return "admin_create_lesson";
	}
	
	
	
	@RequestMapping(value = "/admin/create/lesson", method = RequestMethod.POST)
	public String adminCreateLesson(HttpServletRequest request, Model model){
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String videoRef = request.getParameter("videoRef");
		String title_error;
		String body_error;
		String videoRef_error;
		boolean error = false;
		
		if(title.isEmpty()){
			title_error = "Title field can not be empty";
			model.addAttribute("title_error", title_error);
			error = true;
		}
		if(body.isEmpty()){
			body_error = "Body field can not be empty";
			model.addAttribute("body_error", body_error);
			error = true;
		}
		if(videoRef.isEmpty()){
			videoRef_error = "You must provide a link to a vimeo video resource.";
			model.addAttribute("videoRef_error", videoRef_error);
			error = true;
		}

		if(error){
			model.addAttribute("title", title);
			model.addAttribute("body", body);
			model.addAttribute("videoRef", videoRef);
			return "admin_create_definition";
		}else{
			Lesson lesson = new Lesson(title, body, 120, videoRef);
			lessonDao.save(lesson);
			return "redirect:/admin/lesson/" + lesson.getUid();
		}
	}
	
	
	
	@RequestMapping(value = "admin/update", method = RequestMethod.GET)
	public String updateSelection(Model model){
		return "admin_update";
	}
	
	
	
	@RequestMapping(value = "admin/update", method = RequestMethod.POST)
	public String updateSelection(HttpServletRequest request, Model model){
		String type = request.getParameter("type");
		String error;
		switch(type){
			case "article":
				List<Article> articles = articleDao.findAllByOrderByCreated();
				model.addAttribute("articles", articles);
				return "admin_update_article_list";
			case "definition":
				List<Definition> definitions = definitionDao.findAllByOrderByCreated();
				model.addAttribute("definitions", definitions);
				return "admin_update_definition_list";
			case "lesson":
				List<Lesson> lessons = lessonDao.findAllByOrderByOrderId();
				model.addAttribute("lessons", lessons);
				return "admin_update_lesson_list";
			case "lessonOrder":
				return "redirect:/admin/update/lessonorder";
			case "headline":
				List<Headline> headlines = headlineDao.findAll();
				if(headlines.isEmpty()){
					Headline headline = new Headline("Welcome!", "Our App has launched! Enjoy the class!");
					headlineDao.save(headline);
					model.addAttribute("headline", headline);
					return "admin_update_headline";
				}
				model.addAttribute("headline", headlines.get(0));
				return "admin_update_headline";
			default:
				break;
		}
		error = "Please select an item from the list.";
		model.addAttribute("error", error);
		return "admin_update";
	}
	
	
	
	@RequestMapping(value="admin/update/headline", method = RequestMethod.POST)
	public String updateHeadlineForm(HttpServletRequest request, Model model){
		int uid = Integer.parseInt(request.getParameter("uid"));
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		Headline headline = headlineDao.findByUid(uid);
		if(!title.isEmpty() && !body.isEmpty()){
			headline.setTitle(title);
			headline.setBody(body);
			headlineDao.save(headline);
			model.addAttribute("headline", headline);
			return "admin_update_headline";
		}
		if(title.isEmpty()){
			model.addAttribute("title_error", "Cannot be empty");
		}
		if(body.isEmpty()){
			model.addAttribute("body_error", "Cannot be empty");
		}
		return "admin_update_headline";
	}
	
	
	
	@RequestMapping(value = "admin/update/article/{uid}", method = RequestMethod.GET)
	public String updateArticleForm(Model model, @PathVariable int uid){
		Article article = articleDao.findByUid(uid);
		model.addAttribute("article", article);
		return "admin_update_article";
	}
	
	
	
	@RequestMapping(value = "admin/update/article/{uid}", method = RequestMethod.POST)
	public String updateArticle(HttpServletRequest request, Model model, @PathVariable int uid){
		String title = request.getParameter("title");
		String headline = request.getParameter("headline");
		String body = request.getParameter("body");
		Article article = articleDao.findByUid(uid);
		if(article.getTitle() != title){
			article.setTitle(title);
		}
		if(article.getHeadline() != headline){
			article.setHeadline(headline);
		}
		if(article.getBody() != body){
			article.setBody(body);
		}
		article.modified();
		articleDao.save(article);
		return "redirect:/admin/article/" + uid;
	}
	
	
	
	@RequestMapping(value = "admin/article/{uid}", method = RequestMethod.GET)
	public String singleArticleView(Model model, @PathVariable int uid){
		Article article = articleDao.findByUid(uid);
		model.addAttribute("article", article);
		return "admin_single_article";
	}
	
	
	
	@RequestMapping(value = "admin/update/definition/{uid}", method = RequestMethod.GET)
	public String updateDefinitionForm(Model model, @PathVariable int uid){
		Definition def = definitionDao.findByUid(uid);
		model.addAttribute("def", def);
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
		model.addAttribute("def", def);
		return "admin_single_definition";
	}
	
	
	
	@RequestMapping(value = "admin/update/lesson/{uid}", method = RequestMethod.GET)
	public String updateLessonForm(HttpServletRequest request, Model model, @PathVariable int uid){
		Lesson lesson = lessonDao.findByUid(uid);
		model.addAttribute("lesson", lesson);
		return "admin_update_lesson";
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
		List<Lesson> lessons = lessonDao.findAllByOrderByOrderId();
		model.addAttribute("lessons", lessons);
		return "admin_update_lesson_order";
	}
	
	
	
	@RequestMapping(value = "admin/update/lessonorder", method = RequestMethod.POST)
	public String updateLessonOrder(HttpServletRequest request, Model model){
		int counter = Integer.parseInt(request.getParameter("counter"));
		System.out.println(counter);
		for(int i=1; i <= counter;i++){
			int uid = Integer.parseInt(request.getParameter("uid"+ i));
			int oid = Integer.parseInt(request.getParameter("newOrder"+i));
			Lesson lesson = lessonDao.findByUid(uid);
			lesson.setOrderId(oid);
			lessonDao.save(lesson);
		}
		return "admin_update_lesson_order";
	}
	
	
	
	@RequestMapping(value = "admin/lesson/{uid}", method = RequestMethod.GET)
	public String singleLessonView(Model model, @PathVariable int uid){
		Lesson lesson = lessonDao.findByUid(uid);
		model.addAttribute("lesson", lesson);
		return "admin_single_lesson";
	}
	
	
	
	@RequestMapping(value = "admin/delete/article/{uid}", method = RequestMethod.GET)
	public String deleteArticle(@PathVariable int uid){
		Article article = articleDao.findByUid(uid);
		articleDao.delete(article);
		return "redirect:/admin?delete";
	}
	
	
	@RequestMapping(value = "admin/delete/definition/{uid}", method = RequestMethod.GET)
	public String deleteDefinition(@PathVariable int uid){
		Definition definition = definitionDao.findByUid(uid);
		definitionDao.delete(definition);
		return "redirect:/admin?delete";
	}
	
	
	
	@RequestMapping(value = "admin/delete/lesson/{uid}", method = RequestMethod.GET)
	public String deleteLesson(@PathVariable int uid){
		Lesson lesson = lessonDao.findByUid(uid);
		lessonDao.delete(lesson);
		List<Lesson> lessons = lessonDao.findAllByOrderByOrderId();
		for(int i = 1; i <= lessons.size(); i++){
			Lesson l = lessons.get(i);
			l.setOrderId(i);
			lessonDao.save(l);
		}
		return "redirect:/admin?delete";
	}
}
