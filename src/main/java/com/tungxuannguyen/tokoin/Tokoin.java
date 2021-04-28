package com.tungxuannguyen.tokoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tungxuannguyen.tokoin.constant.Constant;
import com.tungxuannguyen.tokoin.entity.OrganizationResponse;
import com.tungxuannguyen.tokoin.entity.TicketResponse;
import com.tungxuannguyen.tokoin.entity.UserResponse;
import com.tungxuannguyen.tokoin.model.Organization;
import com.tungxuannguyen.tokoin.model.Ticket;
import com.tungxuannguyen.tokoin.model.User;
import com.tungxuannguyen.tokoin.repository.UtilsRepository;
import com.tungxuannguyen.tokoin.service.OrganizationService;
import com.tungxuannguyen.tokoin.service.TicketService;
import com.tungxuannguyen.tokoin.service.UserService;

@SpringBootApplication
public class Tokoin implements CommandLineRunner {

	@Autowired
	UtilsRepository utilsRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private OrganizationService organizationService;

	private String searchTerm = "";
	private String searchValue = "";
	private List<Organization> organizations = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	private List<Ticket> tickets = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(Tokoin.class, args);
	}

	public void run(String... args) throws Exception {
		// get data from file
		organizations = utilsRepository.readJsonOrganizationFile();
		users = utilsRepository.readJsonUserFile();
		tickets = utilsRepository.readJsonTicketFile();

		// start program
		this.program();
	}

	private void showTermValue(Scanner scanner) {
		System.out.println(Constant.TERM);
		searchTerm = scanner.next();
		System.out.println(Constant.VALUE);
		searchValue = scanner.next();
	}

	private void program() {
		System.out.println(Constant.INTRODUCTION_MSG);
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				int option = scanner.nextInt();
				if (option == 1) {
					System.out.println(Constant.CHOOSE_MODEL);
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
		System.out.println(Constant.HYPHEN);
		System.out.println("Search Users with");
		Arrays.stream(Constant.USER_ITEM).forEach(System.out::println);
		System.out.println(Constant.HYPHEN);
		System.out.println("Search Tickets with");
		Arrays.stream(Constant.TICKET_ITEM).forEach(System.out::println);
		System.out.println(Constant.HYPHEN);
		System.out.println("Search Organizations with");
		Arrays.stream(Constant.ORGANIZATION_ITEM).forEach(System.out::println);
		System.out.println(Constant.HYPHEN);
		System.out.println(Constant.INTRODUCTION_MSG);
	}

	// Search Organizations
	private void searchOrganization(Scanner scanner) {
		showTermValue(scanner);
		printMessageTermAndValue("organizations");
		List<OrganizationResponse> result = organizationService.findOrganizationBySearchable(organizations, tickets, users,
				searchTerm, searchValue);
		if (result.isEmpty()) {
			System.out.println(Constant.NOT_FOUND);
		}
		result.stream().forEach(System.out::println);
		System.out.println(Constant.HYPHEN);
		System.out.println(Constant.INTRODUCTION_MSG);
	}

	// Search Tickets
	private void searchTicket(Scanner scanner) {
		showTermValue(scanner);
		printMessageTermAndValue("tickets");
		List<TicketResponse> result = ticketService.findTicketBySearchable(organizations, tickets, users, searchTerm,
				searchValue);
		if (result.isEmpty()) {
			System.out.println(Constant.NOT_FOUND);
		}
		result.stream().forEach(System.out::println);
		System.out.println(Constant.HYPHEN);
		System.out.println(Constant.INTRODUCTION_MSG);
	}

	// search User
	private void searchUser(Scanner scanner) {
		showTermValue(scanner);
		printMessageTermAndValue("users");
		List<UserResponse> result = userService.findUserBySearchable(organizations, tickets, users, searchTerm,
				searchValue);
		if (result.isEmpty()) {
			System.out.println(Constant.NOT_FOUND);
		}
		result.stream().forEach(System.out::println);
		System.out.println(Constant.HYPHEN);
		System.out.println(Constant.INTRODUCTION_MSG);
	}
	
	private void printMessageTermAndValue (String name) {
		System.out.println("Searching " + name + " for " + searchTerm + " with a value of " + searchValue);
	}

}
