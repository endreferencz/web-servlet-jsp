package com.epam.sprinkler.repository;

import org.springframework.data.repository.CrudRepository;

import com.epam.sprinkler.entity.ScheduledItem;

public interface ScheduledItemRepository extends CrudRepository<ScheduledItem, Integer>{

}
