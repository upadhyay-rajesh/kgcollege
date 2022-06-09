package com.whatsapp.service;

import java.util.List;

import com.whatsapp.dao.WhatsappDAO;
import com.whatsapp.dao.WhatsappDAOInterface;
import com.whatsapp.entity.WhatsappUser;

public class WhatsappService implements WhatsappServiceInterface {

	public int createProfileService(WhatsappUser wu) {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.createProfileDAO(wu);
	}

	public boolean loginProfileService(WhatsappUser wu) {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.loginProfileDAO(wu);
	}

	public WhatsappUser viewProfileService(WhatsappUser wu) {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.viewProfileDAO(wu);
	}

	public int deleteProfileService(WhatsappUser wu) {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.deleteProfileDAO(wu);
	}

	public List<WhatsappUser> viewAllProfileService() {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.viewAllProfileDAO();
	}

}






