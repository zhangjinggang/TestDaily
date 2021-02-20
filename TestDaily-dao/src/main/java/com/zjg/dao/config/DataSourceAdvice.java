package com.zjg.dao.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(0)
public class DataSourceAdvice implements ApplicationContextAware {
    private Logger log = LoggerFactory.getLogger(DataSourceAdvice.class);

    private ApplicationContext applicationContext;


    @Around("@annotation(ds)")
    public Object execute(ProceedingJoinPoint joinPoint, DataSource ds) throws Throwable {
        try {
            String dataSourceName = ds.value();
            if (!"".equals(dataSourceName)) {
                if (applicationContext.containsBean(dataSourceName)) {
                    JdbcContextHolder.setJdbcType(dataSourceName);
                } else {
                }
            }
            return joinPoint.proceed();
        } finally {
            JdbcContextHolder.clearJdbcType();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
