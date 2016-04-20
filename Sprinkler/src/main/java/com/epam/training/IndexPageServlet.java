package com.epam.training;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.training.sprinkler.domain.ScheduledItem;
import com.epam.training.sprinkler.domain.Zone;

@WebServlet("/admin/index")
public class IndexPageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<ScheduledItem> scheduledItems = (List<ScheduledItem>) getServletContext().getAttribute("scheduledItems");
		if (scheduledItems == null) {
			scheduledItems = new ArrayList<>();
		}
		Date oneMonth = Date.from(LocalDate.now().plusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant());

		List<ScheduledItem> actualScheduledItems = scheduledItems.stream()
				.filter((actual) -> actual.getTo().before(new Date()))
				.filter((actual) -> actual.getFrom().before(oneMonth)).collect(Collectors.toList());

		getServletContext().setAttribute("actualScheduledItems", actualScheduledItems);

		req.getRequestDispatcher("views/index.jsp").forward(req, resp);
	}

}
