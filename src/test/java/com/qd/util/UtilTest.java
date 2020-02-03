package com.qd.util;

import com.qd.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.sql.Connection;
import java.util.List;

/**
 * author:zhoujuhnhua
 * date:2020/1/21
 * desc:
 **/
public class UtilTest {
    private static final Logger log=LoggerFactory.getLogger(UtilTest.class);

    private StudentServiceImpl studentService;
    @Test
    public void testConnection(){
        Connection connection=JDBCUtil.getJDBCConnection();
        log.info(connection.toString());
    }
    @Test
    public void getAllStudnet(){
        studentService=new StudentServiceImpl();
        try {
            List list=studentService.getAllStudent();
            log.info(String.valueOf(list.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
