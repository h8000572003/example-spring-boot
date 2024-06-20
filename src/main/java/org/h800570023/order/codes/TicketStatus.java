package org.h800570023.order.codes;

public enum TicketStatus implements TextCode {
    A("審查中"),//:審查中
    C("訂單成立"),
    R("準備完成"),
    E("結案"),
    D("訂單取消"),
    ;

    private final String text;

    TicketStatus(String text) {
        this.text = text;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getText() {
        return this.text;
    }
}
