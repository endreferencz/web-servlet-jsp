package com.epam.training.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.training.sprinkler.domain.Zone;


@WebServlet("/admin/zone/list")
public class ZoneListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Zone> zones = (List<Zone>)getServletContext().getAttribute("zones");
		if(zones == null){
			zones = new ArrayList<>();
		}
		req.setAttribute("zones", zones);
		req.getRequestDispatcher("views/list.jsp").forward(req, resp);
		
	}
}
