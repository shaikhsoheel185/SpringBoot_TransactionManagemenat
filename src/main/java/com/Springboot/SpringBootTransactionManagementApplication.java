package com.Springboot;

import com.Springboot.dto.FlightBookingAcknowledgement;
import com.Springboot.dto.FlightBookingRequest;
import com.Springboot.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class SpringBootTransactionManagementApplication {

	@Autowired
	private FlightBookingService service;
	@PostMapping("/bookFlightTicket")
	private FlightBookingAcknowledgement bookFlightTicket( @RequestBody FlightBookingRequest request){
		return service.bookFlightTicket(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTransactionManagementApplication.class, args);
	}

}
