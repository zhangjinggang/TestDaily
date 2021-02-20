package com.zjg.dao.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
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

    @Bean(name = "twoDatasourceProperties")
    @ConfigurationProperties("spring.datasource.two")
    public DataSourceProperties oneDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "twoDataSource")
    javax.sql.DataSource oneDataSource(@Qualifier("twoDatasourceProperties") DataSourceProperties twoDatasourceProperties) {
        return twoDatasourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }
}
