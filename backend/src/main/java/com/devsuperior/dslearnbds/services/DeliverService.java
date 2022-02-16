package com.devsuperior.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.dto.DeliverRevisionDTO;
import com.devsuperior.dslearnbds.entities.Deliver;
import com.devsuperior.dslearnbds.repositories.DeliverRepository;

@Service
public class DeliverService {
	
	@Autowired
	private DeliverRepository repository;
	
	@Transactional
	public void saveRevision(Long id, DeliverRevisionDTO deliverRevisionDTO) {
		Deliver deliver = repository.getOne(id);
		deliver.setStatus(deliverRevisionDTO.getStatus());
		deliver.setFeedback(deliverRevisionDTO.getFeedback());
		deliver.setCorrectCount(deliverRevisionDTO.getCorrectCount());
		repository.save(deliver);
	}

}
