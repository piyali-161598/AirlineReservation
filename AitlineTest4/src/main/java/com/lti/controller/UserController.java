package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BoardingPassDto;
import com.lti.dto.LoginDto;
import com.lti.dto.LoginStatus;
import com.lti.dto.PassengerDto;
import com.lti.dto.PassengerSearchDto;
import com.lti.dto.PaymentDto;
import com.lti.dto.ResetPasswordDto;
import com.lti.dto.SearchFlightDto;
import com.lti.dto.Status;
import com.lti.dto.StatusType;
import com.lti.dto.UserIdDto;
import com.lti.entity.BoardingPass;
import com.lti.entity.Flight;
import com.lti.entity.Passenger;
import com.lti.entity.Payment;
import com.lti.entity.User;
import com.lti.exception.BoardingPassServiceException;
import com.lti.exception.FlightServiceException;
import com.lti.exception.PassengerServiceException;
import com.lti.exception.PaymentServiceException;
import com.lti.exception.UserServiceException;
import com.lti.service.BoardingPassService;
import com.lti.service.FlightService;
import com.lti.service.PassengerService;
import com.lti.service.PaymentService;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private FlightService flightService;
	@Autowired
	private PassengerService passengerService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private BoardingPassService boardingPassService;

	@PostMapping(path = "/userregister")
	public Status register(@RequestBody User user) {
		try {
			userService.register(user);

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successfull");

			return status;

		} catch (UserServiceException e) {

			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());

			return status;
		}
	}

	@PostMapping("/resetpassword")
	public ResetPasswordDto reset(@RequestBody ResetPasswordDto user) {
		try {
			userService.resetUserPassword(user.getUserEmail());
			ResetPasswordDto status = new ResetPasswordDto();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Password reset Successfull");
			status.setUserEmail(user.getUserEmail());
			return status;

		} catch (UserServiceException e) {
			ResetPasswordDto status = new ResetPasswordDto();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping("/userlogin")
	public LoginStatus login(@RequestBody LoginDto loginDto) {
		try {
			User user = userService.login(loginDto.getUserEmail(), loginDto.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.SUCCESS);
			loginStatus.setMessage("Login Successful!");
			loginStatus.setUserId(user.getUserId());
			loginStatus.setUsername(user.getFirstName());
			return loginStatus;
		} catch (UserServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
			return loginStatus;
		}
	}

	// -----------------FLIGHT------------------------
	@PostMapping(path = "/addflight")
	public Status addFlight(@RequestBody Flight flight) {
		try {
			flightService.addFlight(flight);

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Flight Added Successfully");
			return status;

		} catch (FlightServiceException e) {

			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());

			return status;
		}
	}

	@PostMapping(path = "/searchflight")
	public List<Flight> searchFlight(@RequestBody SearchFlightDto searchFlightDto) {
		try {
			return flightService.search(searchFlightDto.getFrom(), searchFlightDto.getTo());

		} catch (FlightServiceException e) {

			return null;
		}
	}

	@GetMapping(path = "/viewallflights")
	public List<Flight> viewAllFlights() {
		return flightService.viewAllFlight();
	}

	@GetMapping(path = "/viewallflightsfrom")
	public List<String> viewAllFlightsFrom() {
		return flightService.viewFlightFrom();
	}

	@GetMapping(path = "/viewallflightto")
	public List<String> viewAllFlightsTo() {
		return flightService.viewFlightTo();
	}

	// ------------------------------------------------
	@PostMapping(path = "/addpassenger")
	public Status addPassenger(@RequestBody PassengerDto passengerDto) {
		try {
			// List<Passenger> list=new ArrayList<>();
			Passenger passenger = new Passenger();
			passenger.setFlight(flightService.get(passengerDto.getFlightId()));
			passenger.setPassengerName(passengerDto.getPassengerName());
			passenger.setPassengerAge(passengerDto.getPassengerAge());
			passenger.setDateOfTravel(passengerDto.getDateOfTravel());
			passenger.setUser(userService.get(passengerDto.getUserId()));

			passengerService.addPassenger(passenger);

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Passenger Added Successfully");
			return status;

		} catch (PassengerServiceException e) {

			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());

			return status;
		}
	}

	@PostMapping(path = "/viewallpassenger")
	public List<Passenger> viewAllPassenger(@RequestBody PassengerSearchDto passenger) {
		return passengerService.viewAllPassenger(passenger.getUserId(), passenger.getFlightId(),passenger.getDateOfTravel());
	}
	@PostMapping(path = "/viewallpassengerbyid")
	public List<Passenger> viewAllPassengerById(@RequestBody UserIdDto userIdDto) {
		return passengerService.viewAllPassengerById(userIdDto.getUserId());
	}


	// --------------------------------------------

	@PostMapping(path = "/addpayment")
	public Status addPayment(@RequestBody PaymentDto paymentDto) {
		try {
			Payment payment = new Payment();
			payment.setDateOfTravel(paymentDto.getDateOfTravel());
			payment.setTotalCost(paymentDto.getTotalCost());
			payment.setUser(userService.get(paymentDto.getUserId()));
			payment.setFlight(flightService.get(paymentDto.getFlightId()));

			paymentService.addPayment(payment);

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Payment Added Successfully");
			return status;

		} catch (PaymentServiceException e) {

			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());

			return status;
		}
	}
	// -------------------------------------------------

	@PostMapping(path = "/generateboardingpass")
	public Status generateBoardingPass(@RequestBody BoardingPassDto boardingPassDto) {
		try {
			BoardingPass boardingPass = new BoardingPass();
			boardingPass.setPassenger(passengerService.getPassenger(boardingPassDto.getPassengerId()));
			boardingPassService.generateBoardingPass(boardingPass);

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Boarding Pass Generated Successfully");
			return status;

		} catch (BoardingPassServiceException e) {

			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());

			return status;
		}

	}
}
