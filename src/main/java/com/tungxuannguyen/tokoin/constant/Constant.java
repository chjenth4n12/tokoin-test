package com.tungxuannguyen.tokoin.constant;

public class Constant {

	public static final String INTRODUCTION_MSG = "Type 'quit' to exit at any time. Press 'Enter' to continue" + "\n"
			+ "\tSelect search options:\n" + " \t* Press 1 to search\n"
			+ " \t* Press 2 to view a list of searchable fields\n" + "\t* Type 'quit' to exit\"";
	public static final String CHOOSE_MODEL = "Select 1) Users or 2) Tickets or 3) Organizations";
	public static final String TERM = "Enter search term";
	public static final String VALUE = "Enter search value";
	public static final String[] USER_ITEM = { "_id", "url", "external_id", "name", "alias", "created_at",
			"active", "verified", "shared", "locale", "timezone", "last_login_at", "email", "phone", "signature",
			"organization_id", "tags", "suspended", "role" };
	public static final String[] TICKET_ITEM = { "_id", "url", "external_id", "created_at", "type", "subject",
			"description", "priority", "status", "submitter_id", "assignee_id", "organization_id", "tags",
			"has_incidents", "due_at", "via" };
	public static final String[] ORGANIZATION_ITEM = { "_id", "url", "external_id", "name", "domain_names",
			"created_at", "details", "shared_tickets", "tags" };
	public static final String HYPHEN = "-------------------------------------";
	public static final String NOT_FOUND = "No results found";
	public static final String JSON_PATH_USER = "/json/users.json";
	public static final String JSON_PATH_ORGANIZATION = "/json/organizations.json";
	public static final String JSON_PATH_TICKET = "/json/tickets.json";
}
