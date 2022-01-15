package com.example;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Tables;
import com.example.model.tables.pojos.Ticket;

@Service
public class TicketService {

	// DSL stands for Domain Specific language
	@Autowired
	private DSLContext dslContext;

	public void insertTicket(Ticket ticket) {
		dslContext.insertInto(Tables.TICKET_, Tables.TICKET_.ID, Tables.TICKET_.AMOUNT, Tables.TICKET_.CATEGORY)
				.values(ticket.getId(), ticket.getAmount(), ticket.getCategory()).execute();
	}

	public List<Ticket> getTickets() {
		return dslContext.selectFrom(Tables.TICKET_).fetchInto(Ticket.class);
	}
}
