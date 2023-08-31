package com.stewartlavenia.tally.controller;

import java.util.List;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.stewartlavenia.tally.entity.Users;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
//@RequestMapping("/Users")
//@RequestMapping("/users")
@RequestMapping("/tallyCalCarbsDaily")
@OpenAPIDefinition(info = @Info(title = "Calorie Calculator Service"), servers = {@Server(url="http://localhost:8080", description = "Local Server")})
public interface TallyController {
	//@formatter: off
	@Operation(
		summary = "Returns user details",
		description = "Given the user's first and last name it returns an email",
		responses = {
				@ApiResponse(
						responseCode = "200", 
						description = "An email is returned", 
						content = @Content(mediaType = "application/json", 
						schema =@Schema(implementation=Users.class))),
				@ApiResponse(
						responseCode = "400", 
						description = "Params are invalid.", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404", 
						description = "No email address found for those names.", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "500", 
						description = "An unplanned error occured.", 
						content = @Content(mediaType = "application/json"))
		},
		parameters = {
			@Parameter(name = "first_name", 
				allowEmptyValue = false, 
				required = false, 
				description = "The user's first name"),
			@Parameter(name = "last_name", 
				allowEmptyValue = false, 
				required = false, 
				description = "The user's last name")
		}
	) // end of @Operation

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Users> fetchUserName(
			
			@RequestParam(required = false)
				String first_name,
			@Length(max=30)
			@Pattern(regexp = "[\\w\\s]*")
			@RequestParam(required = false)
				String last_name);
	// -- end of return user's details mapping request ----------------------------------------------------- 
	/* @Operation(
			summary = "Returns first and last name",
			description = "Given a valid email it returns the user's first and last name",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "A first and last name is returned", 
							content = @Content(mediaType = "application/json", 
							schema =@Schema(implementation=Users.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "Params are invalid.", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No names were found for that email address.", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured.", 
							content = @Content(mediaType = "application/json"))
			},
					
					parameters = {
					@Parameter(name = "email", 
					allowEmptyValue = false, 
					required = false, 
					description = "The user's email")
							
			}
			) // end of @Operation
	
	// Lisa suggestion
	@GetMapping("/email")
	@ResponseStatus(code = HttpStatus.OK)
	List<Users> fetchUserNameByEmail(
			@RequestParam(required = false)
			String email);
			*/
	// @formatter:on
			
} // end TallyController
	