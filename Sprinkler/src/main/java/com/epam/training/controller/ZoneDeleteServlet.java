package com.epam.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.training.sprinkler.domain.Zone;

@WebServlet("/admin/zone/delete")
public class ZoneDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strId = (String) req.getParameter("id");
		List<Zone> zones = (List<Zone>) getServletContext().getAttribute("zones");
		int id = Integer.parseInt(strId);
		System.out.println(id);
		if (zones != null) {
			Zone zoneToDelete = null;
			for (Zone zone : zones) {
				if (zone.getId() == id) {
					zoneToDelete = zone;
				}
			}
			zones.remove(zoneToDelete);
		}
		resp.sendRedirect("/Sprinkler/admin/zone/list");

	}
}