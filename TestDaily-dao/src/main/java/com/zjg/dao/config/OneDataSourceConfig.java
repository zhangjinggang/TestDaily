package com.zjg.dao.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author zjg
 * @description:
 * @date 2021/2/20 16:30
 */
@Configuration
public class OneDataSourceConfig {
    /**
     * 加载数据源
     */
    @Primary
    @Bean(name = "oneDatasourceProperties")
    @ConfigurationProperties("spring.datasource.one")
    public DataSourceProperties oneDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "oneDataSource")
    javax.sql.DataSource oneDataSource(@Qualifier("oneDatasourceProperties") DataSourceProperties oneDatasourceProperties) {
        return oneDatasourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }
}
