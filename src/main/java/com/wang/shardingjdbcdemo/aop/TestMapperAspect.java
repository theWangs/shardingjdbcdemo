package com.wang.shardingjdbcdemo.aop;

import com.wang.shardingjdbcdemo.entity.User;
import org.apache.shardingsphere.api.hint.HintManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: meng
 * @Date: 2020-10-15 14:00
 */
@Component
@Aspect
public class TestMapperAspect {

    static Logger log = LoggerFactory.getLogger(TestMapperAspect.class);

    ThreadLocal<HintManager> hintManagerThreadLocal = new ThreadLocal<>();

    @Pointcut("execution(* com.wang.shardingjdbcdemo.mapper.TestMapper.*(..))")
    void testMapperPointcut() {};


    @Before("testMapperPointcut()")
    public void startSharding(JoinPoint point) {
        String name = point.getSignature().getName();
        Object args = point.getArgs()[0];
        if(args instanceof User){
            User user = (User) args;
            log.error("before method:{}", name);
            HintManager instance = null;
            switch (name) {
                case "insertUser":
                    instance = HintManager.getInstance();
                    instance.addTableShardingValue("user", user.getCreateTime());
                    break;
                default:
            }
            if(instance != null){
                hintManagerThreadLocal.set(instance);
                log.error("before hintManager start");
            }
        }

    }

    @After("testMapperPointcut()")
    public void endSharding(JoinPoint point) {
        String name = point.getSignature().getName();
        HintManager hintManager = hintManagerThreadLocal.get();
        if (hintManager != null) {
            log.error("after hintManager close");
            hintManager.close();
        }
        log.error("method:{}, instance:{}", name, hintManager);
    }
}
