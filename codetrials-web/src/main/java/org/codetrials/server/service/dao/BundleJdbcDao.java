package org.codetrials.server.service.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author qwwdfsad
 */

@Repository
public class BundleJdbcDao implements BundleDAO {

    public BundleJdbcDao(DataSource dataSource) {
        this.dataSource = dataSource;
        initialize();
    }

    private void initialize() {
        final String query = "CREATE TABLE bundleinfo " +
                "(id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
                "title VARCHAR(50), " +
                "path VARCHAR(50))";
        JdbcTemplate template = new JdbcTemplate(dataSource);

        try {
            template.execute("DROP TABLE bundleinfo");
        }
        catch (Exception e) {

        }
        finally {
            template.execute(query);
        }
    }


    private final DataSource dataSource;

    @Override
    public List<BundleDescription> getAllBundlesDescriptions() {
        final String query = "SELECT * FROM bundleinfo";
        return new JdbcTemplate(dataSource).query(query, new BundleDescriptionMapper());
    }

    @Override
    public int addBundle(final String title, MultipartFile bundle) {
        // Some multipart file preprocessing
        final String query = "insert into bundleinfo (title, path) values (?, ?)";
        KeyHolder holder = new GeneratedKeyHolder();
        new JdbcTemplate(dataSource).update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, title);
                ps.setString(2, "temporary");
                return ps;
            }
        }, holder);
        return holder.getKey().intValue();
    }
}
