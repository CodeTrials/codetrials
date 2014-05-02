package org.codetrials.server.service.dao;

import com.google.inject.ImplementedBy;
import org.codetrials.shared.entities.BundleDescription;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author qwwdfsad
 */
public interface BundleDAO {

    public List<BundleDescription> getAllBundlesDescriptions();

    public int addBundle(String title, MultipartFile bundle);

    public int addBundle(String title, byte[] file);
}
