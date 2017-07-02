package com.pluralsight.model;

import java.time.LocalDate;

public class Ride {

	private int id;
	private String name;
	private int duration;
	private LocalDate ridedate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public String getName() {
		return name;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getRidedate() {
		return ridedate;
	}

	public void setRidedate(LocalDate ridedate) {
		this.ridedate = ridedate;
	}

}
