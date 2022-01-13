package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Flight;

@Repository
public class FlightRepoImp implements FlightRepo {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public int addAFlight(Flight flight) {
		// TODO Auto-generated method stub
		Flight f = em.merge(flight);
		return f.getFlightNo();
	}

	@Override
	public List<Flight> viewAllFlight() {
		// TODO Auto-generated method stub
		TypedQuery<Flight> flight = em.createQuery("select f from Flight f", Flight.class);
		return flight.getResultList();
	}

	@Override
	public List<Flight> findFlightByFromTo(String from, String to) {
		TypedQuery<Flight> flight = em.createQuery("select f from Flight f where f.from = :fm and f.to = :to",
				Flight.class);
		flight.setParameter("fm", from);
		flight.setParameter("to", to);
		return flight.getResultList();

	}

	@Override
	public Flight findFlightById(int flightNo) {
		// TODO Auto-generated method stub
		return em.find(Flight.class, flightNo);
	}

	@Override
	public List<String> viewAllFlightFrom() {
		// TODO Auto-generated method stub
		TypedQuery<String> fromList = em.createQuery("select distinct(f.from) from Flight f", String.class);

		return fromList.getResultList();
	}

	@Override
	public List<String> viewAllFlightTo() {
		TypedQuery<String> toList = em.createQuery("select distinct(f.to) from Flight f", String.class);
		return toList.getResultList();

	}

}
