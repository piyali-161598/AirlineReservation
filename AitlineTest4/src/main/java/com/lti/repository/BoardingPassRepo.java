package com.lti.repository;

import java.util.List;

import com.lti.entity.BoardingPass;

public interface BoardingPassRepo {
	public int generateBoardingPass(BoardingPass boardingPass);
	public List<BoardingPass> viewAllBoardingPass();
}
