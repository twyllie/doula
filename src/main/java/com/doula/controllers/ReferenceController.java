package com.doula.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doula.models.Definition;

/*
 * Description of functions:
 * Controls /reference, /reference/<uid>, /blog, /blog/<uid>.
 */

@Controller
public class ReferenceController extends AbstractController {

	@RequestMapping(value = "/reference", method = RequestMethod.GET)
	public String reference(Model model){
		List<Definition> definitions = definitionDao.findAll();
		model.addAttribute("definitions", definitions);
		return "reference";
	}

	@RequestMapping(value = "/reference/{uid}")
	public String singleReference(@PathVariable int uid, Model model){
		model.addAttribute("definition", definitionDao.findByUid(uid));
		return "single_reference";
	}
}