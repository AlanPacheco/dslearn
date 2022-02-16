package com.devsuperior.dslearnbds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.services.NotificationService;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {
	
	@Autowired
	private NotificationService service;
	
	@GetMapping(value = "/full")
	public ResponseEntity<Page<NotificationDTO>> findAllPagedFull(Pageable pageable){
		Page<NotificationDTO> pageDTO = service.findAllPagedFull(pageable);
		return ResponseEntity.ok().body(pageDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<NotificationDTO>> findAllPaged(Pageable pageable){
		Page<NotificationDTO> pageDTO = service.notificationForCurrentUser(pageable);
		return ResponseEntity.ok().body(pageDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<NotificationDTO> findById(@PathVariable Long id){
		NotificationDTO notificationDTO = service.findById(id);
		return ResponseEntity.ok().body(notificationDTO);
	}

}
