package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_boarding")
public class BoardingPass {
	
	@Id
	@SequenceGenerator(name = "tcktSeq", initialValue = 100001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tcktSeq")
	int ticketId;
	
	@OneToOne
	@JoinColumn(name="passenger_id")
	@JsonIgnore
	Passenger passenger;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	
}
/* paymentId	userId	flightId	dateOfTravel	totalCost(return success and failure)
 * flightId 	dateOfTravel	noOfSeatsRemaining
 */
 