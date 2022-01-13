package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.lti.entity.Payment;


@Repository
public class PaymentRepoImp implements PaymentRepo {

@PersistenceContext
EntityManager em;

	@Override
	@Transactional
	public int addPaymnet(Payment payment) {
	// TODO Auto-generated method stub
	Payment p=em.merge(payment);
	return p.getPaymentId();
	}

}
