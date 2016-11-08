package com.epam.sprinkler.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.sprinkler.entity.Zone;

public class ZoneModifyServlet extends HttpServlet {

	private static final String ID_TO_MODIFY_PARAMETER = "idToModify";
	private static final String NAME_PARAMETER = "zonename";
	private static final String CONSUMPTION_PARAMETER = "consumption";
	private static final String ID_PARAMETER = "id";
	private boolean error = false;
	int oldId;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter(ID_PARAMETER));
		oldId = id;
		List<Zone> zones = (List<Zone>) getServletContext().getAttribute("zones");
		Zone zoneToModify = null;
		for (int i = 0; i < zones.size() && zoneToModify == null; i++) {
			if (zones.get(i).getId() == id) {
				zoneToModify = zones.get(i);
			}
		}
		if (error) {
			req.setAttribute("error", "Last add attempt failed because one of the parameteres were wrong.");
		}
		req.setAttribute("zoneToModify", zoneToModify);
		req.getRequestDispatcher("/admin/zone/views/modify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		error = false;
		try {
			int id = Integer.parseInt(req.getParameter(ID_PARAMETER));
			String name = req.getParameter(NAME_PARAMETER);
			double consumption = Double.parseDouble(req.getParameter(CONSUMPTION_PARAMETER));
			Zone zone = new Zone(id, name, consumption);
			updateZones(zone, oldId);
			res.sendRedirect(res.encodeURL(req.getContextPath() + "/admin/zone/list"));
		} catch (NumberFormatException e) {
			error = true;
			res.sendRedirect(res.encodeURL(req.getContextPath() + "/admin/zone/modify?id=" + oldId));
		}
	}

	private void updateZones(Zone zone, int id) {
		List<Zone> zones = getZones();
		boolean found = false;
		for (int i = 0; i < zones.size() && !found; i++) {
			Zone current = zones.get(i);
			if (current.getId() == id) {
				found = true;
				current.setId(zone.getId());
				current.setConsumption(zone.getConsumption());
				current.setName(zone.getName());
			}
		}
	}

	private List<Zone> getZones() {
		ServletContext servletContext = getServletContext();
		List<Zone> zones = (List<Zone>) servletContext.getAttribute("zones");
		if (zones == null) {
			zones = new ArrayList<>();
		}
		return zones;
	}
}
