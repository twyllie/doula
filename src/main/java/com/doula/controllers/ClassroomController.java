package com.doula.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doula.models.Headline;
import com.doula.models.Lesson;

@Controller
public class ClassroomController extends AbstractController {

	
	
	@RequestMapping(value = "/u/home", method = RequestMethod.GET)
	public String dashboard(Model model){
		List<Headline> headlines = headlineDao.findAll();
		if(!headlines.isEmpty()){
			model.addAttribute("headline", headlines.get(0));
		}
		return "dashboard";
	}

	
	
	@RequestMapping(value = "/u/classroom", method = RequestMethod.GET)
	public String classRoom(){
		List<Lesson> lessons = lessonDao.findAllByOrderByOrderId();
		int uid = lessons.get(0).getUid();
		return "redirect:/u/classroom/"+ uid;
	}
	
	
	
	@RequestMapping(value = "/u/classroom/{uid}", method = RequestMethod.GET)
	public String classRoomLesson(Model model, @PathVariable int uid){
		List<Lesson> orderedLessons = lessonDao.findAllByOrderByOrderId();
		model.addAttribute("lessons", orderedLessons);
		Lesson singleLesson = lessonDao.findByUid(uid);
		model.addAttribute("single_lesson", singleLesson);
		return "classroom";
	}
}
