package com.nm.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nm.travel.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}
