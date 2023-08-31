package com.stewartlavenia.tally;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stewartlavenia.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class })
public class CalCalc {

	/**
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(CalCalc.class, args);

	}

}
// another swagger uri:
// http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#