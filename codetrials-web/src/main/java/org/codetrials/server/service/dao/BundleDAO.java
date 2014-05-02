package org.codetrials.server.service.dao;

import org.codetrials.server.service.entities.BundleDescription;

import java.util.List;

/**
 * @author Polyarnyi Nikolay
 */
public interface BundleDAO {

    public List<BundleDescription> getAllBundles();

    public BundleDescription getBundleById(int id);

    public BundleDescription storeBundle(String title, String description);

}
