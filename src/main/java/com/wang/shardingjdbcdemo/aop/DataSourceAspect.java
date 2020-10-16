package com.wang.shardingjdbcdemo.aop;

import com.mysql.cj.log.LogFactory;
import com.wang.shardingjdbcdemo.support.DS;
import com.wang.shardingjdbcdemo.support.DynamicDataSource;
import groovy.util.logging.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 最先执行数据源切换，防止有@Transactional 等注解
 * @Author: meng
 * @Date: 2020-10-13 16:53
 */
@Component
@Order(-1)
@Aspect
public class DataSourceAspect {

    static Logger log = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("@annotation(com.wang.shardingjdbcdemo.support.DS)")
    public void dataSourcePointCut() {};

    @Before("dataSourcePointCut()")
    public void switchDataSource(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DS ds = method.getAnnotation(DS.class);
        if(ds == null){
            DynamicDataSource.setCustomerType(DynamicDataSource.defaultDataSource);
        }else {
            log.error("dataSource:{} ",ds.name());
            DynamicDataSource.setCustomerType(ds.name());
        }
    }

    /**
     * 重置数据源
     * @param point
     */
    @After("dataSourcePointCut()")
    public void restoreDataSource(JoinPoint point) {
        // 将数据源置为默认数据源
        DynamicDataSource.clearCustomerType();
        log.error("clear datasource");
    }

}
