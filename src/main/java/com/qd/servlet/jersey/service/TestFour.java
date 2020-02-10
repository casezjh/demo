package com.qd.servlet.jersey.service;

import com.qd.pojo.Student;
import com.qd.service.impl.StudentServiceImpl;
import org.glassfish.jersey.server.mvc.Viewable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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

    StudentServiceImpl studentService = new StudentServiceImpl();

    @GET
    @Path("tutorial/student/list")
    @Consumes("application/x-www-form-urlencoded")
//    @Produces("text/html")
    public Viewable listStu(@Context HttpServletRequest req, @Context HttpServletResponse resp) {
        String rootpath = req.getServletPath();
        List model = new ArrayList();
        try {
            model = studentService.getAllStudent();
            req.setAttribute("listStu", model);
            String jsp = rootpath + "/test4.jsp";
//            resp.sendRedirect(jsp);
//            req.getRequestDispatcher(jsp).forward(req,resp);
            Viewable viewable = new Viewable(jsp, model);
            System.out.println("success in viewable");
            return viewable;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
