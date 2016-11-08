package com.epam.sprinkler;

import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.epam.sprinkler.entity.ScheduledItem;

public class TaskListener implements ServletContextListener, ServletContextAttributeListener {
    private SprinklerWatcher sprinklerWatcher;
    private List<ScheduledItem> items;

    @Override
    public void contextInitialized(final ServletContextEvent sce) {
        final Timer timer = new Timer();
        sprinklerWatcher = new SprinklerWatcher();
        timer.schedule(sprinklerWatcher, 0, 1000);
        sce.getServletContext().setAttribute("TIMER", timer);
    }

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {

    }

    @Override
    public void attributeAdded(final ServletContextAttributeEvent event) {
        if (items == null) {
            items = (List<ScheduledItem>) event.getServletContext().getAttribute("scheduledItems");
            if (items != null) {
                sprinklerWatcher.setItems(items);
            }
        }
    }

    @Override
    public void attributeRemoved(final ServletContextAttributeEvent event) {

    }

    @Override
    public void attributeReplaced(final ServletContextAttributeEvent event) {

    }

}
