package org.h800570023.order.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class StoreConfigDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.437873+08:00", comments="Source Table: store_config")
    public static final StoreConfig storeConfig = new StoreConfig();

    /**
     * Database Column Remarks:
     *   地址
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.438724+08:00", comments="Source field: store_config.address")
    public static final SqlColumn<String> address = storeConfig.address;

    /**
     * Database Column Remarks:
     *   電話
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.438914+08:00", comments="Source field: store_config.tel")
    public static final SqlColumn<String> tel = storeConfig.tel;

    /**
     * Database Column Remarks:
     *   是否開放訂購
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.438964+08:00", comments="Source field: store_config.is_open_order")
    public static final SqlColumn<String> isOpenOrder = storeConfig.isOpenOrder;

    /**
     * Database Column Remarks:
     *   網站url
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.439011+08:00", comments="Source field: store_config.url")
    public static final SqlColumn<String> url = storeConfig.url;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.438635+08:00", comments="Source Table: store_config")
    public static final class StoreConfig extends AliasableSqlTable<StoreConfig> {
        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<String> tel = column("tel", JDBCType.VARCHAR);

        public final SqlColumn<String> isOpenOrder = column("is_open_order", JDBCType.VARCHAR);

        public final SqlColumn<String> url = column("url", JDBCType.VARCHAR);

        public StoreConfig() {
            super("store_config", StoreConfig::new);
        }
    }
}