package com.tungxuannguyen.tokoin.service;

import java.util.List;

import com.tungxuannguyen.tokoin.entity.OrganizationResponse;
import com.tungxuannguyen.tokoin.model.Organization;
import com.tungxuannguyen.tokoin.model.Ticket;
import com.tungxuannguyen.tokoin.model.User;

public interface OrganizationService {

	OrganizationResponse findOrganizationById(List<Organization> orgRepo, List<Ticket> ticketRepo, List<User> userRepo,
			Integer id);

	List<OrganizationResponse> findOrganizationBySearchable(List<Organization> orgRepo, List<Ticket> ticketRepo,
			List<User> userRepo, String key, String value);
}
