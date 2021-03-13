package com.zjg.dao.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zjg
 * @description: 活动数据源配置
 * @date 2020/4/21 16:15
 */
@Configuration
@PropertySource("classpath:/dataSourceConfig.properties")
@MapperScan(basePackages = "com.zjg.**.mapper")
@Slf4j
public class DynamicDataSourceConfig {

    @Resource(name = "oneDataSource")
    DataSource oneDataSource;

    @Resource(name = "twoDataSource")
    DataSource twoDataSource;

    @Bean(name = "dynamicDataSource")
    DynamicDataSource dataSource() {
        Map<Object,Object> map = new HashMap<>();
        map.put("oneDataSource",oneDataSource);
        map.put("twoDataSource",twoDataSource);
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(oneDataSource);
        dynamicDataSource.setTargetDataSources(map);
        return dynamicDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory oneSessionFactory(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource) throws Exception {
        MybatisProperties properties = new MybatisProperties();
        properties.setMapperLocations(new String[] {"classpath*:mapper/*.xml"});

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(properties.resolveMapperLocations());

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        return bean.getObject();
    }


    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate activitySqlSessionTemplate(
        @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(
            @Qualifier("dynamicDataSource") DataSource dynamicDataSource) throws Exception {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dynamicDataSource);
        return transactionManager;
    }


}
