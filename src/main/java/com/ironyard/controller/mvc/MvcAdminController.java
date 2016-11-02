package com.ironyard.controller.mvc;

import com.ironyard.data.IronUser;
import com.ironyard.repo.IronUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * Created by jasonskipper on 11/2/16.
 */
@Controller
@RequestMapping(path = "/mvc/secure/admin")
public class MvcAdminController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IronUserRepository userRepository;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String list(Model model) {
        String destination = "/secure/admin_user";
        Iterable<IronUser> users = userRepository.findAll();
        model.addAttribute("users",users);
        return destination;
    }
    @RequestMapping(value = "user/create", method = RequestMethod.POST)
    public String ceateUser(@RequestParam("username") String username,
                       @RequestParam("displayname") String displayname,
                       @RequestParam("password") String password,
                       @RequestParam("password2") String password2,
                       Model model) {

        String destination = "redirect:/mvc/secure/admin/users";
        // check password match?
        if(!password.equals(password2)){
            // handle error?
            model.addAttribute("error_message", "Passwords do not match!");
            Iterable<IronUser> users = userRepository.findAll();
            model.addAttribute("users",users);
            destination = "/secure/admin_user";
            // keep a couple fields to be nice to user
            model.addAttribute("username", username);
            model.addAttribute("displayname", displayname);

        }else{
            // create user
            IronUser myNewUser = new IronUser();
            myNewUser.setUsername(username);
            myNewUser.setDisplayName(displayname);
            myNewUser.setPassword(password);
            userRepository.save(myNewUser);
        }

        return destination;
    }
}
