package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.Ticket;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TicketResponse {

	private String id;
	private String url;
	private String externalId;
	private String createdAt;
	private String type;
	private String subject;
	private String description;
	private String priority;
	private String status;
	private Integer submitterId;
	private Integer assigneeId;
	private Integer organizationId;
	private String[] tags;
	private Boolean hasIncidents;
	private String dueAt;
	private String via;

	private String assigneeName;
	private String submitterName;
	private String organizationName;

	public TicketResponse(Ticket ticket) {
		this.id = ticket.getId();
		this.url = ticket.getUrl();
		this.externalId = ticket.getExternalId();
		this.createdAt = ticket.getCreatedAt();
		this.type = ticket.getType();
		this.subject = ticket.getSubject();
		this.description = ticket.getDescription();
		this.priority = ticket.getPriority();
		this.status = ticket.getStatus();
		this.submitterId = ticket.getSubmitterId();
		this.assigneeId = ticket.getAssigneeId();
		this.organizationId = ticket.getOrganizationId();
		this.tags = ticket.getTags();
		this.hasIncidents = ticket.getHasIncidents();
		this.dueAt = ticket.getDueAt();
		this.via = ticket.getVia();
	}
}
