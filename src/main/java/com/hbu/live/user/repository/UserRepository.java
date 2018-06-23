package com.hbu.live.user.repository;

import com.hbu.live.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
        User findUserByUserId(int userId);
}
