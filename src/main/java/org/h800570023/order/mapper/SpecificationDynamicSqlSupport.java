package org.h800570023.order.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class SpecificationDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.205768+08:00", comments="Source Table: specification")
    public static final Specification specification = new Specification();

    /**
     * Database Column Remarks:
     *   品項代碼
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.206567+08:00", comments="Source field: specification.id")
    public static final SqlColumn<String> id = specification.id;

    /**
     * Database Column Remarks:
     *   名稱
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.206766+08:00", comments="Source field: specification.name")
    public static final SqlColumn<String> name = specification.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.206818+08:00", comments="Source field: specification.price")
    public static final SqlColumn<Integer> price = specification.price;

    /**
     * Database Column Remarks:
     *   說明
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.206863+08:00", comments="Source field: specification.memo")
    public static final SqlColumn<String> memo = specification.memo;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.206488+08:00", comments="Source Table: specification")
    public static final class Specification extends AliasableSqlTable<Specification> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> price = column("price", JDBCType.INTEGER);

        public final SqlColumn<String> memo = column("memo", JDBCType.VARCHAR);

        public Specification() {
            super("specification", Specification::new);
        }
    }
}