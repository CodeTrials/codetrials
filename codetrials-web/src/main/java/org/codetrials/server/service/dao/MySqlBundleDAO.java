package org.codetrials.server.service.dao;

import org.codetrials.server.service.entities.BundleDescription;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * @author qwwdfsad
 */
public class MySqlBundleDAO implements BundleDAO {
    @Override
    public List<BundleDescription> getAllBundlesDescriptions() {
        throw new NotImplementedException();
    }

    @Override
    public int addBundle(BundleDescription bd, String pathToJar) {
        throw new NotImplementedException();
    }
}
