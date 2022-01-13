package com.lti.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Passenger;

@Repository
public class PassengerRepoImp implements PassengerRepo {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public int addApassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		Passenger p = em.merge(passenger);

		return p.getPassengerId();
	}

	@Override
	public Passenger findPassengerById(int passengerId) {
		// TODO Auto-generated method stub
		return em.find(Passenger.class, passengerId);
	}

	@Override
	public List<Passenger> viewPassenger(int userId, int flightId, LocalDate dateOfTravel) {
		// TODO Auto-generated method stub
		TypedQuery<Passenger> passenger = em
				.createQuery("select p from Passenger p where p.user.userId = :uId and p.flight.flightNo = :fId "
						+ "and p.dateOfTravel=:dOT", Passenger.class);
		passenger.setParameter("uId", userId);
		passenger.setParameter("fId", flightId);
		passenger.setParameter("dOT", dateOfTravel);
		return passenger.getResultList();
	}

	@Override
	public List<Passenger> viewPassengerById(int userId) {
		TypedQuery<Passenger> passenger = em.createQuery("select p from Passenger p where p.user.userId = :uId  ",
				Passenger.class);
		passenger.setParameter("uId", userId);
		return passenger.getResultList();
	}

	/*
	 * public boolean findFlightInPassenger(int flightId) { // TODO Auto-generated
	 * method stub return (Long) em.
	 * createQuery("select count(p.flight.flightId) from Passenger p where p.flight.flightId = :fId"
	 * ) .setParameter("fId", flightId).getSingleResult() >= 1 ? true : false; }
	 */

}
