package org.codetrials.server.service.dao;

import org.codetrials.shared.entities.BundleDescription;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author qwwdfsad
 */
public interface BundleDAO {

    public List<BundleDescription> getAllBundlesDescriptions();

    public BundleDescription getBundleById(int id);

    public int addBundle(String title, MultipartFile bundle);

    public int addBundle(String title, byte[] file);
}
