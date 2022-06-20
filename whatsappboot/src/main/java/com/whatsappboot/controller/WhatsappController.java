package com.whatsappboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.whatsappboot.entity.WhatsappUser;
import com.whatsappboot.service.WhatsappServiceInterface;

@RestController
public class WhatsappController {
	
	@Autowired
	private WhatsappServiceInterface ws;

	@PostMapping("createProfile")
	public String createProfile(@RequestBody WhatsappUser wu) {
		int b=ws.createProfileService(wu);
		if(b>0) {
			return "profile created for "+wu.getEmail();
		}
		else {
			return "could not create";
		}
	}
	
	@GetMapping("viewProfile/{id}")
	public WhatsappUser viewProfile(@PathVariable("id") String email) {
		return ws.viewProfile(email);
	}
	
	@GetMapping("viewAllProfile")
	public List<WhatsappUser> viewAllProfile() {
		return ws.viewAllProfile();
	}
	
	@DeleteMapping("deleteProfile/{id}")
	public String deleteProfile(@PathVariable("id") String email) {
		return ws.deleteProfile(email);
	}
	
	@PutMapping("editProfile/{id}")
	public String editProfile(@PathVariable("id") String email,@RequestBody  WhatsappUser wu) {
		wu.setEmail(email);
		return ws.editProfile(wu);
	}
	
	@GetMapping("loginUser/{id}/{password}")
	public String login(@PathVariable("id") String email,@PathVariable("password") String password) {
		return ws.loginService(email,password);
	}
	
	
}











