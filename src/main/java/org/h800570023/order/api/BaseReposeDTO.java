package org.h800570023.order.api;

public class BaseReposeDTO {
    private String exCode="O";
    private String exMessage="";

    public String getExCode() {
        return this.exCode;
    }

    public String getExMessage() {
        return this.exMessage;
    }

    public void setExCode(String exCode) {
        this.exCode = exCode;
    }

    public void setExMessage(String exMessage) {
        this.exMessage = exMessage;
    }
}
