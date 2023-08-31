package com.stewartlavenia.tally.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stewartlavenia.tally.entity.Users;
import com.stewartlavenia.tally.service.TallyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicTallyController implements TallyController {

	@Autowired
	private TallyService tallyService;
	
	@Override
	public List<Users> fetchUserName(String first_name, String last_name) {
		log.debug("first_name={}, last_name={}", first_name, last_name);
		return tallyService.fetchTally(first_name, last_name);
//		return first last;
	}

	/*
	// commented this test out in FetchTallyTest
	@Override
	public List<Users> fetchUserNameByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}
