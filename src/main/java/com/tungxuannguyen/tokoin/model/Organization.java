package com.tungxuannguyen.tokoin.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Organization {

	private static final long serialVersionUID = 1L;

	@JsonAlias("_id")
	private Integer id;

	private String url;

	@JsonAlias("external_id")
	private String externalId;

	private String name;

	@JsonAlias("domain_names")
	private String[] domainNames;

	@JsonAlias("created_at")
	private String createdAt;

	private String details;

	@JsonAlias("shared_tickets")
	private Boolean sharedTickets;

	private String[] tags;
}
