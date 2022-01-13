package com.lti.dto;

import java.time.LocalDate;

public class PaymentDto {

	
		// TODO Auto-generated constructor stub {"userId":"128","flightId":"530","dateOfTravel":"530","totalCost":"6700"}
		int paymentId;	
		LocalDate dateOfTravel;
		double totalCost;
		int userId;
		int flightId;
		public int getPaymentId() {
			return paymentId;
		}
		public void setPaymentId(int paymentId) {
			this.paymentId = paymentId;
		}
		public LocalDate getDateOfTravel() {
			return dateOfTravel;
		}
		public void setDateOfTravel(LocalDate dateOfTravel) {
			this.dateOfTravel = dateOfTravel;
		}
		public double getTotalCost() {
			return totalCost;
		}
		public void setTotalCost(double totalCost) {
			this.totalCost = totalCost;
		}
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
		
	

}
