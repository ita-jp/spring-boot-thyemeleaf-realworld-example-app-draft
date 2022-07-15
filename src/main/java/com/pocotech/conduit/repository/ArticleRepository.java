package com.pocotech.conduit.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ArticleRepository {

    @Select("""
            SELECT
                a.id
              , a.slug
              , a.user_id
              , a.title
              , a.description
              , a.body
              , a.created_at
              , a.updated_at
              , u.id as user_id
              , u.username as user_username
              , u.created_at as user_created_at
              , u.updated_at as user_updated_at
            FROM articles a
            JOIN users u on a.user_id = u.id
            """)
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "slug", property = "slug"),
            @Result(column = "title", property = "title"),
            @Result(column = "description", property = "description"),
            @Result(column = "body", property = "body"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "updated_at", property = "updatedAt"),
            @Result(property = "user", one = @One(resultMap = "userResultMap", columnPrefix = "user_"))
    })
    List<ArticleRecord> select();

    @Select("SELECT 1")
    @Results(id = "userResultMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "updated_at", property = "updatedAt")
    })
    UserRecord __userResultMap();

    @Select("""
            SELECT
                a.id
              , a.slug
              , a.user_id
              , a.title
              , a.description
              , a.body
              , a.created_at
              , a.updated_at
              , u.id as user_id
              , u.username as user_username
              , u.created_at as user_created_at
              , u.updated_at as user_updated_at
            FROM articles a
            JOIN users u on a.user_id = u.id
            WHERE slug = #{slug}
            """)
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "slug", property = "slug"),
            @Result(column = "title", property = "title"),
            @Result(column = "description", property = "description"),
            @Result(column = "body", property = "body"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "updated_at", property = "updatedAt"),
            @Result(property = "user", one = @One(resultMap = "userResultMap", columnPrefix = "user_"))
    })
    Optional<ArticleRecord> selectBySlug(String slug);

}
