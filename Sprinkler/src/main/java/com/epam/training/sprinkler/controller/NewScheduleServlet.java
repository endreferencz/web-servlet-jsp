package com.epam.training.sprinkler.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.training.sprinkler.domain.ScheduledItem;
import com.epam.training.sprinkler.domain.Zone;

@WebServlet("/newSchedule")
public class NewScheduleServlet extends HttpServlet {

	private AtomicInteger idGenerator = new AtomicInteger(1);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Zone> zones = (List<Zone>) request.getServletContext().getAttribute("zones");
		if (zones == null) {
			request.setAttribute("zones", new ArrayList<>());
		} else {
			request.setAttribute("zones", zones);
		}
		request.getRequestDispatcher("views/newSchedule.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ScheduledItem> scheduledItems = (List<ScheduledItem>) request.getServletContext()
				.getAttribute("scheduledItems");
		if (scheduledItems == null) {
			scheduledItems = new ArrayList<>();
			request.getServletContext().setAttribute("scheduledItems", scheduledItems);
		}
		try {
			ScheduledItem scheduledItem = new ScheduledItem();
			scheduledItem.setId(idGenerator.getAndIncrement());
			scheduledItem.setFrom(convertToDate(request.getParameter("from")));
			scheduledItem.setTo(convertToDate(request.getParameter("to")));
			scheduledItem.setRecurring(request.getParameter("recurring") != null);
			Optional<Zone> zone = findById(Integer.valueOf(request.getParameter("zoneId")),
					(List<Zone>) request.getServletContext().getAttribute("zones"));
			if (zone.isPresent()) {
				scheduledItem.setZone(zone.get());
			} else {
				throw new IllegalArgumentException("Selected zone is required.");
			}
			scheduledItems.add(scheduledItem);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}

		doGet(request, response);
	}

	private Date convertToDate(String date) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
	}

	private Optional<Zone> findById(int id, List<Zone> zones) {
		return zones.stream().filter((zone) -> zone.getId() == id).findFirst();
	}

}
