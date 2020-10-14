package com.nm.travel.model;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "status")
@Data
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "activity")
	private String activity;

	@Column(name = "location_id")
	private String location;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "is_public_status")
	private boolean publicStatus;

	/** Creation date */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	private Calendar creationDate;
	
	@OneToOne
	@JoinTable(name = "user", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	private User user;
}
