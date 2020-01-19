package com.qd.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Arithmetic {
    private double ret;
    private double version;
    private String result;
    private String action;

    public double getRet() {
        return ret;
    }

    public void setRet(double ret) {
        this.ret = ret;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
