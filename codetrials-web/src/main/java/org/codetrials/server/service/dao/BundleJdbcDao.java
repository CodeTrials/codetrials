package org.codetrials.server.service.dao;

import org.apache.commons.io.IOUtils;
import org.codetrials.server.service.BundleLoader;
import org.codetrials.shared.entities.BundleDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import javax.sql.DataSource;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author qwwdfsad
 */


public class BundleJdbcDao implements BundleDAO {

    private static final String BUNDLE_ROOT = "resources/bundles";

    private final DataSource dataSource;
    private final BundleLoader validator;

    @Autowired
    public BundleJdbcDao(DataSource dataSource, BundleLoader loader) {
        this.dataSource = dataSource;
        this.validator = loader;
        initialize();
    }

    private void initialize() {
        final String query = "CREATE TABLE bundleinfo " +
                "(id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
                "title VARCHAR(50), " +
                "path VARCHAR(50)," +
                "description VARCHAR(100))";
        JdbcTemplate template = new JdbcTemplate(dataSource);

        try {
            template.execute("DROP TABLE bundleinfo");
        } catch (Exception e) {

        } finally {
            template.execute(query);
        }
    }

    @Override
    public List<BundleDescription> getAllBundlesDescriptions() {
        final String query = "SELECT * FROM bundleinfo";
        return new JdbcTemplate(dataSource).query(query, new BundleDescriptionMapper());
    }

    @Override
    public int addBundle(final String title, MultipartFile bundle) {

        if (!validator.validateContainer(bundle)) {
            return -1;
        }

        final String query = "insert into bundleinfo (title, path, description) values (?, ?, ?)";
        KeyHolder holder = new GeneratedKeyHolder();
        new JdbcTemplate(dataSource).update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, title);
                ps.setString(2, "path_t");
                ps.setString(3, "descr_t");
                return ps;
            }
        }, holder);
        int id = holder.getKey().intValue();
        try {
            String path = BUNDLE_ROOT + "/" + id;
            new File(path).mkdirs();
            String jarLocation = path;
            save(bundle.getBytes(), new File(jarLocation).getAbsolutePath());
            extractSlides(jarLocation);
        }
        catch (Exception e) {
            return -1;
        }

        return id;
    }

    private File save(byte[] bytes, String path) throws IOException {
        File f = new File(path);
        f.createNewFile();
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));) {
            bos.write(bytes);
            bos.flush();
        }
        return f;
    }

    private void extractSlides(String pathToJar) throws Exception {
        URL url = new URL("jar:file:/" + pathToJar + "/" + BundleLoader.BUNDLE_JAR_NAME + "!/" + BundleLoader.BUNDLE_TASK_FILENAME);
        InputStream is = url.openStream();
        byte[] bytes = IOUtils.toByteArray(is);
        save(bytes, pathToJar + "/" + BundleLoader.BUNDLE_TASK_FILENAME);
    }
}
