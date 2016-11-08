package com.epam.sprinkler;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.sprinkler.entity.ScheduledItem;
import com.epam.sprinkler.entity.Zone;

public class ModifyScheduleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ScheduledItem> scheduledItems = (List<ScheduledItem>) req.getServletContext().getAttribute("scheduledItems");
        int id = (int) req.getAttribute("id");
        Date from = (Date) req.getAttribute("from");
        Date to = (Date) req.getAttribute("to");
        Zone zone = (Zone) req.getAttribute("zone");
        boolean recurring = (boolean) req.getAttribute("recurring");

        ScheduledItem modItem = new ScheduledItem();
        for (ScheduledItem item : scheduledItems) {
            if (item.getId() == id) {
                modItem = item;
                scheduledItems.remove(item);
            }
        }

        modItem.setFrom(from);
        modItem.setTo(to);
        modItem.setZone(zone);
        modItem.setRecurring(recurring);

        scheduledItems.add(modItem);

        req.setAttribute("scheduledItems", scheduledItems);

        req.getRequestDispatcher("admin/views/scheduleList.jsp").forward(req, resp);
    }
}
