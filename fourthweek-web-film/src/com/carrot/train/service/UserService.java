package com.carrot.train.service;

import com.carrot.train.enetity.User;

public interface UserService {
    public void registUser(User user);
    public User login(User user);
    public boolean existsUsername(String username);

}
