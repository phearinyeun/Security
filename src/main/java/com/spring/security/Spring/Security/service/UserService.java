package com.spring.security.Spring.Security.service;

import com.spring.security.Spring.Security.model.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User create (User user);
    List<User> getAllUser(User user);
    Optional<User> findById(Long id);
    void deleteById(Long id);
    User update(User user, Long id);
}
