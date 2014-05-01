package org.codetrials.server.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Nikita Zyulyaev
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "<h1>Hello World!</h1>";
    }
}
