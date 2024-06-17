package org.h800570023.order.codes;

public enum PickupTimes implements TextCode {
    G("上午(10:00~12:00)"),//:審查中
    M("中午(12:00~14:00)"),
    N("晚上(16:00~20:00)"),
    ;


    private final String text;

    PickupTimes(String text) {
        this.text = text;
    }

    @Override
    public String getCode() {
        return "";
    }

    @Override
    public String getText() {
        return "";
    }
}
