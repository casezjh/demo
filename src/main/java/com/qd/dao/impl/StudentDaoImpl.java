package com.qd.dao.impl;

import com.qd.dao.StudentDao;
import com.qd.pojo.Student;
import com.qd.util.JDBCUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * author:zhoujuhnhua
 * date:2020/1/21
 * desc:
 **/

public class StudentDaoImpl implements StudentDao {

    private static final Logger log = LoggerFactory.getLogger(StudentDaoImpl.class);

    Connection connection = JDBCUtil.getJDBCConnection();

    @Override
    public List<Student> getAllStudent() throws Exception {
        String sql = "";
        Statement statement = null;
        List<Student> list=new ArrayList<>();
        try {
            statement = connection.createStatement();
            sql="select * from student";
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                Student student=new Student();
                student.setFirstname(resultSet.getString("firstname"));
                student.setLastname(resultSet.getString("lastname"));
                student.setAge(resultSet.getInt("age"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("查询全部学生信息出错");
        }
        if(list.isEmpty()){
           throw  new Exception ("结果集为空");
        }
        return list;
    }
}
