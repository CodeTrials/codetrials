package org.codetrials.server.service.dao;

import org.springframework.web.multipart.MultipartFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author qwwdfsad
 */
public class MySqlBundleDAO implements BundleDAO {

    static private final String DB_NAME = "codeTrialsDB";
    static private final String TABLE_NAME = "bundleInfo";

    private final Connection connection;

    public MySqlBundleDAO() throws Exception {
        Properties cp = getConnectionProperties();
        connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME, cp);

    }

    private Properties getConnectionProperties() {
        Properties connectionProp = new Properties();
        connectionProp.put("characterEncoding", "UTF8");
        connectionProp.put("user", "codeTrials");
        connectionProp.put("password", "12345");
        return connectionProp;
    }

    @Override
    public List<BundleDescription> getAllBundlesDescriptions() {
        try {
            String query = "SELECT * FROM " + TABLE_NAME;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            List<BundleDescription> result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String path = rs.getString("path");
                result.add(new BundleDescription(id, title, path));
            }
            return result;
        }
        catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public int addBundle(String title, MultipartFile bundle) {
        try {
            Statement st = connection.createStatement();
            String query = "INSERT INTO " + TABLE_NAME + " (title, path)" +
                    " VALUES " + "( "
                    + "\"" + title + "\"," + "\"pathname\"" +
                    ");";
            connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.executeUpdate(query);
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        }
        catch (Exception e) {
            return -1;
        }
    }
}
