import com.beust.jcommander.Parameter;
import model.Organization;
import model.Ticket;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import picocli.CommandLine.Command;
import repository.UtilsRepos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements CommandLineRunner {

    @Autowired
    UtilsRepos repository;

    private static final String PATH_USER_FILE = "";
    private static final String PATH_TICKET_FILE = "";
    private static final String PATH_ORGANIZATION_FILE = "";

    private static final String INTRODUCTION_MSG = "Type 'quit' to exit at any time. Press 'Enter' to continue" +
            "\n" +
            "\tSelect search options:\n" +
            " \t* Press 1 to search\n" +
            " \t* Press 2 to view a list of searchable fields\n" +
            "\t* Type 'quit' to exit\"";
    private static final String CHOOSE_MODEL = "Select 1) Users or 2) Tickets or 3) Organizations";
    private static final String SEARCH_TERM = "Enter search term";
    private static final String SEARCH_VALUE = "Enter search value";
    private static final String[] USER_SEARCHABLE = {"_id", "url", "external_id", "name", "alias", "created_at", "active",
            "verified", "shared", "locale", "timezone", "last_login_at", "email", "phone", "signature", "organization_id", "tags", "suspended", "role"};
    private static final String[] TICKET_SEARCHABLE = {"_id", "url", "external_id", "created_at", "type", "subject", "description",
            "priority", "status", "submitter_id", "assignee_id", "organization_id", "tags", "has_incidents", "due_at", "via"};
    private static final String[] ORGANIZATION_SEARCHABLE = {"_id", "url", "external_id", "name", "domain_names", "created_at", "details", "shared_tickets", "tags"};

    private String searchTerm = "";
    private String searchValue = "";
    private List<Organization> organizations = new ArrayList<Organization>();
    private List<User> users = new ArrayList<User>();
    private List<Ticket> tickets = new ArrayList<Ticket>();

    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public void run(String... args) throws Exception {
        // get data from file
        organizations = repository.readJson(PATH_ORGANIZATION_FILE, Organization.class);
        users = repository.readJson(PATH_USER_FILE, User.class);
        tickets = repository.readJson(PATH_TICKET_FILE, Ticket.class);

        // start commanline

    }


}
