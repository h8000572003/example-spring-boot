package org.h800570023.order.mapper;

import static org.h800570023.order.mapper.StoreConfigDynamicSqlSupport.*;

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
import org.h800570023.order.model.StoreConfig;
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
public interface StoreConfigMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<StoreConfig>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.44261+08:00", comments="Source Table: store_config")
    BasicColumn[] selectList = BasicColumn.columnList(address, tel, isOpenOrder, url);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.43933+08:00", comments="Source Table: store_config")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="StoreConfigResult", value = {
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_open_order", property="isOpenOrder", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR)
    })
    List<StoreConfig> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.440085+08:00", comments="Source Table: store_config")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("StoreConfigResult")
    Optional<StoreConfig> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.440254+08:00", comments="Source Table: store_config")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, storeConfig, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.440417+08:00", comments="Source Table: store_config")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, storeConfig, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.440814+08:00", comments="Source Table: store_config")
    default int insert(StoreConfig row) {
        return MyBatis3Utils.insert(this::insert, row, storeConfig, c ->
            c.map(address).toProperty("address")
            .map(tel).toProperty("tel")
            .map(isOpenOrder).toProperty("isOpenOrder")
            .map(url).toProperty("url")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.441776+08:00", comments="Source Table: store_config")
    default int insertMultiple(Collection<StoreConfig> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, storeConfig, c ->
            c.map(address).toProperty("address")
            .map(tel).toProperty("tel")
            .map(isOpenOrder).toProperty("isOpenOrder")
            .map(url).toProperty("url")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.442137+08:00", comments="Source Table: store_config")
    default int insertSelective(StoreConfig row) {
        return MyBatis3Utils.insert(this::insert, row, storeConfig, c ->
            c.map(address).toPropertyWhenPresent("address", row::getAddress)
            .map(tel).toPropertyWhenPresent("tel", row::getTel)
            .map(isOpenOrder).toPropertyWhenPresent("isOpenOrder", row::getIsOpenOrder)
            .map(url).toPropertyWhenPresent("url", row::getUrl)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.442918+08:00", comments="Source Table: store_config")
    default Optional<StoreConfig> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, storeConfig, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.443072+08:00", comments="Source Table: store_config")
    default List<StoreConfig> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, storeConfig, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.443219+08:00", comments="Source Table: store_config")
    default List<StoreConfig> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, storeConfig, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.443472+08:00", comments="Source Table: store_config")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, storeConfig, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.443641+08:00", comments="Source Table: store_config")
    static UpdateDSL<UpdateModel> updateAllColumns(StoreConfig row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(address).equalTo(row::getAddress)
                .set(tel).equalTo(row::getTel)
                .set(isOpenOrder).equalTo(row::getIsOpenOrder)
                .set(url).equalTo(row::getUrl);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.443877+08:00", comments="Source Table: store_config")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(StoreConfig row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(address).equalToWhenPresent(row::getAddress)
                .set(tel).equalToWhenPresent(row::getTel)
                .set(isOpenOrder).equalToWhenPresent(row::getIsOpenOrder)
                .set(url).equalToWhenPresent(row::getUrl);
    }
}