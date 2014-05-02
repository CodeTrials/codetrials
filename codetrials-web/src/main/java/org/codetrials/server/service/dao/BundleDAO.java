package org.codetrials.server.service.dao;

import org.codetrials.server.service.entities.BundleDescription;

import java.util.List;

/**
 * @author qwwdfsad
 */
public interface BundleDAO {

    public List<BundleDescription> getAllBundlesDescriptions();

    public int addBundle(BundleDescription bd, String pathToJar);

}
