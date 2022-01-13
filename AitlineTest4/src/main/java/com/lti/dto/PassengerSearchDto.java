package com.lti.dto;

import java.time.LocalDate;

public class PassengerSearchDto {
	int userId;
	int flightId;
	LocalDate dateOfTravel;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public LocalDate getDateOfTravel() {
		return dateOfTravel;
	}
	public void setDateOfTravel(LocalDate dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
	
	

}
