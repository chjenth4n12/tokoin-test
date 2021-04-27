package service;

import java.util.List;

import entity.OrganizationResponse;
import model.Organization;
import model.Ticket;
import model.User;

public interface OrganizationService {

	OrganizationResponse findOrganizationById(List<Organization> orgRepo, List<Ticket> ticketRepo, List<User> userRepo,
			Integer id);

	List<OrganizationResponse> findOrganizationBySearchable(List<Organization> orgRepo, List<Ticket> ticketRepo,
			List<User> userRepo, String key, String value);
}
