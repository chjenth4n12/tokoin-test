package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class UtilsRepository {

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
			log.error("Unable to read " + type.getName() + ": " + e.getMessage());
		}
		return result;
	}

}
