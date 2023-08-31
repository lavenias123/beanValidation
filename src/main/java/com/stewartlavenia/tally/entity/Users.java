package com.stewartlavenia.tally.entity;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstrutor

public class Users implements Comparable<Users>{
	private Long user_pk;
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	
	@JsonIgnore
	public Long getUserPK() {
		return user_pk;
		
	}

	@Override
	public int compareTo(Users that) {
		//@formatter:off
		return Comparator
				.comparing(Users::getLast_name)
				.thenComparing(Users::getFirst_name)
				.compare(this, that);
				
		//@formatter:on
	}
}
