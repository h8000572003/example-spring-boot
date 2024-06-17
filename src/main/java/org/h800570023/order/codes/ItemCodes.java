package org.h800570023.order.codes;

public enum ItemCodes implements TextCode {
    A("南部蛋黃粽", 70),//
    B("南部粽", 50),//
    C("北部粽", 70),//
    D("白米豆沙", 45),//
    E("紅豆鹼粽", 35),//
    F("原味鹼粽", 25),//
    ;


    private final String text;
    private final int price;

    ItemCodes(String text, int price) {
        this.text = text;
        this.price = price;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getText() {
        return text;
    }

    public int getPrice() {
        return price;
    }
}
