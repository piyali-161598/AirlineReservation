package com.lti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_flight")
public class Flight {

	@Id
	@SequenceGenerator(name = "flightSeq", initialValue = 501, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightSeq")
	@Column(name = "flight_num")
	int flightNo;
	
	@OneToMany(mappedBy = "flight")//,cascade=CascadeType.REMOVE)
	List<Passenger> passengers;
	
	@OneToMany(mappedBy = "flight")
	List<Payment> payment;
	

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}



	@Column(name = "flight_name")
	String flightName;

	@Column(name = "flight_from")
	String from;

	@Column(name = "flight_to")
	String to;

	@Column(name = "flight_departure")
	String departure;

	@Column(name = "flight_arrival")
	String arrival;

	@Column(name = "flight_duration")
	String duration;

	@Column(name = "flight_cabin")
	int cabinSize;

	@Column(name = "flight_economic")
	int costEconomy;

	@Column(name = "flight_business")
	int costBusiness;

	
	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getCabinSize() {
		return cabinSize;
	}

	public void setCabinSize(int cabinSize) {
		this.cabinSize = cabinSize;
	}

	public int getCostEconomy() {
		return costEconomy;
	}

	public void setCostEconomy(int costEconomy) {
		this.costEconomy = costEconomy;
	}

	public int getCostBusiness() {
		return costBusiness;
	}

	public void setCostBusiness(int costBusiness) {
		this.costBusiness = costBusiness;
	}

}
