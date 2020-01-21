package com.qd.dao;

import com.qd.pojo.Student;

import java.util.List;

/**
 * author:zhoujuhnhua
 * date:2020/1/21
 * desc:
 **/
public interface StudentDao {

    public List<Student> getAllStudent() throws Exception;
}
