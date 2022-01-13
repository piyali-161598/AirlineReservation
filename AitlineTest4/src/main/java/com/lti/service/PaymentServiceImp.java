package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Payment;
import com.lti.exception.PaymentServiceException;
import com.lti.repository.PaymentRepo;

@Service
public class PaymentServiceImp implements PaymentService {
	@Autowired
	PaymentRepo paymentRepo;

	@Override
	public void addPayment(Payment payment) {
		// TODO Auto-generated method stub
		try {
			paymentRepo.addPaymnet(payment);
			System.out.println("Payment Added Succesfully");

		} catch (EmptyResultDataAccessException e) {
			throw new PaymentServiceException("Payment not be added");
		}

	}

}
