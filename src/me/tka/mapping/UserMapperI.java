package me.tka.mapping;

import me.tka.domain.User;
import org.apache.ibatis.annotations.Insert;

public interface UserMapperI {
    @Insert("insert into users(name, age) values(#{name}, #{age})")
    public int add(User user);
}
