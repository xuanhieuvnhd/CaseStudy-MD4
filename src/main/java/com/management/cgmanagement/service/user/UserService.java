package com.management.cgmanagement.service.user;

import com.management.cgmanagement.model.dto.UserPrinciple;
import com.management.cgmanagement.model.entity.User;
import com.management.cgmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
    userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(mail);
        if (userOptional.isPresent()){
            return UserPrinciple.build(userOptional.get());
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email).get();
        return user;
    }

    @Override
    public Iterable<User> getUsersNative() {
        return userRepository.getUserNative();
    }
}
