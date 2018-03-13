package net.cosd.service.impl;

import net.cosd.entity.TUser;
import net.cosd.mapper.TUserMapper;
import net.cosd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper tUserMapper;
    @Override
    public String select(int a) {
        return "select method";
    }

    @Override
    public TUser findUserById(Integer id) {
        TUser tuser = tUserMapper.findById(id);
        return tuser;
    }
}
