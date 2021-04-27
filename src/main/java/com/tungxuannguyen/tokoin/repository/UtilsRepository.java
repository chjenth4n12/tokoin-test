package com.tungxuannguyen.tokoin.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tungxuannguyen.tokoin.model.Organization;
import com.tungxuannguyen.tokoin.model.Ticket;
import com.tungxuannguyen.tokoin.model.User;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class UtilsRepository {

    private static final String jsonPathUser = "/json/users.json";
    private static final String jsonPathOrganization = "/json/organizations.json";
    private static final String jsonPathTicket = "/json/tickets.json";

    public List<User> readJsonUserFile() {
        List<User> result = null;
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(jsonPathUser);
        try {
            result = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Unable to read users: " + e.getMessage());
        }
        return result;
    }

    public List<Organization> readJsonOrganizationFile() {
        List<Organization> result = null;
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Organization>> typeReference = new TypeReference<List<Organization>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(jsonPathOrganization);
        try {
            result = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Unable to read organizations: " + e.getMessage());
        }
        return result;
    }

    public List<Ticket> readJsonTicketFile() {
        List<Ticket> result = null;
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Ticket>> typeReference = new TypeReference<List<Ticket>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(jsonPathTicket);
        try {
            result = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Unable to read tickets: " + e.getMessage());
        }
        return result;
    }
}
