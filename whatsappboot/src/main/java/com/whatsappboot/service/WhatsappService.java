package com.whatsappboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatsappboot.dao.WhatsappDAOInterface;
import com.whatsappboot.entity.WhatsappUser;

@Service
@Transactional
public class WhatsappService implements WhatsappServiceInterface {

	@Autowired 
	private WhatsappDAOInterface wd;
	
	@Override
	public int createProfileService(WhatsappUser wu) {
		wd.save(wu);
		return 1;
	}

	@Override
	public WhatsappUser viewProfile(String email) {
		Optional<WhatsappUser> oo=wd.findById(email);
		return oo.get();
	}

	@Override
	public List<WhatsappUser> viewAllProfile() {
		// TODO Auto-generated method stub
		return wd.findAll();
	}

	@Override
	public String deleteProfile(String email) {
		// TODO Auto-generated method stub
		wd.deleteById(email);
		return "profile deleted";
	}

	@Override
	public String editProfile(WhatsappUser wu) {
		wd.saveAndFlush(wu);
		return "profile edited";
	}

	@Override
	public String loginService(String email, String password) {
		// TODO Auto-generated method stub
		WhatsappUser ww=wd.loginProfile(email,password);
		if(ww!=null) {
			return "login success";
		}
		return "login fail";
	}

}





