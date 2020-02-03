package com.qd.servlet.jersey.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

@Singleton
@Path("")
@Produces("text/html")
public class IndexService {
    private static final Logger log = LoggerFactory.getLogger(IndexService.class);
    String rootpath = "";

    @GET
    @Path("hello")
    public String getHello() {
        System.out.println("success in hello");
        return "hello";
    }

    @GET
//    @Path("")
    public void send(@Context HttpServletResponse resp, @Context HttpServletRequest req) {
        try {
            rootpath = req.getServletPath();
            log.info(rootpath+"------------>"+"success in send");
            resp.sendRedirect("/page.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("test")
    public void tojsp(@DefaultValue("1") @QueryParam("num") int num, @Context HttpServletRequest req, @Context HttpServletResponse resp) {
        rootpath = req.getServletPath();
        System.out.println(num);
        String jsp = "";
        if (num == 4) {
            jsp = rootpath + "/test" + num + ".jsp";
        } else {
            jsp = rootpath + "/test" + num + ".html";
        }

        try {
            log.info("success in " + jsp);
            resp.sendRedirect(jsp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
