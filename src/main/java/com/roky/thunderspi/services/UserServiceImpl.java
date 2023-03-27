package com.roky.thunderspi.services;

import com.roky.thunderspi.entities.User;
import com.roky.thunderspi.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private UserRepo userRepo;

    @Override
    public User findById(long id) {
        return null;
    }
}
