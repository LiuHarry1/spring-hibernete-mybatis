package com.example.transactiondemo.mapper;

import com.example.transactiondemo.entity.MyBatisEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyBatisMapper {
    @Insert("INSERT INTO mybatis_entity (name) VALUES (#{name})")
    void insert(MyBatisEntity myBatisEntity);

    @Select("SELECT COUNT(*) FROM MYBATIS_ENTITY")
    int getCount();

    @Delete("delete from mybatis_entity")
    void deleteAllData();
}
