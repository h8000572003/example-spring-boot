package org.h800570023.order.mapper;

import static org.h800570023.order.mapper.SpecificationDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

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
import org.h800570023.order.model.Specification;
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
public interface SpecificationMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Specification>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.210672+08:00", comments="Source Table: specification")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, price, memo);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.207146+08:00", comments="Source Table: specification")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SpecificationResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="memo", property="memo", jdbcType=JdbcType.VARCHAR)
    })
    List<Specification> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.207906+08:00", comments="Source Table: specification")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SpecificationResult")
    Optional<Specification> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.208075+08:00", comments="Source Table: specification")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, specification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.208231+08:00", comments="Source Table: specification")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, specification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.208472+08:00", comments="Source Table: specification")
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.208735+08:00", comments="Source Table: specification")
    default int insert(Specification row) {
        return MyBatis3Utils.insert(this::insert, row, specification, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(price).toProperty("price")
            .map(memo).toProperty("memo")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.209788+08:00", comments="Source Table: specification")
    default int insertMultiple(Collection<Specification> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, specification, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(price).toProperty("price")
            .map(memo).toProperty("memo")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.210157+08:00", comments="Source Table: specification")
    default int insertSelective(Specification row) {
        return MyBatis3Utils.insert(this::insert, row, specification, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(price).toPropertyWhenPresent("price", row::getPrice)
            .map(memo).toPropertyWhenPresent("memo", row::getMemo)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.210961+08:00", comments="Source Table: specification")
    default Optional<Specification> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, specification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.211096+08:00", comments="Source Table: specification")
    default List<Specification> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, specification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.211239+08:00", comments="Source Table: specification")
    default List<Specification> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, specification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.211377+08:00", comments="Source Table: specification")
    default Optional<Specification> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.211504+08:00", comments="Source Table: specification")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, specification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.211668+08:00", comments="Source Table: specification")
    static UpdateDSL<UpdateModel> updateAllColumns(Specification row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(name).equalTo(row::getName)
                .set(price).equalTo(row::getPrice)
                .set(memo).equalTo(row::getMemo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.211865+08:00", comments="Source Table: specification")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Specification row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(name).equalToWhenPresent(row::getName)
                .set(price).equalToWhenPresent(row::getPrice)
                .set(memo).equalToWhenPresent(row::getMemo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.212186+08:00", comments="Source Table: specification")
    default int updateByPrimaryKey(Specification row) {
        return update(c ->
            c.set(name).equalTo(row::getName)
            .set(price).equalTo(row::getPrice)
            .set(memo).equalTo(row::getMemo)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T20:18:56.212415+08:00", comments="Source Table: specification")
    default int updateByPrimaryKeySelective(Specification row) {
        return update(c ->
            c.set(name).equalToWhenPresent(row::getName)
            .set(price).equalToWhenPresent(row::getPrice)
            .set(memo).equalToWhenPresent(row::getMemo)
            .where(id, isEqualTo(row::getId))
        );
    }
}