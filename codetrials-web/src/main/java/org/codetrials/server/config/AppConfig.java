package org.codetrials.server.config;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.codetrials.server.service.BundleLoader;
import org.codetrials.server.service.dao.BundleDAO;
import org.codetrials.server.service.dao.BundleJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author Polyarnyi Nikolay
 */
@Configuration
@ComponentScan("com.codetrials.server")
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
        try {
            addJavaScriptTutorial(bd);
            addPythonSandbox(bd);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return bd;
    }

    private void addJavaScriptTutorial(BundleDAO bd) throws IOException {
        URL url = getClass().getClassLoader().getResource("javascriptBundle.jar");

        if (url == null) {
            throw new IllegalStateException("Default bundle not found!");
        }

        File file = new File(url.getFile());
        byte[] fileBytes = IOUtils.toByteArray(new FileInputStream(file));
        bd.addBundle("JavaScript", fileBytes);
    }

    private void addPythonSandbox(BundleDAO bd) throws IOException {
        URL url = getClass().getClassLoader().getResource("pythonSandboxBundle.jar");

        if (url == null) {
            throw new IllegalStateException("Default bundle not found!");
        }

        File file = new File(url.getFile());
        byte[] fileBytes = IOUtils.toByteArray(new FileInputStream(file));
        bd.addBundle("Python", fileBytes);
    }
}