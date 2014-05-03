package org.codetrials.server.service.dao;

import org.codetrials.shared.entities.BundleDescription;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author qwwdfsad
 */
public class BundleDescriptionMapper implements RowMapper<BundleDescription> {

    public BundleDescription mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BundleDescription(rs.getInt("id"), rs.getString("title"), rs.getString("path"), rs.getString("description"),
                rs.getInt("taskCount"));
    }
}
