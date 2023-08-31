package com.stewartlavenia.tally.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.stewartlavenia.tally.entity.Users;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefalultTallyDao implements TallyDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate; 
	
	@Override
	public List<Users> fetchTally(String first_name, String last_name) {
		log.debug("DAO: first_name={}, last_name={}", first_name, last_name);
		
		//@formatter: off
		String sql = ""
				+ "SELECT * "
				+ "FROM Users "
				+ "WHERE first_name = :first_name AND last_name = :last_name";
		//@formatter: on
		
		Map<String, Object> params = new HashMap<>();
		params.put("first_name", first_name);
		params.put("last_name", last_name);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				//@formatter: off
				return Users.builder()
						.first_name(rs.getString("first_name"))
						.last_name(rs.getString("last_name"))
						.email(rs.getString("email"))
						.phone(rs.getString("phone"))
						.build();
				//@formatter: on
			}});
	}

}
