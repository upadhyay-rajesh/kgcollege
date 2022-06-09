package com.whatsapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.whatsapp.entity.WhatsappUser;
import com.whatsapp.service.WhatsappService;
import com.whatsapp.service.WhatsappServiceInterface;

public class ViewProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession(true);
		String email=hs.getAttribute("uid").toString();
		
		WhatsappUser wu=new WhatsappUser();
		wu.setEmail(email);
		
		WhatsappServiceInterface ws=new WhatsappService();
		WhatsappUser ww=ws.viewProfileService(wu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(ww!=null) {
				out.println("Profile details is <br>");
				out.println("Name is "+ww.getName());
				out.println("Password is "+ww.getPassword());
				out.println("Email is "+ww.getEmail());
				out.println("Address is "+ww.getAddress());
			}
			else {
				out.println("Profile not found");
			}
		out.println("</body></html>");
	}

}




