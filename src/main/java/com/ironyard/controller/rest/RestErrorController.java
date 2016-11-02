package com.ironyard.controller.rest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jasonskipper on 11/1/16.
 */
@Controller
public class RestErrorController  {

    private static final String PATH = "*";

    @RequestMapping(value = PATH)
    public String error() {
        return "/mvn/open/login.jsp";
    }

  
}
