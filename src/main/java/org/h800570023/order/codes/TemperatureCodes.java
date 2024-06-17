package org.h800570023.order.codes;

public enum TemperatureCodes implements TextCode {
    H("熱"),
    C("冷"),
    N("都行"),
    ;

    private final String text;

    TemperatureCodes(String text) {
        this.text = text;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getText() {
        return text;
    }
}
