package org.codetrials.server.service.dao;

import static org.junit.Assert.*;

import org.codetrials.shared.entities.BundleDescription;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

public class BundleJdbcDaoTest {

    DataSource getDriverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
        dataSource.setUrl("jdbc:derby:testDerbyDB;create=true");
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }

    @Test
    public void basicTest() {
        final String bundleName = "js bundle";
        DataSource ds = getDriverManagerDataSource();
        BundleDAO bDAO = new BundleJdbcDao(ds);
        bDAO.addBundle(bundleName, null);
        List<BundleDescription> list = bDAO.getAllBundlesDescriptions();
        assertEquals(list.size(), 1);
        assertEquals(bundleName, list.get(0).getTitle());
    }
}