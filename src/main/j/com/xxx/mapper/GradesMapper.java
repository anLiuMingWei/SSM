package com.xxx.mapper;

import java.util.List;

import com.xxx.modal.Grades;

public interface GradesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Grades record);

    int insertSelective(Grades record);

    Grades selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Grades record);

    int updateByPrimaryKey(Grades record);
    
    List<Grades> selectAll();
}