package com.epam.training;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.training.sprinkler.domain.Zone;

@WebServlet("/admin/newzone")
public class NewZoneServlet extends HttpServlet {

    private static final String NAME_PARAMETER = "zonename";
    private static final String CONSUMPTION_PARAMETER = "consumption";
    private static final String ID_PARAMETER = "id";
    private boolean error = false;

    public NewZoneServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(error) {
            request.setAttribute("error", "Last add attempt failed because one of the parameteres were wrong.");
        }
        request.getRequestDispatcher("/admin/views/newzone.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            error = false;
        try {
            int id = Integer.parseInt(request.getParameter(ID_PARAMETER));
            String name = request.getParameter(NAME_PARAMETER);
            double consumption = Double.parseDouble(request.getParameter(CONSUMPTION_PARAMETER));
            Zone zone = new Zone(id, name, consumption);
            updateZones(zone);
            response.sendRedirect(response.encodeURL("index"));
        } catch (NumberFormatException e) {
            error = true;
            response.sendRedirect(response.encodeURL("newzone"));
        }
    }

    private void updateZones(Zone zone) {
        List<Zone> zones = getZones();
        zones.add(zone);
        getServletContext().setAttribute("zones", zones);
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
