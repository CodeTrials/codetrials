package org.codetrials.server.config;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.codetrials.server.service.BundleLoader;
import org.codetrials.server.service.dao.BundleDAO;
import org.codetrials.server.service.dao.BundleJdbcDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.net.URL;

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
        try {
            URL url = getClass().getClassLoader().getResource("javascriptBundle.jar");

            if (url == null) {
                throw new IllegalStateException("Default bundle not found!");
            }

            File file = new File(url.getFile());
            DiskFileItem fileItem = new DiskFileItem("file", "text/plain", false, file.getName(), (int) file.length(), file.getParentFile());
            fileItem.getOutputStream();
            MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
            bd.addBundle("JavaScript", multipartFile);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return bd;
    }
}