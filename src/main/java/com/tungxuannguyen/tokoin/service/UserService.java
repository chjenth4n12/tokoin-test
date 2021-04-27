package com.tungxuannguyen.tokoin.service;

import java.util.List;

import com.tungxuannguyen.tokoin.entity.UserResponse;
import com.tungxuannguyen.tokoin.model.Organization;
import com.tungxuannguyen.tokoin.model.Ticket;
import com.tungxuannguyen.tokoin.model.User;

public interface UserService {

	UserResponse findUserById(List<Organization> orgRepo, List<Ticket> ticketRepo, List<User> userRepo, Integer id);

	List<UserResponse> findUserBySearchable(List<Organization> orgRepo, List<Ticket> ticketRepo, List<User> userRepo,
			String key, String value);
}
