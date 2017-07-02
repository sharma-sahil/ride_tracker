package com.pluralsight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.model.Ride;
import com.pluralsight.service.RideService;
import com.pluralsight.util.ServiceError;

@Controller
public class RideController {

	@Autowired
	private RideService rideService;

	@RequestMapping(value = "/rides", method = RequestMethod.GET)
	public @ResponseBody List<Ride> getRides() {
		return rideService.getRides();
	}

	@GetMapping(value = "/ride/{id}")
	public @ResponseBody Ride getRide(@PathVariable int id) {
		return rideService.getRide(id);
	}

	@PostMapping(value = "/ride")
	public @ResponseBody Ride createRide(@RequestBody Ride ride) {
		return rideService.createRide(ride);
	}

	@PutMapping(value = "/ride")
	public @ResponseBody Ride updateRide(@RequestBody Ride ride) {
		return rideService.updateRide(ride);
	}

	@GetMapping(value = "/batch")
	public @ResponseBody Object batchUpdate() {
		rideService.batch();
		return null;
	}

	@DeleteMapping(value = "/delete/{id}")
	public @ResponseBody Object delete(@PathVariable int id) {
		rideService.delete(id);
		return null;
	}

	@GetMapping(value = "/test")
	public @ResponseBody Object testException() {
		throw new DataAccessException("Testing Exception Thrown") {
		};
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
		ServiceError se = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return new ResponseEntity<>(se, HttpStatus.OK);
	}

}
