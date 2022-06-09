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

public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("em");
		String password=request.getParameter("pass");
		
		WhatsappUser wu=new WhatsappUser();
		wu.setEmail(email);
		wu.setPassword(password);
		
		WhatsappServiceInterface ws=new WhatsappService();
		boolean b=ws.loginProfileService(wu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(b) {
				
				HttpSession hs=request.getSession(true);
				//hs.setMaxInactiveInterval(2);
				
				hs.setAttribute("uid", email);
				
				
				out.println("Welcome "+email);
				out.println("<a href=ViewProfileServlet> view profile</a>");
				out.println("<a href=EditProfileServlet> Edit profile</a>");
				out.println("<a href=DeleteProfileServlet> Delete profile</a>");
				out.println("<a href=SearchProfileServlet> Search profile</a>");
				out.println("<a href=ViewAllProfileServlet> View All profile</a>");
			}
			else {
				out.println("Invalid Id and Password");
			}
		out.println("</body></html>");
	}

}












