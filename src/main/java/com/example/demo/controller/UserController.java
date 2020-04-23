package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	UserRepository repository;
	@GetMapping("/insert")
	public String getuserDetails(Model thymModel)
	{
		
		thymModel.addAttribute("user",repository.findAll().get(0));
    	thymModel.addAttribute("user1",repository.findAll().get(1));
		thymModel.addAttribute("user2",repository.findAll().get(2));
		thymModel.addAttribute("user3",repository.findAll().get(3));
		thymModel.addAttribute("user4",repository.findAll().get(4));
		
		thymModel.addAttribute("username", "Balaji");
		thymModel.addAttribute("copyright"," You are authorised...");
		return "user/ShowUser";
		//return "user/ShowUser"+"user1/ShowUser"+"user2/ShowUser"+"user3/ShowUser"+"user4/ShowUser";
	}
	
	@GetMapping("/allUser")
    public String userData(Model model){
        List<User> allEntries = repository.findAll();
        model.addAttribute("entries", allEntries);
        return "entries/UserShow";
    }
	
	
	
}
