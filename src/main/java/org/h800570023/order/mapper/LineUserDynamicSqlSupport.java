package org.h800570023.order.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class LineUserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.574128+08:00", comments="Source Table: line_user")
    public static final LineUser lineUser = new LineUser();

    /**
     * Database Column Remarks:
     *   line帳號
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.574908+08:00", comments="Source field: line_user.id")
    public static final SqlColumn<String> id = lineUser.id;

    /**
     * Database Column Remarks:
     *   是否通知N:否 Y:是
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.575105+08:00", comments="Source field: line_user.is_notify")
    public static final SqlColumn<String> isNotify = lineUser.isNotify;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.574828+08:00", comments="Source Table: line_user")
    public static final class LineUser extends AliasableSqlTable<LineUser> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> isNotify = column("is_notify", JDBCType.VARCHAR);

        public LineUser() {
            super("line_user", LineUser::new);
        }
    }
}