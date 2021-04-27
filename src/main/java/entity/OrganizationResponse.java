package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.Organization;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganizationResponse {

	private Integer id;
	private String url;
	private String externalId;
	private String name;
	private String[] domainNames;
	private String createdAt;
	private String details;
	private Boolean sharedTickets;
	private String[] tags;
	private String[] ticketSubjects;
	private String[] usernames;

	public OrganizationResponse(Organization organization) {
		this.id = organization.getId();
		this.url = organization.getUrl();
		this.externalId = organization.getExternalId();
		this.name = organization.getName();
		this.domainNames = organization.getDomainNames();
		this.createdAt = organization.getCreatedAt();
		this.details = organization.getDetails();
		this.sharedTickets = organization.getSharedTickets();
		this.tags = organization.getTags();
	}
}
