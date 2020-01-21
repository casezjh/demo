package com.qd.service.impl;

import com.qd.dao.StudentDao;
import com.qd.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * author:zhoujuhnhua
 * date:2020/1/21
 * desc:
 **/
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Resource
    private StudentDao studentDao;



}
