package com.wang.shardingjdbcdemo.support;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源切换
 * @Author: meng
 * @Date: 2020-10-13 16:49
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    public static final String  defaultDataSource= "defaultDataSource";
    public static final String  shardingDataSource= "shardingDataSource";
    //本地线程，获取当前正在执行的currentThread
    public static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();


    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }


    public static String getCustomerType() {
        return contextHolder.get();
    }
    public static void clearCustomerType() {
        contextHolder.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getCustomerType();
    }
}
