package com.example.mapper;

import static com.example.mapper.OrderDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.example.model.Order;
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
public interface OrderMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Order>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1733272+08:00", comments="Source Table: order")
    BasicColumn[] selectList = BasicColumn.columnList(transactionId, orderName, orderTel, customerMemo, status, total, deposit, createDate, pickupDate, closeDate, itemACount, itemBCount, itemCCount, itemDCount, temperature, applyMemo, itemECount, itemFCount);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1263209+08:00", comments="Source Table: order")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrderResult", value = {
        @Result(column="transaction_id", property="transactionId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="order_name", property="orderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_tel", property="orderTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_memo", property="customerMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="total", property="total", jdbcType=JdbcType.INTEGER),
        @Result(column="deposit", property="deposit", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="pickup_date", property="pickupDate", jdbcType=JdbcType.DATE),
        @Result(column="close_date", property="closeDate", jdbcType=JdbcType.DATE),
        @Result(column="item_a_count", property="itemACount", jdbcType=JdbcType.INTEGER),
        @Result(column="item_b_count", property="itemBCount", jdbcType=JdbcType.INTEGER),
        @Result(column="item_c_count", property="itemCCount", jdbcType=JdbcType.INTEGER),
        @Result(column="item_d_count", property="itemDCount", jdbcType=JdbcType.INTEGER),
        @Result(column="temperature", property="temperature", jdbcType=JdbcType.VARCHAR),
        @Result(column="apply_memo", property="applyMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="item_e_count", property="itemECount", jdbcType=JdbcType.INTEGER),
        @Result(column="item_f_count", property="itemFCount", jdbcType=JdbcType.INTEGER)
    })
    List<Order> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1373229+08:00", comments="Source Table: order")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrderResult")
    Optional<Order> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1423232+08:00", comments="Source Table: order")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, order, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1453246+08:00", comments="Source Table: order")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, order, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1483266+08:00", comments="Source Table: order")
    default int deleteByPrimaryKey(String transactionId_) {
        return delete(c -> 
            c.where(transactionId, isEqualTo(transactionId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1503249+08:00", comments="Source Table: order")
    default int insert(Order row) {
        return MyBatis3Utils.insert(this::insert, row, order, c ->
            c.map(transactionId).toProperty("transactionId")
            .map(orderName).toProperty("orderName")
            .map(orderTel).toProperty("orderTel")
            .map(customerMemo).toProperty("customerMemo")
            .map(status).toProperty("status")
            .map(total).toProperty("total")
            .map(deposit).toProperty("deposit")
            .map(createDate).toProperty("createDate")
            .map(pickupDate).toProperty("pickupDate")
            .map(closeDate).toProperty("closeDate")
            .map(itemACount).toProperty("itemACount")
            .map(itemBCount).toProperty("itemBCount")
            .map(itemCCount).toProperty("itemCCount")
            .map(itemDCount).toProperty("itemDCount")
            .map(temperature).toProperty("temperature")
            .map(applyMemo).toProperty("applyMemo")
            .map(itemECount).toProperty("itemECount")
            .map(itemFCount).toProperty("itemFCount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1613226+08:00", comments="Source Table: order")
    default int insertMultiple(Collection<Order> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, order, c ->
            c.map(transactionId).toProperty("transactionId")
            .map(orderName).toProperty("orderName")
            .map(orderTel).toProperty("orderTel")
            .map(customerMemo).toProperty("customerMemo")
            .map(status).toProperty("status")
            .map(total).toProperty("total")
            .map(deposit).toProperty("deposit")
            .map(createDate).toProperty("createDate")
            .map(pickupDate).toProperty("pickupDate")
            .map(closeDate).toProperty("closeDate")
            .map(itemACount).toProperty("itemACount")
            .map(itemBCount).toProperty("itemBCount")
            .map(itemCCount).toProperty("itemCCount")
            .map(itemDCount).toProperty("itemDCount")
            .map(temperature).toProperty("temperature")
            .map(applyMemo).toProperty("applyMemo")
            .map(itemECount).toProperty("itemECount")
            .map(itemFCount).toProperty("itemFCount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1643204+08:00", comments="Source Table: order")
    default int insertSelective(Order row) {
        return MyBatis3Utils.insert(this::insert, row, order, c ->
            c.map(transactionId).toPropertyWhenPresent("transactionId", row::getTransactionId)
            .map(orderName).toPropertyWhenPresent("orderName", row::getOrderName)
            .map(orderTel).toPropertyWhenPresent("orderTel", row::getOrderTel)
            .map(customerMemo).toPropertyWhenPresent("customerMemo", row::getCustomerMemo)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
            .map(total).toPropertyWhenPresent("total", row::getTotal)
            .map(deposit).toPropertyWhenPresent("deposit", row::getDeposit)
            .map(createDate).toPropertyWhenPresent("createDate", row::getCreateDate)
            .map(pickupDate).toPropertyWhenPresent("pickupDate", row::getPickupDate)
            .map(closeDate).toPropertyWhenPresent("closeDate", row::getCloseDate)
            .map(itemACount).toPropertyWhenPresent("itemACount", row::getItemACount)
            .map(itemBCount).toPropertyWhenPresent("itemBCount", row::getItemBCount)
            .map(itemCCount).toPropertyWhenPresent("itemCCount", row::getItemCCount)
            .map(itemDCount).toPropertyWhenPresent("itemDCount", row::getItemDCount)
            .map(temperature).toPropertyWhenPresent("temperature", row::getTemperature)
            .map(applyMemo).toPropertyWhenPresent("applyMemo", row::getApplyMemo)
            .map(itemECount).toPropertyWhenPresent("itemECount", row::getItemECount)
            .map(itemFCount).toPropertyWhenPresent("itemFCount", row::getItemFCount)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1793426+08:00", comments="Source Table: order")
    default Optional<Order> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, order, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1813406+08:00", comments="Source Table: order")
    default List<Order> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, order, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1833407+08:00", comments="Source Table: order")
    default List<Order> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, order, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1853419+08:00", comments="Source Table: order")
    default Optional<Order> selectByPrimaryKey(String transactionId_) {
        return selectOne(c ->
            c.where(transactionId, isEqualTo(transactionId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1873397+08:00", comments="Source Table: order")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, order, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1893424+08:00", comments="Source Table: order")
    static UpdateDSL<UpdateModel> updateAllColumns(Order row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(transactionId).equalTo(row::getTransactionId)
                .set(orderName).equalTo(row::getOrderName)
                .set(orderTel).equalTo(row::getOrderTel)
                .set(customerMemo).equalTo(row::getCustomerMemo)
                .set(status).equalTo(row::getStatus)
                .set(total).equalTo(row::getTotal)
                .set(deposit).equalTo(row::getDeposit)
                .set(createDate).equalTo(row::getCreateDate)
                .set(pickupDate).equalTo(row::getPickupDate)
                .set(closeDate).equalTo(row::getCloseDate)
                .set(itemACount).equalTo(row::getItemACount)
                .set(itemBCount).equalTo(row::getItemBCount)
                .set(itemCCount).equalTo(row::getItemCCount)
                .set(itemDCount).equalTo(row::getItemDCount)
                .set(temperature).equalTo(row::getTemperature)
                .set(applyMemo).equalTo(row::getApplyMemo)
                .set(itemECount).equalTo(row::getItemECount)
                .set(itemFCount).equalTo(row::getItemFCount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1913464+08:00", comments="Source Table: order")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Order row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(transactionId).equalToWhenPresent(row::getTransactionId)
                .set(orderName).equalToWhenPresent(row::getOrderName)
                .set(orderTel).equalToWhenPresent(row::getOrderTel)
                .set(customerMemo).equalToWhenPresent(row::getCustomerMemo)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(total).equalToWhenPresent(row::getTotal)
                .set(deposit).equalToWhenPresent(row::getDeposit)
                .set(createDate).equalToWhenPresent(row::getCreateDate)
                .set(pickupDate).equalToWhenPresent(row::getPickupDate)
                .set(closeDate).equalToWhenPresent(row::getCloseDate)
                .set(itemACount).equalToWhenPresent(row::getItemACount)
                .set(itemBCount).equalToWhenPresent(row::getItemBCount)
                .set(itemCCount).equalToWhenPresent(row::getItemCCount)
                .set(itemDCount).equalToWhenPresent(row::getItemDCount)
                .set(temperature).equalToWhenPresent(row::getTemperature)
                .set(applyMemo).equalToWhenPresent(row::getApplyMemo)
                .set(itemECount).equalToWhenPresent(row::getItemECount)
                .set(itemFCount).equalToWhenPresent(row::getItemFCount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1938555+08:00", comments="Source Table: order")
    default int updateByPrimaryKey(Order row) {
        return update(c ->
            c.set(orderName).equalTo(row::getOrderName)
            .set(orderTel).equalTo(row::getOrderTel)
            .set(customerMemo).equalTo(row::getCustomerMemo)
            .set(status).equalTo(row::getStatus)
            .set(total).equalTo(row::getTotal)
            .set(deposit).equalTo(row::getDeposit)
            .set(createDate).equalTo(row::getCreateDate)
            .set(pickupDate).equalTo(row::getPickupDate)
            .set(closeDate).equalTo(row::getCloseDate)
            .set(itemACount).equalTo(row::getItemACount)
            .set(itemBCount).equalTo(row::getItemBCount)
            .set(itemCCount).equalTo(row::getItemCCount)
            .set(itemDCount).equalTo(row::getItemDCount)
            .set(temperature).equalTo(row::getTemperature)
            .set(applyMemo).equalTo(row::getApplyMemo)
            .set(itemECount).equalTo(row::getItemECount)
            .set(itemFCount).equalTo(row::getItemFCount)
            .where(transactionId, isEqualTo(row::getTransactionId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:47.1958705+08:00", comments="Source Table: order")
    default int updateByPrimaryKeySelective(Order row) {
        return update(c ->
            c.set(orderName).equalToWhenPresent(row::getOrderName)
            .set(orderTel).equalToWhenPresent(row::getOrderTel)
            .set(customerMemo).equalToWhenPresent(row::getCustomerMemo)
            .set(status).equalToWhenPresent(row::getStatus)
            .set(total).equalToWhenPresent(row::getTotal)
            .set(deposit).equalToWhenPresent(row::getDeposit)
            .set(createDate).equalToWhenPresent(row::getCreateDate)
            .set(pickupDate).equalToWhenPresent(row::getPickupDate)
            .set(closeDate).equalToWhenPresent(row::getCloseDate)
            .set(itemACount).equalToWhenPresent(row::getItemACount)
            .set(itemBCount).equalToWhenPresent(row::getItemBCount)
            .set(itemCCount).equalToWhenPresent(row::getItemCCount)
            .set(itemDCount).equalToWhenPresent(row::getItemDCount)
            .set(temperature).equalToWhenPresent(row::getTemperature)
            .set(applyMemo).equalToWhenPresent(row::getApplyMemo)
            .set(itemECount).equalToWhenPresent(row::getItemECount)
            .set(itemFCount).equalToWhenPresent(row::getItemFCount)
            .where(transactionId, isEqualTo(row::getTransactionId))
        );
    }
}