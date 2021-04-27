package com.tungxuannguyen.tokoin.service;

import java.util.List;

import com.tungxuannguyen.tokoin.entity.TicketResponse;
import com.tungxuannguyen.tokoin.model.Organization;
import com.tungxuannguyen.tokoin.model.Ticket;
import com.tungxuannguyen.tokoin.model.User;

public interface TicketService {

	TicketResponse findTicketById(List<Organization> orgRepo, List<Ticket> ticketRepo, List<User> userRepo, String id);

	List<TicketResponse> findTicketBySearchable(List<Organization> orgRepo, List<Ticket> ticketRepo, List<User> userRepo,
			String key, String value);
}
