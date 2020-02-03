package com.qd.servlet.jersey.service;

import com.qd.pojo.Student;
import com.qd.service.impl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;

/**
 * author:zhoujuhnhua
 * date:2020/2/3
 * desc:
 **/
@Path("page")
public class TestFour {

    private static final Logger log = LoggerFactory.getLogger(TestFour.class);

    @Resource
    private StudentServiceImpl studentService;

    @Path("tutorial/student/list")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html")
    public void listStu(@Context HttpServletRequest req, @Context HttpServletResponse resp) {
       String rootpath = req.getServletPath();
        List list = new ArrayList();
        try {
            list = studentService.getAllStudent();
            req.setAttribute("listStu", list);
            String jsp= rootpath + "/test4.jsp";
            resp.sendRedirect(jsp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
