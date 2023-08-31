package com.stewartlavenia.tally.dao;

import java.util.List;

import com.stewartlavenia.tally.entity.Users;

public interface TallyDao {

	/**
	 * 
	 * @param first_name
	 * @param last_name
	 * @return
	 */
	List<Users> fetchTally(String first_name, String last_name);

}
