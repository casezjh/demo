package com.qd.service.impl;

import com.qd.dao.StudentDao;
import com.qd.dao.impl.StudentDaoImpl;
import com.qd.pojo.Student;
import com.qd.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * author:zhoujuhnhua
 * date:2020/1/21
 * desc:
 **/
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

     StudentDao studentDao=new StudentDaoImpl();



    @Override
    public List<Student> getAllStudent() throws Exception {
        List<Student> listStu = studentDao.getAllStudent();
        return listStu;
    }
}
