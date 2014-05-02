package org.codetrials.server.web.controllers;

import com.google.gson.Gson;
import org.codetrials.server.service.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Nikita Zyulyaev
 */
@Controller
public class IndexController {
    @Autowired
    TrialService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index", "trials", new Gson().toJson(service.getTrials()));
    }
}
