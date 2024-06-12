package com.example.model;

import jakarta.annotation.Generated;

/**
 * Database Table Remarks:
 *   品項規格
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table specification
 */
public class Specification {
    /**
     * Database Column Remarks:
     *   品項代碼
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:12:59.8980404+08:00", comments="Source field: specification.id")
    private String id;

    /**
     * Database Column Remarks:
     *   名稱
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:08.0420055+08:00", comments="Source field: specification.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:08.0420055+08:00", comments="Source field: specification.price")
    private Integer price;

    /**
     * Database Column Remarks:
     *   說明
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:08.0430053+08:00", comments="Source field: specification.memo")
    private String memo;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:05.7609324+08:00", comments="Source field: specification.id")
    public String getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:05.7619234+08:00", comments="Source field: specification.id")
    public void setId(String id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:08.0420055+08:00", comments="Source field: specification.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:08.0420055+08:00", comments="Source field: specification.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:08.0420055+08:00", comments="Source field: specification.price")
    public Integer getPrice() {
        return price;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:08.0430053+08:00", comments="Source field: specification.price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:08.0430053+08:00", comments="Source field: specification.memo")
    public String getMemo() {
        return memo;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-12T18:13:08.0430053+08:00", comments="Source field: specification.memo")
    public void setMemo(String memo) {
        this.memo = memo;
    }
}