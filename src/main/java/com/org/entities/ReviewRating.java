package com.org.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReviewRating {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReviewRating;

}
