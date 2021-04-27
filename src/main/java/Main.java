import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import entity.OrganizationResponse;
import entity.TicketResponse;
import entity.UserResponse;
import model.Organization;
import model.Ticket;
import model.User;
import service.OrganizationService;
import service.TicketService;
import service.UserService;
import utils.UtilsRepository;

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired
	UtilsRepository utilsRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private OrganizationService organizationService;

	private static final String PATH_USER_FILE = "";
	private static final String PATH_TICKET_FILE = "";
	private static final String PATH_ORGANIZATION_FILE = "";

	private static final String INTRODUCTION_MSG = "Type 'quit' to exit at any time. Press 'Enter' to continue" + "\n"
			+ "\tSelect search options:\n" + " \t* Press 1 to search\n"
			+ " \t* Press 2 to view a list of searchable fields\n" + "\t* Type 'quit' to exit\"";
	private static final String CHOOSE_MODEL = "Select 1) Users or 2) Tickets or 3) Organizations";
	private static final String SEARCH_TERM = "Enter search term";
	private static final String SEARCH_VALUE = "Enter search value";
	private static final String[] USER_SEARCHABLE = { "_id", "url", "external_id", "name", "alias", "created_at",
			"active", "verified", "shared", "locale", "timezone", "last_login_at", "email", "phone", "signature",
			"organization_id", "tags", "suspended", "role" };
	private static final String[] TICKET_SEARCHABLE = { "_id", "url", "external_id", "created_at", "type", "subject",
			"description", "priority", "status", "submitter_id", "assignee_id", "organization_id", "tags",
			"has_incidents", "due_at", "via" };
	private static final String[] ORGANIZATION_SEARCHABLE = { "_id", "url", "external_id", "name", "domain_names",
			"created_at", "details", "shared_tickets", "tags" };
	
	private static final String HYPHEN = "-------------------------------------";

	private String searchTerm = "";
	private String searchValue = "";
	private List<Organization> organizations = new ArrayList<Organization>();
	private List<User> users = new ArrayList<User>();
	private List<Ticket> tickets = new ArrayList<Ticket>();

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	public void run(String... args) throws Exception {
		// get data from file
		organizations = utilsRepository.readJson(PATH_ORGANIZATION_FILE, Organization.class);
		users = utilsRepository.readJson(PATH_USER_FILE, User.class);
		tickets = utilsRepository.readJson(PATH_TICKET_FILE, Ticket.class);

		// start program
		this.program();
	}

	private void showTermValue(Scanner scanner) {
		System.out.println(SEARCH_TERM);
		searchTerm = scanner.next();
		System.out.println(SEARCH_VALUE);
		searchValue = scanner.next();
	}

	private void program() {
		System.out.println(INTRODUCTION_MSG);
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				int option = scanner.nextInt();
				if (option == 1) {
					System.out.println(CHOOSE_MODEL);
					int key = scanner.nextInt();
					if (key == 1) {
						// Search Users
						searchUser(scanner);
					} else if (key == 2) {
						// Search Tickets
						searchTicket(scanner);
					} else if (key == 3) {
						// Search Organizations
						searchOrganization(scanner);
					}
				} else if (option == 2) {
					searchable();
				}
			} else if (scanner.hasNext()) {
				String quit = scanner.next();
				if (quit.equalsIgnoreCase("quit")) {
					System.exit(0);
				}
			}
		}
	}

	private void searchable() {
		System.out.println(HYPHEN);
		System.out.println("Search Users with");
		Arrays.stream(USER_SEARCHABLE).forEach(System.out::println);
		System.out.println(HYPHEN);
		System.out.println("Search Tickets with");
		Arrays.stream(TICKET_SEARCHABLE).forEach(System.out::println);
		System.out.println(HYPHEN);
		System.out.println("Search Organizations with");
		Arrays.stream(ORGANIZATION_SEARCHABLE).forEach(System.out::println);
		System.out.println(HYPHEN);
		System.out.println(INTRODUCTION_MSG);
	}

	// Search Organizations
	private void searchOrganization(Scanner scanner) {
		showTermValue(scanner);
		System.out.println(
				"Searching organizations for " + searchTerm + " with a value of " + searchValue);
		List<OrganizationResponse> result = organizationService.findOrganizationBySearchable(organizations, tickets, users,
				searchTerm, searchValue);
		if (result.isEmpty()) {
			System.out.println("No results found");
		}
		result.stream().forEach(System.out::println);
		System.out.println(HYPHEN);
		System.out.println(INTRODUCTION_MSG);
	}

	// Search Tickets
	private void searchTicket(Scanner scanner) {
		showTermValue(scanner);
		System.out.println("Searching tickets for " + searchTerm + " with a value of " + searchValue);
		List<TicketResponse> result = ticketService.findTicketBySearchable(organizations, tickets, users, searchTerm,
				searchValue);
		if (result.isEmpty()) {
			System.out.println("No results found");
		}
		result.stream().forEach(System.out::println);
		System.out.println(HYPHEN);
		System.out.println(INTRODUCTION_MSG);
	}

	// search User
	private void searchUser(Scanner scanner) {
		showTermValue(scanner);
		System.out.println("Searching users for " + searchTerm + " with a value of " + searchValue);
		List<UserResponse> result = userService.findUserBySearchable(organizations, tickets, users, searchTerm,
				searchValue);
		if (result.isEmpty()) {
			System.out.println("No results found");
		}
		result.stream().forEach(System.out::println);
		System.out.println(HYPHEN);
		System.out.println(INTRODUCTION_MSG);
	}

}
