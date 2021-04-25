package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.UserResponse;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Search {

    public UserResponse searchUser (String term, String value) {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.convertValue(readJson(""), User.class);
        return null;
    }

    public Map readJson (String path) {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(path);

            // convert JSON file to map
            Map<?, ?> map = mapper.readValue(file, Map.class);

            return map;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
