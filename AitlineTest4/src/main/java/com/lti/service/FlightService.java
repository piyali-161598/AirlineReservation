package com.lti.service;

import java.util.List;

import com.lti.entity.Flight;

public interface FlightService {
	void addFlight(Flight flight);

	List<Flight> search(String from, String to);

	List<Flight> viewAllFlight();
	List<String> viewFlightFrom();
	List<String> viewFlightTo();
	Flight get(int flightNo);

}
