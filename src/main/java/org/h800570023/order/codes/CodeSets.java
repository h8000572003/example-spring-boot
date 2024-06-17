package org.h800570023.order.codes;

public enum CodeSets {
    TEMPERATURE_CODES(TemperatureCodes.class),
    TICKET_STATUS(TicketStatus.class),//訂單狀態
    ITEM_CODES(ItemCodes.class),//商品代碼
    PICKUP_TIMES(PickupTimes.class),//取貨時間
    PICKUP_TIMES_IN_SQL("select distinct pickup_date key,pickup_date value from ticket where status not in('E') order by pickup_date asc"),//取貨時間
    ;

    private final Class<? extends TextCode> codeClass;
    private final String sql;

    CodeSets(Class<? extends TextCode> codeClass) {
        this.codeClass = codeClass;
        this.sql = "";
    }

    CodeSets(String sql) {
        this.sql = sql;
        this.codeClass = null;
    }

    public Class<? extends TextCode> getCodeClass() {
        return codeClass;
    }

    public String getSql() {
        return sql;
    }
}
