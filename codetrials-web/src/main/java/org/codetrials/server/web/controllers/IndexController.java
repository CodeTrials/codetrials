package org.codetrials.server.web.controllers;

import com.google.gson.Gson;
import org.codetrials.server.service.TrialService;
import org.codetrials.server.service.dao.BundleDAO;
import org.codetrials.shared.LayoutConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author Nikita Zyulyaev
 */
@Controller
public class IndexController {
    @Autowired
    TrialService service;

    @Autowired
    BundleDAO bundleDAOService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index", "trials", new Gson().toJson(service.getTrials()));
    }

    @RequestMapping(value = LayoutConstants.BUNDLE_UPLOAD_FORM_URL, method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam(LayoutConstants.BUNDLE_UPLOAD_FORM_TITLE) String title,
                         @RequestParam(LayoutConstants.BUNDLE_UPLOAD_FORM_BUNDLE) MultipartFile file) {
        try {
            int id = bundleDAOService.addBundle(title, file.getBytes());
            if (id == -1) {
                return "Bad bundle";
            } else {
                return "Bundle uploaded successfully";
            }
        } catch (IOException e) {
            return "Failed to upload";
        }
    }
}
