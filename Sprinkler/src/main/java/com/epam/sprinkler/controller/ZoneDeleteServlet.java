package com.epam.sprinkler.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.sprinkler.entity.Zone;

public class ZoneDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String strId = req.getParameter("id");
        final List<Zone> zones = (List<Zone>) getServletContext().getAttribute("zones");
        final int id = Integer.parseInt(strId);
        if (zones != null) {
            Zone zoneToDelete = null;
            for (final Zone zone : zones) {
                if (zone.getId() == id) {
                    zoneToDelete = zone;
                }
            }
            zones.remove(zoneToDelete);
        }
        resp.sendRedirect("/Sprinkler/admin/zone/list");

    }
}