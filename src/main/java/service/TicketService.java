package service;

import java.util.List;

import entity.TicketResponse;
import model.Organization;
import model.Ticket;
import model.User;

public interface TicketService {

	TicketResponse findTicketById(List<Organization> orgRepo, List<Ticket> ticketRepo, List<User> userRepo, String id);

	List<TicketResponse> findTicketBySearchable(List<Organization> orgRepo, List<Ticket> ticketRepo, List<User> userRepo,
			String key, String value);
}
