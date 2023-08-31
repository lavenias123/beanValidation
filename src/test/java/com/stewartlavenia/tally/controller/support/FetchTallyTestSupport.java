package com.stewartlavenia.tally.controller.support;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.stewartlavenia.tally.entity.Users;

public class FetchTallyTestSupport extends BaseTallyTest {

	protected List<Users> buildExpected() {
		List<Users> list = new LinkedList<>();
		
		//@formatter:off
		list.add(Users.builder()
				.first_name("Dan")
				.last_name("BoshDan")
				.email("info@BoshDan.com")
				.phone("213-666-4444")
				.build());
		
		list.add(Users.builder()
				.first_name("Carol")
				.last_name("Butters")
				.email("sam@d1tm.org")
				.phone("767-888-2323")
				.build());
		
		list.add(Users.builder()
				.first_name("David")
				.last_name("Biten")
				.email("biten@district112.org")
				.phone("213-666-3333")
				.build());
		//@formatter:on
		Collections.sort(list);
		
		return list;
	}
	

	/**
	 * 
	 * @param error
	 * @param status
	 */
	protected void assertErrorMessageValid(Map<String, Object> error, HttpStatus status) {
		//@formatter:off
		 assertThat(error)
			 .containsKey("message")
			 .containsEntry("Status code", status.value())
			 .containsEntry("uri", "/tallyCalCarbsDaily")
			 .containsKey("timestamp")
			 .containsEntry("reason", status.getReasonPhrase());
		 
		 //@formatter:on
	}
	
}
