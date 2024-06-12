package com.example.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class OrderDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1063266+08:00", comments="Source Table: order")
    public static final Order order = new Order();

    /**
     * Database Column Remarks:
     *   交易序號
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1153234+08:00", comments="Source field: order.transaction_id")
    public static final SqlColumn<String> transactionId = order.transactionId;

    /**
     * Database Column Remarks:
     *   訂購人
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1173211+08:00", comments="Source field: order.order_name")
    public static final SqlColumn<String> orderName = order.orderName;

    /**
     * Database Column Remarks:
     *   訂購電話
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1173211+08:00", comments="Source field: order.order_tel")
    public static final SqlColumn<String> orderTel = order.orderTel;

    /**
     * Database Column Remarks:
     *   備註
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1183231+08:00", comments="Source field: order.customer_memo")
    public static final SqlColumn<String> customerMemo = order.customerMemo;

    /**
     * Database Column Remarks:
     *   狀態 A:審查中 C:已確認  E:結案
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1183231+08:00", comments="Source field: order.status")
    public static final SqlColumn<String> status = order.status;

    /**
     * Database Column Remarks:
     *   總金額
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1183231+08:00", comments="Source field: order.total")
    public static final SqlColumn<Integer> total = order.total;

    /**
     * Database Column Remarks:
     *   訂金
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1183231+08:00", comments="Source field: order.deposit")
    public static final SqlColumn<Integer> deposit = order.deposit;

    /**
     * Database Column Remarks:
     *   訂購日期
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.119325+08:00", comments="Source field: order.create_date")
    public static final SqlColumn<Date> createDate = order.createDate;

    /**
     * Database Column Remarks:
     *   預期取貨日期
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.119325+08:00", comments="Source field: order.pickup_date")
    public static final SqlColumn<Date> pickupDate = order.pickupDate;

    /**
     * Database Column Remarks:
     *   結案日期
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.119325+08:00", comments="Source field: order.close_date")
    public static final SqlColumn<Date> closeDate = order.closeDate;

    /**
     * Database Column Remarks:
     *   南部蛋黃肉粽數量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1203269+08:00", comments="Source field: order.item_a_count")
    public static final SqlColumn<Integer> itemACount = order.itemACount;

    /**
     * Database Column Remarks:
     *   南部粽數量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1203269+08:00", comments="Source field: order.item_b_count")
    public static final SqlColumn<Integer> itemBCount = order.itemBCount;

    /**
     * Database Column Remarks:
     *   北部肉粽數量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1203269+08:00", comments="Source field: order.item_c_count")
    public static final SqlColumn<Integer> itemCCount = order.itemCCount;

    /**
     * Database Column Remarks:
     *   白米豆沙數量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1203269+08:00", comments="Source field: order.item_d_count")
    public static final SqlColumn<Integer> itemDCount = order.itemDCount;

    /**
     * Database Column Remarks:
     *   溫度:H:熱 C:冷凍 N:都行
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1213292+08:00", comments="Source field: order.temperature")
    public static final SqlColumn<String> temperature = order.temperature;

    /**
     * Database Column Remarks:
     *   處理備註
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1213292+08:00", comments="Source field: order.apply_memo")
    public static final SqlColumn<String> applyMemo = order.applyMemo;

    /**
     * Database Column Remarks:
     *   紅豆鹼粽
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1213292+08:00", comments="Source field: order.item_e_count")
    public static final SqlColumn<Integer> itemECount = order.itemECount;

    /**
     * Database Column Remarks:
     *   原味鹼粽
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.122326+08:00", comments="Source field: order.item_f_count")
    public static final SqlColumn<Integer> itemFCount = order.itemFCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1143227+08:00", comments="Source Table: order")
    public static final class Order extends AliasableSqlTable<Order> {
        public final SqlColumn<String> transactionId = column("transaction_id", JDBCType.VARCHAR);

        public final SqlColumn<String> orderName = column("order_name", JDBCType.VARCHAR);

        public final SqlColumn<String> orderTel = column("order_tel", JDBCType.VARCHAR);

        public final SqlColumn<String> customerMemo = column("customer_memo", JDBCType.VARCHAR);

        public final SqlColumn<String> status = column("status", JDBCType.VARCHAR);

        public final SqlColumn<Integer> total = column("total", JDBCType.INTEGER);

        public final SqlColumn<Integer> deposit = column("deposit", JDBCType.INTEGER);

        public final SqlColumn<Date> createDate = column("create_date", JDBCType.DATE);

        public final SqlColumn<Date> pickupDate = column("pickup_date", JDBCType.DATE);

        public final SqlColumn<Date> closeDate = column("close_date", JDBCType.DATE);

        public final SqlColumn<Integer> itemACount = column("item_a_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> itemBCount = column("item_b_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> itemCCount = column("item_c_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> itemDCount = column("item_d_count", JDBCType.INTEGER);

        public final SqlColumn<String> temperature = column("temperature", JDBCType.VARCHAR);

        public final SqlColumn<String> applyMemo = column("apply_memo", JDBCType.VARCHAR);

        public final SqlColumn<Integer> itemECount = column("item_e_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> itemFCount = column("item_f_count", JDBCType.INTEGER);

        public Order() {
            super("order", Order::new);
        }
    }
}