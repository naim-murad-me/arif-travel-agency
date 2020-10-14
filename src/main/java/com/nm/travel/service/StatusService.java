package com.nm.travel.service;

import java.util.List;

import com.nm.travel.model.Status;

public interface StatusService {

	void save(Status sttaus);

	List<Status> findAllList();
}
