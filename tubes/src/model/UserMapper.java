package model;

import org.apache.ibatis.annotations.Insert;

public interface UserMapper {
    @Insert("INSERT INTO users (username, password, email) VALUES (#{username}, #{password}, #{email})")
    void registerUser(User user);
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findUserByUsername(String username);
}
