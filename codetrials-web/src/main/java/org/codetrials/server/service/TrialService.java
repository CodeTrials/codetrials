package org.codetrials.server.service;

import org.codetrials.bundle.BundleContainer;
import org.codetrials.server.exceptions.InvalidBundleException;
import org.codetrials.server.service.dao.BundleDAO;
import org.codetrials.server.service.dao.BundleJdbcDao;
import org.codetrials.shared.entities.BundleDescription;
import org.codetrials.shared.entities.Trial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Polyarnyi Nikolay
 */
@Service
public class TrialService {

    @Autowired
    BundleLoader bundleLoader;

    @Autowired
    BundleDAO bundleDAO;

    public List<Trial> getTrials() {
        List<BundleDescription> descriptions = bundleDAO.getAllBundlesDescriptions();
        List<Trial> trials = new ArrayList<>();
        try {
            for (BundleDescription description : descriptions) {
                BundleContainer bundleContainer = bundleLoader.createBundleContainer(new URL("file:" + BundleJdbcDao.BUNDLE_ROOT), description.getId());
                trials.add(new Trial(description.getId(), description.getTitle(), bundleContainer.getBundleDescription(),
                        bundleContainer.getTotalStepsCount()));
            }
        } catch (InvalidBundleException | MalformedURLException e) {
            throw new IllegalStateException(e);
        }
        return trials;
    }

}
