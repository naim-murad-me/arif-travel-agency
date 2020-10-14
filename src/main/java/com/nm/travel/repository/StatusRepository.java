package com.nm.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nm.travel.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long>{

}
