package org.codetrials.server.service.dao;

import org.springframework.web.multipart.MultipartFile;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

/**
 * @author qwwdfsad
 */
public class MySqlBundleDAO implements BundleDAO {

    private Connection connection = null;

    public MySqlBundleDAO() throws Exception {
        Properties cp = getConnectionProperties();
        connection = DriverManager.getConnection("jdbc:mysql://localhost/codeTrialsDB", cp);
    }

    private Properties getConnectionProperties() {
        Properties connectionProp = new Properties();
        connectionProp.put("characterEncoding","UTF8");
        connectionProp.put("user", "codeTrials");
        connectionProp.put("password", "12345");
        return connectionProp;
    }

    @Override
    public List<BundleDescription> getAllBundlesDescriptions() {
        throw new NotImplementedException();
    }

    @Override
    public int addBundle(String title, MultipartFile bundle) {
        throw new NotImplementedException();
    }
}
