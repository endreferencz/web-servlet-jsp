package com.epam.sprinkler.init;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContextEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.sprinkler.entity.ScheduledItem;
import com.epam.sprinkler.entity.Zone;
import com.epam.sprinkler.repository.ScheduledItemRepository;
import com.epam.sprinkler.repository.ZoneRepository;

@Service
public class InitializerService {

    @Autowired
    private ZoneRepository zoneRepository;
    
    @Autowired
    private ScheduledItemRepository scheduledItemRepository;
    
    @PostConstruct
    public void init() {
        final List<Zone> zones = createZones();
//        createSchedules(zones);
    }

    private List<ScheduledItem> createSchedules(List<Zone> zones) {
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
        scheduledItemRepository.save(scheduleItems);
        return scheduleItems;
    }

    private List<Zone> createZones() {
        final List<Zone> zones = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Zone zone = new Zone(i, "DummyZone" + i, i * 10);
            zones.add(zone);
        }
        zoneRepository.save(zones);
        return zones;
    }

}
