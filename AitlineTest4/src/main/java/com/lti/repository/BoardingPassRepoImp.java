package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.BoardingPass;

@Repository
public class BoardingPassRepoImp implements BoardingPassRepo {
@PersistenceContext
EntityManager em;
	
	@Override
	@Transactional
	public int generateBoardingPass(BoardingPass boardingPass) {
		// TODO Auto-generated method stub
		BoardingPass bp=em.merge(boardingPass);
		int ticketId=bp.getTicketId();
		return ticketId;

	}

	@Override
	public List<BoardingPass> viewAllBoardingPass() {
		// TODO Auto-generated method stub
		TypedQuery<BoardingPass> query=em.createQuery("select bp from BoardingPass bp",BoardingPass.class);
		return query.getResultList();
	}

}
