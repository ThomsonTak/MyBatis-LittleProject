package me.tka.mapping;

import me.tka.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface UserMapperI {
    @Insert("insert into users(name, age) values(#{name}, #{age})")
    public int add(User user);

    @Delete("delete from users where id=#{id}")
    public int delete(int id);
}
