package org.codetrials.server.service;

import org.codetrials.server.service.dao.BundleDAO;
import org.codetrials.shared.entities.BundleDescription;
import org.codetrials.shared.entities.Trial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Polyarnyi Nikolay
 */
@Service
public class TrialService {

    @Autowired
    BundleDAO bundleDAO;

    public List<Trial> getTrials() {
        List<BundleDescription> descriptions = bundleDAO.getAllBundlesDescriptions();
        List<Trial> trials = new ArrayList<>();
        for (BundleDescription description : descriptions) {
            trials.add(new Trial(description.getId(), description.getTitle(), description.getDescription()));
        }
        return trials;
    }

}
