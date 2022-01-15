package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.tables.pojos.Ticket;

@SpringBootApplication
@RestController
@RequestMapping("/tickets")
public class SpringbootWithJooqApplication {

	@Autowired
	private TicketService ticketService;

	@PostMapping
	public String addTicket(@RequestBody Ticket ticket) {
		ticketService.insertTicket(ticket);
		return "added ticket";
	}

	@GetMapping
	public List<Ticket> addTicket() {
		return ticketService.getTickets();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithJooqApplication.class, args);
	}

}
