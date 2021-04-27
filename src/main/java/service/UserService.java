package service;

import java.util.List;

import entity.UserResponse;
import model.Organization;
import model.Ticket;
import model.User;

public interface UserService {

	UserResponse findUserById(List<Organization> orgRepo, List<Ticket> ticketRepo, List<User> userRepo, Integer id);

	List<UserResponse> findUserBySearchable(List<Organization> orgRepo, List<Ticket> ticketRepo, List<User> userRepo,
			String key, String value);
}
