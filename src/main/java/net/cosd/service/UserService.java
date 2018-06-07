package net.cosd.service;

import net.cosd.entity.TUser;

public interface UserService {

    String select (int a);
    TUser findUserById(Integer id);

    String findUserName(Integer userId);
}
