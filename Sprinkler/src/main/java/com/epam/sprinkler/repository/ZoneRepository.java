package com.epam.sprinkler.repository;

import org.springframework.data.repository.CrudRepository;

import com.epam.sprinkler.entity.Zone;

public interface ZoneRepository extends CrudRepository<Zone, Integer> {

}
