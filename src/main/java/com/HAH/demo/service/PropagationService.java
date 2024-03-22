package com.HAH.demo.service;

import com.HAH.demo.repo.DetailsRepository;
import com.HAH.demo.repo.HeaderRepository;

public class PropagationService {

	private DetailsRepository detailsRepository;
	private HeaderRepository headerRepository;

	public void setHeaderRepository(HeaderRepository headerRepository) {
		this.headerRepository = headerRepository;
	}

	public void setDetailsRepository(DetailsRepository detailsRepository) {
		this.detailsRepository = detailsRepository;
	}

	public Result save(int state, String header, String... details) {

		var headerId = headerRepository.create(header);
		if (state == 1) {
			throw new RuntimeException();
		}

		var detailsId = detailsRepository.create(headerId, details);
		if (state == 2) {
			throw new RuntimeException();
		}

		return new Result(headerId, detailsId);
	}
}
