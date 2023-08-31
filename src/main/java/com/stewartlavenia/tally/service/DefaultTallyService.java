package com.stewartlavenia.tally.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stewartlavenia.tally.dao.TallyDao;
import com.stewartlavenia.tally.entity.Users;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultTallyService implements TallyService {

	@Autowired
	private TallyDao tallyDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Users> fetchTally(String first_name, String last_name) {
		log.info("The fetchTally method was called with first_name={}, last_name={}", first_name, last_name);
		
		List<Users> users = tallyDao.fetchTally(first_name, last_name);
		
		if(users.isEmpty()) {
			String msg = String.format("No user found with first_name=%s and last_name=%s", first_name, last_name);	
			throw new NoSuchElementException(msg);
		}
		
		Collections.sort(users);
		return users;
	}

}
