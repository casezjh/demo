package com.qd.servlet.jersey.service;

import com.qd.pojo.Arithmetic;
import com.qd.pojo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

//默认情况下，资源类的生命周期是per-request，也就是系统会为每个匹配资源类URI的请求创建一个实例，
//这样的效率很低，可以对资源类使用@Singleton注解，这样在应用范围内，只会创建资源类的一个实例
@Singleton
@Path("/v{version}")
public class TestOneService {
    public  static  final Logger log=LoggerFactory.getLogger(TestOneService.class);

    @GET
    @Path("/test_api")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response getVersion(@PathParam("version") String version) {
//        Map<String, Integer> map = new HashMap<>();
//        map.put("ret", 1000);
        Response response = new Response();
        response.setRet("1000");
//        response.setNum(1000);
        return response;
    }

    @GET
    @Path("{arithmetic}")
    public Arithmetic getResultOfGet(@PathParam("arithmetic") String arithmetic, @PathParam("version") double version, @QueryParam("first") double first, @QueryParam("second") double second) {
        Arithmetic ari = new Arithmetic();
        ari.setRet(1000);
        ari.setVersion(version);
        double result1 = 0;
        switch (arithmetic.toString()) {
            case "plus":
                ari.setAction(arithmetic);
                result1 = first + second;
                ari.setResult(String.valueOf(result1));
                System.out.println(arithmetic + result1 + "GET");
                break;
            case "minus":
                ari.setAction(arithmetic);
                result1 = first - second;
                ari.setResult(String.valueOf(result1));
                System.out.println(arithmetic + result1);
                break;
            case "multiply":
                ari.setAction(arithmetic);
                result1 = first * second;
                ari.setResult(String.valueOf(result1));
                System.out.println(arithmetic + result1);
                break;
            case "divide":
                ari.setAction(arithmetic);
                result1 = (first / second);
                double result2 = first % second;
                String res = String.valueOf(result1);
                ari.setResult(res);
                System.out.println(arithmetic + res);
                break;
            default:
                System.out.println("case in default");
        }
        return ari;
    }

    //POST请求不能在请求中获取到键值对，而是将值存储在body中
    @POST
    @Path("{arithmetic}")
    @Produces("application/json")
    public Arithmetic getResultOfPost(@Context HttpServletRequest req, @PathParam("arithmetic") String arithmetic, @FormParam("version") double version,
                                      @FormParam("first") double first, @FormParam("second") double second) {
        Arithmetic ari = new Arithmetic();
        ari.setRet(1000);
        ari.setVersion(version);
        double result1 = 0;
        System.out.println(arithmetic + "-------" + version + "----------" + first + "----------" + second);
        switch (arithmetic) {
            case "plus":
                String a = req.getMethod();
                ari.setAction(arithmetic);
                result1 = first + second;
                System.out.println("result1是这两个相加" + first + "-----" + second);
                ari.setResult(String.valueOf(result1));
                System.out.println(arithmetic + result1 + "POST");
                break;
            case "minus":
                ari.setAction(arithmetic);
                result1 = first - second;
                ari.setResult(String.valueOf(result1));
                System.out.println(arithmetic + result1);
                break;
            case "multiply":
                ari.setAction(arithmetic);
                result1 = first * second;
                ari.setResult(String.valueOf(result1));
                System.out.println(arithmetic + result1);
                break;
            case "divide":
                ari.setAction(arithmetic);
                //取整
                result1 = first / second;
                //取余
                double result2 = first % second;
                String res = String.valueOf(result1);
                ari.setResult(res);
                System.out.println(arithmetic + res+"POST");
                break;
            default:
                System.out.println("case in default");
        }
        return ari;
    }
}
