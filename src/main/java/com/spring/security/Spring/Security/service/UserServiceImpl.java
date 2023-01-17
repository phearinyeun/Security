package com.spring.security.Spring.Security.service;

import com.spring.security.Spring.Security.model.User;
import com.spring.security.Spring.Security.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUser(User user) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user, Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            user.setId(id);
            userRepository.save(user);
            return user;
        }
        throw new RuntimeException("Can't find the id" +id);
    }
}
