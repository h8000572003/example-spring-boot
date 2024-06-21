package org.h800570023.order.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TicketDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7543169+08:00", comments="Source Table: ticket")
    public static final Ticket ticket = new Ticket();

    /**
     * Database Column Remarks:
     *   交易序號
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7695607+08:00", comments="Source field: ticket.transaction_id")
    public static final SqlColumn<String> transactionId = ticket.transactionId;

    /**
     * Database Column Remarks:
     *   訂購人
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7718692+08:00", comments="Source field: ticket.order_name")
    public static final SqlColumn<String> orderName = ticket.orderName;

    /**
     * Database Column Remarks:
     *   訂購電話
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7718692+08:00", comments="Source field: ticket.order_tel")
    public static final SqlColumn<String> orderTel = ticket.orderTel;

    /**
     * Database Column Remarks:
     *   備註
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7724453+08:00", comments="Source field: ticket.customer_memo")
    public static final SqlColumn<String> customerMemo = ticket.customerMemo;

    /**
     * Database Column Remarks:
     *   狀態 A:審查中 C:已確認  E:結案
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7724453+08:00", comments="Source field: ticket.status")
    public static final SqlColumn<String> status = ticket.status;

    /**
     * Database Column Remarks:
     *   總金額
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7730113+08:00", comments="Source field: ticket.total")
    public static final SqlColumn<Integer> total = ticket.total;

    /**
     * Database Column Remarks:
     *   訂金
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7730113+08:00", comments="Source field: ticket.deposit")
    public static final SqlColumn<Integer> deposit = ticket.deposit;

    /**
     * Database Column Remarks:
     *   訂購日期
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7735225+08:00", comments="Source field: ticket.create_date")
    public static final SqlColumn<Date> createDate = ticket.createDate;

    /**
     * Database Column Remarks:
     *   預期取貨日期
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7735225+08:00", comments="Source field: ticket.pickup_date")
    public static final SqlColumn<String> pickupDate = ticket.pickupDate;

    /**
     * Database Column Remarks:
     *   結案日期
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7735225+08:00", comments="Source field: ticket.close_date")
    public static final SqlColumn<Date> closeDate = ticket.closeDate;

    /**
     * Database Column Remarks:
     *   南部蛋黃肉粽數量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7740815+08:00", comments="Source field: ticket.item_a_count")
    public static final SqlColumn<Integer> itemACount = ticket.itemACount;

    /**
     * Database Column Remarks:
     *   南部粽數量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7740815+08:00", comments="Source field: ticket.item_b_count")
    public static final SqlColumn<Integer> itemBCount = ticket.itemBCount;

    /**
     * Database Column Remarks:
     *   北部肉粽數量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7740815+08:00", comments="Source field: ticket.item_c_count")
    public static final SqlColumn<Integer> itemCCount = ticket.itemCCount;

    /**
     * Database Column Remarks:
     *   白米豆沙數量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7746268+08:00", comments="Source field: ticket.item_d_count")
    public static final SqlColumn<Integer> itemDCount = ticket.itemDCount;

    /**
     * Database Column Remarks:
     *   溫度:H:熱 C:冷凍 N:都行
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7746951+08:00", comments="Source field: ticket.temperature")
    public static final SqlColumn<String> temperature = ticket.temperature;

    /**
     * Database Column Remarks:
     *   處理備註
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7746951+08:00", comments="Source field: ticket.apply_memo")
    public static final SqlColumn<String> applyMemo = ticket.applyMemo;

    /**
     * Database Column Remarks:
     *   紅豆鹼粽
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.775265+08:00", comments="Source field: ticket.item_e_count")
    public static final SqlColumn<Integer> itemECount = ticket.itemECount;

    /**
     * Database Column Remarks:
     *   原味鹼粽
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.775265+08:00", comments="Source field: ticket.item_f_count")
    public static final SqlColumn<Integer> itemFCount = ticket.itemFCount;

    /**
     * Database Column Remarks:
     *   取貨時段
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7758385+08:00", comments="Source field: ticket.pickup")
    public static final SqlColumn<String> pickup = ticket.pickup;

    /**
     * Database Column Remarks:
     *   email
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7758385+08:00", comments="Source field: ticket.email")
    public static final SqlColumn<String> email = ticket.email;

    /**
     * Database Column Remarks:
     *   更新時間
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7764092+08:00", comments="Source field: ticket.update_time")
    public static final SqlColumn<Date> updateTime = ticket.updateTime;

    /**
     * Database Column Remarks:
     *   異動紀錄
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7764092+08:00", comments="Source field: ticket.change_log")
    public static final SqlColumn<String> changeLog = ticket.changeLog;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-20T16:14:24.7689886+08:00", comments="Source Table: ticket")
    public static final class Ticket extends AliasableSqlTable<Ticket> {
        public final SqlColumn<String> transactionId = column("transaction_id", JDBCType.VARCHAR);

        public final SqlColumn<String> orderName = column("order_name", JDBCType.VARCHAR);

        public final SqlColumn<String> orderTel = column("order_tel", JDBCType.VARCHAR);

        public final SqlColumn<String> customerMemo = column("customer_memo", JDBCType.VARCHAR);

        public final SqlColumn<String> status = column("status", JDBCType.VARCHAR);

        public final SqlColumn<Integer> total = column("total", JDBCType.INTEGER);

        public final SqlColumn<Integer> deposit = column("deposit", JDBCType.INTEGER);

        public final SqlColumn<Date> createDate = column("create_date", JDBCType.DATE);

        public final SqlColumn<String> pickupDate = column("pickup_date", JDBCType.CHAR);

        public final SqlColumn<Date> closeDate = column("close_date", JDBCType.DATE);

        public final SqlColumn<Integer> itemACount = column("item_a_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> itemBCount = column("item_b_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> itemCCount = column("item_c_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> itemDCount = column("item_d_count", JDBCType.INTEGER);

        public final SqlColumn<String> temperature = column("temperature", JDBCType.VARCHAR);

        public final SqlColumn<String> applyMemo = column("apply_memo", JDBCType.VARCHAR);

        public final SqlColumn<Integer> itemECount = column("item_e_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> itemFCount = column("item_f_count", JDBCType.INTEGER);

        public final SqlColumn<String> pickup = column("pickup", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> changeLog = column("change_log", JDBCType.VARCHAR);

        public Ticket() {
            super("ticket", Ticket::new);
        }
    }
}