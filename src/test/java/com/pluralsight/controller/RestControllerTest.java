package com.pluralsight.controller;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.pluralsight.model.Ride;

public class RestControllerTest {

	@Test(timeout = 3000)
	public void testCreateRide() {
		RestTemplate restTemplate = new RestTemplate();
		Ride ride = new Ride();
		ride.setName("test ride");
		ride.setDuration(50);

		restTemplate.put("http://localhost:8080/ride_tracker/ride", ride);
	}

	/*
	 * @Test(timeout=3000) public void testGetRides() { RestTemplate
	 * restTemplate = new RestTemplate();
	 * 
	 * ResponseEntity<List<Ride>> ridesResponse = restTemplate.exchange(
	 * "http://localhost:8080/ride_tracker/rides", HttpMethod.GET, null, new
	 * ParameterizedTypeReference<List<Ride>>() { }); List<Ride> rides =
	 * ridesResponse.getBody();
	 * 
	 * for (Ride ride : rides) { System.out.println("Ride name: " +
	 * ride.getName()); } }
	 */
}
