package com.whatsappboot.service;

import java.util.List;

import com.whatsappboot.entity.WhatsappUser;

public interface WhatsappServiceInterface {

	int createProfileService(WhatsappUser wu);

	WhatsappUser viewProfile(String email);

	List<WhatsappUser> viewAllProfile();

	String deleteProfile(String email);

	String editProfile(WhatsappUser wu);

	String loginService(String email, String password);

}
