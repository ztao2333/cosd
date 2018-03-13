package net.cosd.mapper;

import net.cosd.entity.TUser;
import org.springframework.stereotype.Component;

@Component
public interface TUserMapper {

    TUser findById(Integer userId);
}
