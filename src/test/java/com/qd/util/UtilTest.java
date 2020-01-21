package com.qd.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

/**
 * author:zhoujuhnhua
 * date:2020/1/21
 * desc:
 **/
public class UtilTest {
    private static final Logger log=LoggerFactory.getLogger(UtilTest.class);

    @Test
    public void testConnection(){
        Connection connection=JDBCUtil.getJDBCConnection();
        log.info(connection.toString());
    }
    @Test
    public void testReadFile(){

    }

}
