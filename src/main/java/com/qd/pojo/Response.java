package com.qd.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

    private String ret;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    @Override
    public String toString() {
        return "Response{" +
                "ret='" + ret + '\'' +
                '}';
    }
}
