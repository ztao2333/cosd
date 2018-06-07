package net.cosd.mapper;

import net.cosd.entity.TUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface TUserMapper {
    //@Select("select * from T_USER where user_id= #{userId}")
    TUser findById(Integer userId);

    //@Select("select user_id  from T_USER where user_id = #{userId}")
    String findName(Integer userId);
}
