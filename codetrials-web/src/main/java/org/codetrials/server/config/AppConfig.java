package org.codetrials.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author Polyarnyi Nikolay
 */
@Configuration
@ComponentScan(basePackages = "com.codetrials.server")
public class AppConfig {

    @Bean
    DataSource getDriverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/codeTrialsDB");
        dataSource.setUsername("codeTrials");
        dataSource.setPassword("12345");
        return dataSource;
    }
}