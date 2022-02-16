package com.devsuperior.dslearnbds.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.NotificationRepository;
import com.devsuperior.dslearnbds.services.exceptions.ResourceNotFoundException;

@Service
public class NotificationService {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Transactional(readOnly = true)
	public Page<NotificationDTO> findAllPagedFull(Pageable pageable){
		Page<Notification> pageNotification = notificationRepository.findAll(pageable);
		return pageNotification.map(notification -> new NotificationDTO(notification));
	}
	
	@Transactional(readOnly = true)
	public Page<NotificationDTO> notificationForCurrentUser(Pageable pageable) {
		User user = authService.authenticated();
	//	Page<Notification> page = new PageImpl<>(user.getNotifications());
		Page<Notification> page = notificationRepository.findByUser(user, pageable);
		return page.map(notification -> new NotificationDTO(notification));
	}
	
	@Transactional(readOnly = true)
	public NotificationDTO findById(Long id) {
		Optional<Notification> notificationOptional = notificationRepository.findById(id);
		Notification notification = notificationOptional.orElseThrow(() -> new ResourceNotFoundException("Id not found: " + id));
		return new NotificationDTO(notification);
	}

}
