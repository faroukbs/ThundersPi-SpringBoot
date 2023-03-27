package com.roky.thunderspi.services;

import com.roky.thunderspi.entities.User;

public interface IUserService {
    public User findById(long id);
}
