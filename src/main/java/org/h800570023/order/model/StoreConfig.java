package org.h800570023.order.model;

import jakarta.annotation.Generated;

/**
 * Database Table Remarks:
 *   店家設定檔案
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table store_config
 */
public class StoreConfig {
    /**
     * Database Column Remarks:
     *   地址
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.432518+08:00", comments="Source field: store_config.address")
    private String address;

    /**
     * Database Column Remarks:
     *   電話
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.433427+08:00", comments="Source field: store_config.tel")
    private String tel;

    /**
     * Database Column Remarks:
     *   是否開放訂購
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.433545+08:00", comments="Source field: store_config.is_open_order")
    private String isOpenOrder;

    /**
     * Database Column Remarks:
     *   網站url
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.43363+08:00", comments="Source field: store_config.url")
    private String url;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.43322+08:00", comments="Source field: store_config.address")
    public String getAddress() {
        return address;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.433384+08:00", comments="Source field: store_config.address")
    public void setAddress(String address) {
        this.address = address;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.43347+08:00", comments="Source field: store_config.tel")
    public String getTel() {
        return tel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.433518+08:00", comments="Source field: store_config.tel")
    public void setTel(String tel) {
        this.tel = tel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.433576+08:00", comments="Source field: store_config.is_open_order")
    public String getIsOpenOrder() {
        return isOpenOrder;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.433607+08:00", comments="Source field: store_config.is_open_order")
    public void setIsOpenOrder(String isOpenOrder) {
        this.isOpenOrder = isOpenOrder;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.43366+08:00", comments="Source field: store_config.url")
    public String getUrl() {
        return url;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-06-18T15:18:07.433693+08:00", comments="Source field: store_config.url")
    public void setUrl(String url) {
        this.url = url;
    }
}