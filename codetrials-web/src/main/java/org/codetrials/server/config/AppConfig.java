package org.codetrials.server.config;

import org.codetrials.server.service.BundleLoader;
import org.codetrials.server.service.dao.BundleDAO;
import org.codetrials.server.service.dao.BundleJdbcDao;
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
    BundleLoader getBundleLoader() {
        return new BundleLoader();
    }

    @Bean
    DataSource getDriverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
        dataSource.setUrl("jdbc:derby:testDerbyDB;create=true");
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    BundleDAO getBundleDao(DataSource ds, BundleLoader bl) {
        BundleDAO bd = new BundleJdbcDao(ds, bl);
        return bd;
    }
}