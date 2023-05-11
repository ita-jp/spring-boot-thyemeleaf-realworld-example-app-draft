package com.pocotech.conduit.repository.user;

import com.pocotech.conduit.repository.UserRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;
import java.util.UUID;

@Mapper
public interface UserRepository {

    @Insert("INSERT INTO users (id, username, email, password) VALUES (#{id}, #{username}, #{email}, #{password})")
    void insert(
            @Param("id") UUID id,
            @Param("username") String username,
            @Param("email") String email,
            @Param("password") String password
    );

    @Select("SELECT * FROM users WHERE email = #{email}")
    Optional<UserRecord> selectByEmail(@Param("email") String email);

    @Select("SELECT * FROM users WHERE username = #{username}")
    Optional<UserRecord> selectByUsername(@Param("username") String username);
}
