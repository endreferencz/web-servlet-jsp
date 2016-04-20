package com.epam.training.sprinkler.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.epam.training.sprinkler.domain.ScheduledItem;
import com.epam.training.sprinkler.domain.Zone;

public class AppServletContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(final ServletContextEvent arg0) {
    }

    @Override
    public void contextInitialized(final ServletContextEvent servletContextEvent) {
        final ServletContext servletContext = servletContextEvent.getServletContext();
        final List<Zone> zones = createZones(servletContext);
        createSchedules(servletContext, zones);

    }

    private List<ScheduledItem> createSchedules(final ServletContext servletContext, final List<Zone> zones) {
        final List<ScheduledItem> scheduleItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final ScheduledItem item = new ScheduledItem();
            item.setId(i);
            item.setFrom(new Date());
            item.setTo(new Date(System.currentTimeMillis() + 5 * 6000));
            item.setRecurring(false);
            item.setZone(zones.get(i));
            scheduleItems.add(item);
        }
        servletContext.setAttribute("scheduledItems", scheduleItems);
        return scheduleItems;
    }

    private List<Zone> createZones(final ServletContext servletContext) {
        final List<Zone> zones = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            zones.add(new Zone(i, "DummyZone" + i, i * 10));
        }
        servletContext.setAttribute("zones", zones);
        return zones;
    }

}
