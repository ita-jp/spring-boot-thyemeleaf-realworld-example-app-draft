package com.pocotech.conduit.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleRepository {

    @Select("SELECT id, author_id, title, description, body, created_at, updated_at FROM articles")
    List<ArticleRecord> select();

}
