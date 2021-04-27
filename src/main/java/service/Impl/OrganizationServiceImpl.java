package service.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;

import entity.OrganizationResponse;
import model.Organization;
import model.Ticket;
import model.User;
import service.OrganizationService;

public class OrganizationServiceImpl implements OrganizationService {

	@Override
	public OrganizationResponse findOrganizationById(List<Organization> orgRepo, List<Ticket> ticketRepo,
			List<User> userRepo, Integer id) {
		OrganizationResponse organizationResponse = orgRepo.stream().filter(o -> o.getId().equals(id))
				.map(organization -> new OrganizationResponse(organization)).findFirst()
				.orElseThrow(() -> new NoSuchElementException());
		organizationResponse.setTicketSubjects(
				ticketRepo.stream().filter(t -> t.getOrganizationId().equals(organizationResponse.getId()))
						.map(t -> t.getSubject()).toArray(String[]::new));
		organizationResponse
				.setUsernames(userRepo.stream().filter(u -> u.getOrganizationId().equals(organizationResponse.getId()))
						.map(u -> u.getName()).toArray(String[]::new));
		return organizationResponse;
	}

	@Override
	public List<OrganizationResponse> findOrganizationBySearchable(List<Organization> orgRepo, List<Ticket> ticketRepo,
			List<User> userRepo, String key, String value) {
		if (Strings.isBlank(key)) {
			throw new NullPointerException("Key is invalid.");
		} else {
			switch (key) {
			case "_id":
				return orgRepo.stream().filter(item -> item.getId() == Integer.valueOf(value))
						.map(item -> findOrganizationById(orgRepo, ticketRepo, userRepo, item.getId()))
						.collect(Collectors.toList());
			case "url":
				return orgRepo.stream().filter(item -> item.getUrl().equalsIgnoreCase(value))
						.map(item -> findOrganizationById(orgRepo, ticketRepo, userRepo, item.getId()))
						.collect(Collectors.toList());
			case "external_id":
				return orgRepo.stream().filter(item -> item.getExternalId().equalsIgnoreCase(value))
						.map(item -> findOrganizationById(orgRepo, ticketRepo, userRepo, item.getId()))
						.collect(Collectors.toList());
			case "name":
				return orgRepo.stream().filter(item -> item.getName().equalsIgnoreCase(value))
						.map(item -> findOrganizationById(orgRepo, ticketRepo, userRepo, item.getId()))
						.collect(Collectors.toList());
			case "domain_names":
				List<Organization> domainNames = new ArrayList<>();
				for (Organization organization : orgRepo) {
					for (String str : organization.getDomainNames()) {
						if (str.equalsIgnoreCase(value)) {
							domainNames.add(organization);
						}
					}
				}
				return domainNames.stream()
						.map(item -> findOrganizationById(orgRepo, ticketRepo, userRepo, item.getId()))
						.collect(Collectors.toList());
			case "created_at":
				return orgRepo.stream().filter(item -> item.getCreatedAt().equalsIgnoreCase(value))
						.map(item -> findOrganizationById(orgRepo, ticketRepo, userRepo, item.getId()))
						.collect(Collectors.toList());
			case "details":
				return orgRepo.stream().filter(item -> item.getDetails().equalsIgnoreCase(value))
						.map(item -> findOrganizationById(orgRepo, ticketRepo, userRepo, item.getId()))
						.collect(Collectors.toList());
			case "shared_tickets":
				return orgRepo.stream().filter(item -> item.getSharedTickets().equals(Boolean.valueOf(value)))
						.map(item -> findOrganizationById(orgRepo, ticketRepo, userRepo, item.getId()))
						.collect(Collectors.toList());
			case "tags":
				List<Organization> tags = new ArrayList<>();
				for (Organization organization : orgRepo) {
					for (String str : organization.getTags()) {
						if (str.equalsIgnoreCase(value)) {
							tags.add(organization);
						}
					}
				}
				return tags.stream().map(item -> findOrganizationById(orgRepo, ticketRepo, userRepo, item.getId()))
						.collect(Collectors.toList());
			default:
				return Collections.emptyList();
			}
		}
	}

}
