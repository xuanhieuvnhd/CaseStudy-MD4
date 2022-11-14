package com.management.cgmanagement.service.user;

import com.management.cgmanagement.model.dto.ITuition;
import com.management.cgmanagement.model.entity.User;
import com.management.cgmanagement.service.GenericService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends GenericService<User>, UserDetailsService {
    User findByEmail(String email);
    Iterable<User> getUsersNative();
}
