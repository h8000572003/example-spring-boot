package org.h800570023.order.mapper;

import static org.h800570023.order.mapper.LineUserDynamicSqlSupport.*;

import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.h800570023.order.model.LineUser;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface LineUserMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<LineUser>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.578583+08:00", comments="Source Table: line_user")
    BasicColumn[] selectList = BasicColumn.columnList(id, isNotify);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.575391+08:00", comments="Source Table: line_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="LineUserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_notify", property="isNotify", jdbcType=JdbcType.VARCHAR)
    })
    List<LineUser> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.576136+08:00", comments="Source Table: line_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("LineUserResult")
    Optional<LineUser> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.576309+08:00", comments="Source Table: line_user")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, lineUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.576479+08:00", comments="Source Table: line_user")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, lineUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.576826+08:00", comments="Source Table: line_user")
    default int insert(LineUser row) {
        return MyBatis3Utils.insert(this::insert, row, lineUser, c ->
            c.map(id).toProperty("id")
            .map(isNotify).toProperty("isNotify")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.57777+08:00", comments="Source Table: line_user")
    default int insertMultiple(Collection<LineUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, lineUser, c ->
            c.map(id).toProperty("id")
            .map(isNotify).toProperty("isNotify")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.578081+08:00", comments="Source Table: line_user")
    default int insertSelective(LineUser row) {
        return MyBatis3Utils.insert(this::insert, row, lineUser, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(isNotify).toPropertyWhenPresent("isNotify", row::getIsNotify)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.578907+08:00", comments="Source Table: line_user")
    default Optional<LineUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, lineUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.579059+08:00", comments="Source Table: line_user")
    default List<LineUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, lineUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.579202+08:00", comments="Source Table: line_user")
    default List<LineUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, lineUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.579454+08:00", comments="Source Table: line_user")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, lineUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.579616+08:00", comments="Source Table: line_user")
    static UpdateDSL<UpdateModel> updateAllColumns(LineUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(isNotify).equalTo(row::getIsNotify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T20:30:30.579863+08:00", comments="Source Table: line_user")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(LineUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(isNotify).equalToWhenPresent(row::getIsNotify);
    }
}