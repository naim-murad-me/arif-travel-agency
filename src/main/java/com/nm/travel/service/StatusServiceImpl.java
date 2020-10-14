package com.nm.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nm.travel.model.Status;
import com.nm.travel.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {
	@Autowired
	private StatusRepository statusRepository;

	@Override
	public void save(Status status) {
		statusRepository.save(status);
	}

	@Override
	public List<Status> findAllList() {
		return statusRepository.findAll();
	}
}
