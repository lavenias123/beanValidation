package com.stewartlavenia.tally.service;

import java.util.List;

import com.stewartlavenia.tally.entity.Users;

public interface TallyService {
	/**
	 * 
	 * @param first_name
	 * @param last_name
	 * @return
	 */

	List<Users> fetchTally(String first_name, String last_name);

	
}
