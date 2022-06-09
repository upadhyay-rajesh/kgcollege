package com.whatsapp.service;

import java.util.List;

import com.whatsapp.entity.WhatsappUser;

public interface WhatsappServiceInterface {

	int createProfileService(WhatsappUser wu);

	boolean loginProfileService(WhatsappUser wu);

	WhatsappUser viewProfileService(WhatsappUser wu);

	int deleteProfileService(WhatsappUser wu);

	List<WhatsappUser> viewAllProfileService();

	

}
