package com.pluralsight.repository;

import java.util.List;

import com.pluralsight.model.Ride;

public interface RideRepository {

	List<Ride> getRides();

	Ride getRide(int id);
	
	Ride createRide(Ride ride);

	Ride updateRide(Ride ride);

	void updateRides(List<Object[]> pairs);

	void delete(int id);
}