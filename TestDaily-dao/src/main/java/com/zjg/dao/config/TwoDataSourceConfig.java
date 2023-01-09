package com.zjg.dao.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zjg
 * @description:
 * @date 2021/2/20 16:30
 */
@Configuration
public class TwoDataSourceConfig {
    /**
     * 加载数据源
     */
//
//    @Bean(name = "twoDatasourceProperties")
//    @ConfigurationProperties("spring.datasource.two")
//    public DataSourceProperties oneDataSourceProperties() {
//        return new DataSourceProperties();
//    }

    @Bean(name = "twoDataSource")
    HikariDataSource oneDataSource() {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl("jdbc:mysql://localhost:3306/choicex?useUnicode=true&characterEncoding=utf-8&rewriteBatchedStatements=true&serverTimezone=Asia/Shanghai");
        dataSourceProperties.setPassword("55555");
        dataSourceProperties.setUsername("root");
        dataSourceProperties.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }
}
