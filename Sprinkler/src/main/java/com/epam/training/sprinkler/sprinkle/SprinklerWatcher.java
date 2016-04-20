package com.epam.training.sprinkler.sprinkle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import com.epam.training.sprinkler.domain.ScheduledItem;

public class SprinklerWatcher extends TimerTask {
	private List<ScheduledItem> items;
	private List<ScheduledItem> startedItems;

	public SprinklerWatcher() {
		startedItems = new ArrayList<>();
		items = new ArrayList<>();
	}

	private void checkForStart(ScheduledItem item) {
		Date now = new Date();
		if (canStartItem(item, now)) {
			start(item);
		}
	}

	private void checkForStop(ScheduledItem item) {
		Date now = new Date();
		if (canStopItem(item, now)) {
			stop(item);
		}
	}

	private boolean canStartItem(ScheduledItem item, Date now) {
		return !startedItems.contains(item) && checkDateBetweenTwo(now, item.getFrom(), item.getTo());
	}

	private boolean canStopItem(ScheduledItem item, Date now) {
		return now.after(item.getTo());
	}

	private boolean checkDateBetweenTwo(Date now, Date first, Date second) {
		return now.after(first) && now.before(second);
	}

	private void start(ScheduledItem item) {
		startedItems.add(item);
		System.out.println("Item " + item.getId() + " started in zone " + item.getZone().getId());
	}

	private void stop(ScheduledItem item) {
		startedItems.remove(item);
		System.out.println("Item " + item.getId() + " stopped in zone " + item.getZone().getId());
	}

	public void setItems(List<ScheduledItem> items) {
		this.items = items;
	}

	@Override
	public void run() {
		ArrayList<ScheduledItem> copy = new ArrayList<>();
		copy.addAll(items);
		for (ScheduledItem item : copy) {
			checkForStart(item);
		}
		
		copy.clear();
		copy.addAll(startedItems);
		for (ScheduledItem item : copy) {
			checkForStop(item);
		}
	}

}
