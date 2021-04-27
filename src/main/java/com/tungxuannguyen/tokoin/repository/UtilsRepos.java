package com.tungxuannguyen.tokoin.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class UtilsRepos {

    public <T> List<T> readJson (String path, Class<T> type) {
        List<T> result = null;
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<T>> typeReference = new TypeReference<List<T>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(path);
        try {
            result = mapper.readValue(inputStream, typeReference);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Unable to read file: " + e.getMessage());
        }
        return result;
    }
}
