package com.hbu.live.user.service;


import com.hbu.live.user.model.User;
import com.hbu.live.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByUserId(int userId) {
        return userRepository.findUserByUserId(userId);
    }

}
