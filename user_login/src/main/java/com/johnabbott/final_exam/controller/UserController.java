package com.johnabbott.final_exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.johnabbott.final_exam.model.UserEntity;
import com.johnabbott.final_exam.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping("/testmethod")
	public ModelAndView getEmail() {
		ModelAndView mv = new ModelAndView("test-jsp");
		mv.addObject("obj", "peng");

		return mv;
	}

	@RequestMapping(value = "/getusers", method = RequestMethod.GET)
	public ModelAndView getUsersList() {
		ModelAndView modelView = new ModelAndView("user-list");

		List<UserEntity> users = service.getUsers();
		modelView.addObject("userList", users);
		modelView.addObject("user", new UserEntity());

		return modelView;
	}


	@RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
	public ModelAndView getUser(@PathVariable("email") String userEmail) {
		ModelAndView modelView = new ModelAndView("user");
		modelView.addObject("userEmail", userEmail);

		return modelView;
	}

	@RequestMapping(value = "addUser")
	public ModelAndView addUser() {
		ModelAndView mv = new ModelAndView("add-user");
		mv.addObject("user", new UserEntity());
		return mv;
	}
	
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") UserEntity user) {
		if (service.addUser(user))
			return "redirect:/users/getusers";
		else {
			return "ErrorPage";
		}
	}

	@RequestMapping(value = "deleteUser")
	public String deleteUser(@RequestParam("userId") int userId) {
		if (service.deleteUser(userId)) {
			return "redirect:/users/getusers";
		}
		else {
			return "ErrorPage";
		}
	}

	@RequestMapping(value = "editUser")
	public ModelAndView editUser(@RequestParam("userId") int userId) {
		ModelAndView mv = new ModelAndView("update-user");
		UserEntity fetchedUser = service.getUserById(userId);
		mv.addObject("editeduser", fetchedUser);
		return mv;
	}

	@RequestMapping(value = "updateUser")
	public String updateUser(@ModelAttribute("user") UserEntity user) {
		if (service.updateUser(user)) {
			return "redirect:/users/getusers";
		} else {
			return "ErrorPage";
		}
	}

}
