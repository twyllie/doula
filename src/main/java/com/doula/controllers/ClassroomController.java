package com.doula.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doula.models.Lesson;

@Controller
public class ClassroomController extends AbstractController {

	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String dashboard(Model model){
		
		return "dashboard";
	}

	
	
	@RequestMapping(value = "/classroom", method = RequestMethod.GET)
	public String classRoom(){
		Lesson lesson = lessonDao.findByOrderId(1);
		int uid = lesson.getUid();
		return "redirect: /classroom/"+ uid;
	}
	
	
	
	@RequestMapping(value = "/classroom/{uid}", method = RequestMethod.GET)
	public String classRoomLesson(Model model, @PathVariable int uid){
		List<Lesson> orderedLessons = lessonDao.findAllByOrderByOrderId();
		model.addAttribute("lessons", orderedLessons);
		Lesson singleLesson = lessonDao.findByUid(uid);
		model.addAttribute("single_lesson", singleLesson);
		return "class";
	}
}
