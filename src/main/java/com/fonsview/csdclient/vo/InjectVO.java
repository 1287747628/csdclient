package com.fonsview.csdclient.vo;

import java.util.List;

public class InjectVO {

    private String spNo;
    private String cpNo;
    private String signature;
    private List<String> instances;
    private String type;

    public String getSpNo() {
        return spNo;
    }

    public void setSpNo(String spNo) {
        this.spNo = spNo;
    }

    public String getCpNo() {
        return cpNo;
    }

    public void setCpNo(String cpNo) {
        this.cpNo = cpNo;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public List<String> getInstances() {
        return instances;
    }

    public void setInstances(List<String> instances) {
        this.instances = instances;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
