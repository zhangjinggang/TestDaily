package com.zjg.dao.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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

    /**
     * 加载数据源配置
     */
    @Bean(name = "oneDatasourceProperties")
    @ConfigurationProperties("spring.datasource.one")
    public DataSourceProperties oneDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean(name = "twoDatasourceProperties")
    @ConfigurationProperties("spring.datasource.two")
    public DataSourceProperties twoDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 加载数据源
     */
    @Bean(name = "oneDataSource")
    HikariDataSource oneDataSource(@Qualifier("oneDatasourceProperties") DataSourceProperties oneDatasourceProperties) {
        return oneDatasourceProperties.initializeDataSourceBuilder()
            .type(HikariDataSource.class)
            .build();
    }
    /**
     * 加载数据源
     */
    @Bean(name = "twoDataSource")
    HikariDataSource twoDataSource(@Qualifier("twoDatasourceProperties") DataSourceProperties twoDatasourceProperties) {
        return twoDatasourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory oneSessionFactory(@Qualifier("oneDataSource") DataSource oneDataSource,
                                               @Qualifier("twoDataSource") DataSource twoDataSource) throws Exception {
        MybatisProperties properties = new MybatisProperties();
        properties.setMapperLocations(new String[] {"classpath*:mapper/*.xml"});

        Map<Object,Object> map = new HashMap<>();
        map.put("one",oneDataSource);
        map.put("two",twoDataSource);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(oneDataSource);
        dynamicDataSource.setTargetDataSources(map);

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(properties.resolveMapperLocations());

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        return bean.getObject();
    }


//    @Bean(name = Common.ACTIVITY_SESSION_FACTORY_TEMPLATE)
//    public SqlSessionTemplate activitySqlSessionTemplate(
//        @Qualifier(Common.ACTIVITY_SESSION_FACTORY) SqlSessionFactory activitySessionFactory)
//        throws Exception {
//        return new SqlSessionTemplate(activitySessionFactory);
//    }


}
