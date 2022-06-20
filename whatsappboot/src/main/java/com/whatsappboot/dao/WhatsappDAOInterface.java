package com.whatsappboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.whatsappboot.entity.WhatsappUser;

@Repository
public interface WhatsappDAOInterface extends JpaRepository<WhatsappUser, String>{

	@Query("from com.whatsappboot.entity.WhatsappUser w where w.email=:em and w.password=:pw")
	WhatsappUser loginProfile(@Param("em") String email, @Param("pw") String password);

}
