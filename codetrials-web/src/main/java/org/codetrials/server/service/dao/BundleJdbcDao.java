package org.codetrials.server.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BundleDescription> getAllBundlesDescriptions() {
        final String query = "SELECT * FROM bundleinfo";
        return jdbcTemplate.query(query, new BundleDescriptionMapper());
    }

    @Override
    public int addBundle(final String title, MultipartFile bundle) {
        // Some multipart file preprocessing
        final String query = "insert into bundleinfo (title, path) values (?, ?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
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
