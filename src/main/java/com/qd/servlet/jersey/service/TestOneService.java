package com.qd.servlet.jersey.service;

import com.qd.pojo.Arithmetic;
import com.qd.pojo.Response;

import javax.inject.Singleton;
import javax.ws.rs.*;
import java.util.HashMap;
import java.util.Map;

//默认情况下，资源类的生命周期是per-request，也就是系统会为每个匹配资源类URI的请求创建一个实例，
//这样的效率很低，可以对资源类使用@Singleton注解，这样在应用范围内，只会创建资源类的一个实例
@Singleton
@Path("/v{version}")
public class TestOneService {

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
        double result = 0;
        switch (arithmetic.toString()) {
            case "plus":
                ari.setAction(arithmetic);
                result = first + second;
                ari.setResult(String.valueOf(result));
                System.out.println(arithmetic + result);
                break;
            case "minus":
                ari.setAction(arithmetic);
                result = first - second;
                ari.setResult(String.valueOf(result));
                System.out.println(arithmetic + result);
                break;
            case "multiply":
                ari.setAction(arithmetic);
                result = first * second;
                ari.setResult(String.valueOf(result));
                System.out.println(arithmetic + result);
                break;
            case "divide":
                ari.setAction(arithmetic);
                result = (first / second);
                double result1 = first % second;
                String res = String.valueOf(result) + "." + String.valueOf(result1);
                ari.setResult(String.valueOf(result));
                System.out.println(arithmetic + result);
                break;
            default:
                System.out.println("case in default");
        }
        return ari;
    }

    @POST
    @Path("{arithmetic}")
    public Arithmetic getResultOfPost(@PathParam("arithmetic") String arithmetic, @PathParam("version") double version, @QueryParam("first") double first, @QueryParam("second") double second) {
        Arithmetic ari = new Arithmetic();
        ari.setRet(1000);
        ari.setVersion(version);
        double result = 0;
        switch (arithmetic.toString()) {
            case "plus":
                ari.setAction(arithmetic);
                result = first + second;
                ari.setResult(String.valueOf(result));
                System.out.println(arithmetic + result);
                break;
            case "minus":
                ari.setAction(arithmetic);
                result = first - second;
                ari.setResult(String.valueOf(result));
                System.out.println(arithmetic + result);
                break;
            case "multiply":
                ari.setAction(arithmetic);
                result = first * second;
                ari.setResult(String.valueOf(result));
                System.out.println(arithmetic + result);
                break;
            case "divide":
                ari.setAction(arithmetic);
                result = (first / second);
                double result1 = first % second;
                String res = String.valueOf(result) + "." + String.valueOf(result1);
                ari.setResult(String.valueOf(result));
                System.out.println(arithmetic + result);
                break;
            default:
                System.out.println("case in default");
        }
        return ari;
    }
}
