package com.ironyard.controller.mvc;

import com.ironyard.data.IronUser;
import com.ironyard.repo.IronUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by jasonskipper on 11/1/16.
 */
@Controller
@RequestMapping(path = "/mvc/open")
public class MvcLoginController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IronUserRepository userRepository;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "password", required = false) String password,
                       @RequestParam(value = "username", required = false) String username,
                       HttpServletRequest request) {
        log.info("Login attempt by:"+username);
        String destination = "open/login";
        IronUser found = userRepository.findByUsernameAndPassword(username, password);
        if(found != null){
            request.getSession().setAttribute("user",found);
            // on success we send them to the favs controller to fetch fav movies
            destination = "redirect:/mvc/secure/movie/favs";
            log.info("found user:"+found.getId());
        }
        log.info("Login attempt result:"+destination);
        return destination;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        String destination = "/open/login";
        IronUser found = (IronUser) request.getSession().getAttribute("user");
        if(found != null) {
            log.info("Logging out user with id:" + found.getId());
        }
        request.getSession().invalidate();
        return destination;
    }


}
