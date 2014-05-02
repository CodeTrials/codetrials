package org.codetrials.server.service.dao;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

public class BundleJdbcDaoTest extends TestCase {

    DataSource getDriverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/codeTrialsDB");
        dataSource.setUsername("codeTrials");
        dataSource.setPassword("12345");
        return dataSource;
    }

    @Test
    public void test() {
        DataSource ds = getDriverManagerDataSource();
        BundleDAO bDAO = new BundleJdbcDao(ds);
        List<BundleDescription> list = bDAO.getAllBundlesDescriptions();
    }
}