package org.codetrials.server.service.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author qwwdfsad
 */
public class BundleDescriptionMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BundleDescription(rs.getInt("id"), rs.getString("title"), rs.getString("path"));
    }
}