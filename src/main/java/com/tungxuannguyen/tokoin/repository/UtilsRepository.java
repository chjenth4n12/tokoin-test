package com.tungxuannguyen.tokoin.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tungxuannguyen.tokoin.constant.Constant;
import com.tungxuannguyen.tokoin.model.Organization;
import com.tungxuannguyen.tokoin.model.Ticket;
import com.tungxuannguyen.tokoin.model.User;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class UtilsRepository {
	
	// read any file
	public <T> List<T> readJson(String path, Class<T> type) {
		List<T> result = null;
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<T>> typeReference = new TypeReference<List<T>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream(path);
		try {
			result = mapper.readValue(inputStream, typeReference);
			inputStream.close();
		} catch (IOException e) {
			printError(type.getName(), e);
		}
		return result;
	}

	// get data user from file users.json
    public List<User> readJsonUserFile() {
        List<User> result = null;
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(Constant.JSON_PATH_USER);
        try {
            result = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (IOException e) {
        	printError("users", e);
        }
        return result;
    }

    // get data Organization from file organizations.json
    public List<Organization> readJsonOrganizationFile() {
        List<Organization> result = null;
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Organization>> typeReference = new TypeReference<List<Organization>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(Constant.JSON_PATH_ORGANIZATION);
        try {
            result = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (IOException e) {
        	printError("organizations", e);
        }
        return result;
    }

    // get data Ticket from file tickets.json
    public List<Ticket> readJsonTicketFile() {
        List<Ticket> result = null;
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Ticket>> typeReference = new TypeReference<List<Ticket>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(Constant.JSON_PATH_TICKET);
        try {
            result = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (IOException e) {
            printError("tickets", e);
        }
        return result;
    }
    
    private void printError (String nameFileErr, IOException e) {
    	System.out.println("Unable to read " + nameFileErr + ": " + e.getMessage());
    }
}
