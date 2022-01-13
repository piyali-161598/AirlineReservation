package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Flight;
import com.lti.exception.FlightServiceException;
import com.lti.repository.FlightRepo;

@Service
public class FlightServiceImp implements FlightService {
	@Autowired
	FlightRepo flightRepo;

	@Override
	public void addFlight(Flight flight) {
		// TODO Auto-generated method stub
		try {
			flightRepo.addAFlight(flight);
			System.out.println("Flight Added Succesfully");

		} catch (EmptyResultDataAccessException e) {
			throw new FlightServiceException("Flight could not be added");
		}

	}

	@Override
	public List<Flight> search(String from, String to) {
		// TODO Auto-generated method stub
		List<Flight> f = flightRepo.findFlightByFromTo(from, to);
		if (f.size() > 0)
			return f;
		else
			throw new FlightServiceException("No Flights available");

	}

	@Override
	public List<Flight> viewAllFlight() {
		// TODO Auto-generated method stub
		return flightRepo.viewAllFlight();

	}

	@Override
	public List<String> viewFlightFrom() {
		// TODO Auto-generated method stub
		return flightRepo.viewAllFlightFrom();
	}

	@Override
	public List<String> viewFlightTo() {
		// TODO Auto-generated method stub
		return flightRepo.viewAllFlightTo();
	}

	@Override
	public Flight get(int flightNo) {
		// TODO Auto-generated method stub
		return flightRepo.findFlightById(flightNo);
	}

}
