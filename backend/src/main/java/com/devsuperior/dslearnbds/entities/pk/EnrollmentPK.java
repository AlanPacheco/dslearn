package com.devsuperior.dslearnbds.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.devsuperior.dslearnbds.entities.Offer;
import com.devsuperior.dslearnbds.entities.User;

@Embeddable
public class EnrollmentPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	public EnrollmentPK() {
	}

	public EnrollmentPK(User user, Offer offer) {
		this.user = user;
		this.offer = offer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	

	
}
