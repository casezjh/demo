package com.qd.servlet.jersey.service;


import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

@Singleton
@Path("")
@Produces("text/html")
public class IndexService {

    String rootpath="";
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
            rootpath=req.getServletPath();
            System.out.println(rootpath);
            System.out.println(" success in send");
            resp.sendRedirect("/page.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("test")
    public void tojsp(@DefaultValue("1") @QueryParam("num") int num, @Context HttpServletRequest req,@Context HttpServletResponse resp) {
        rootpath=req.getServletPath();
        System.out.println(num);
        String jsp = rootpath+"/test" + num + ".html";
        System.out.println(jsp);
        try {
            System.out.println("success in " + jsp);
            resp.sendRedirect(jsp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
