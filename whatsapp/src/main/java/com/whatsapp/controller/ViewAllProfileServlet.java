package com.whatsapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whatsapp.entity.WhatsappUser;
import com.whatsapp.service.WhatsappService;
import com.whatsapp.service.WhatsappServiceInterface;

public class ViewAllProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WhatsappServiceInterface ws=new WhatsappService();
		List<WhatsappUser> alldetails=ws.viewAllProfileService();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(alldetails.size()>0) {
				out.println(alldetails.size()+" Profile found <br>");
				for(WhatsappUser ww:alldetails) {
					out.println("*************************");
					out.println("<br>Name is "+ww.getName());
					out.println("<br>Password is "+ww.getPassword());
					out.println("<br>Email is "+ww.getEmail());
					out.println("<br>Address is "+ww.getAddress());
				}
				
				
			}
			else {
				out.println("no Profile found");
			}
		out.println("</body></html>");
	}

}













