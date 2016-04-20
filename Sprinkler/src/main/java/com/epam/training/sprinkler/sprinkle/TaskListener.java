package com.epam.training.sprinkler.sprinkle;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.epam.training.sprinkler.domain.ScheduledItem;

@WebListener
public class TaskListener implements ServletContextListener, ServletContextAttributeListener {
	private SprinklerWatcher sprinklerWatcher;
	private List<ScheduledItem> items;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Timer timer = new Timer();
		sprinklerWatcher = new SprinklerWatcher();
		timer.schedule(sprinklerWatcher, 0, 1000);
		sce.getServletContext().setAttribute("TIMER", timer);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		if (items == null) {
			items = (List<ScheduledItem>) event.getServletContext().getAttribute("scheduledItems");
			if (items != null) {
				sprinklerWatcher.setItems(items);
			}
		}
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {

	}

}
