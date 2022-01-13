package com.lti.service;

import java.util.List;

import com.lti.entity.BoardingPass;

public interface BoardingPassService {
public void generateBoardingPass (BoardingPass boardingPass);
public List<BoardingPass> viewAllBoardingPass();
	
}
