package com.ironyard.controller.mvc;

import com.ironyard.data.IronUser;
import com.ironyard.data.Movie;
import com.ironyard.repo.IronUserRepository;
import com.ironyard.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jasonskipper on 11/2/16.
 */
@Controller
@RequestMapping(path = "/mvc/secure/user")
public class MvcIronUserController {

    @Autowired
    IronUserRepository userRepository = null;

    @Autowired
    MovieRepository movieRepository = null;

    @RequestMapping(value = "favs/delete", method = RequestMethod.GET)
    public String deleteFavorite(@RequestParam("id") Long id, HttpServletRequest request){
        // get current logged in user, need to case (IronUser) to proper type
        IronUser user = (IronUser)request.getSession().getAttribute("user");

        // refetch user from db
        IronUser fetchedUser = userRepository.findOne(user.getId());

        // find this movie id in user favorites and remove it
        Movie movieToRemove = null;
        for(Movie tmp: fetchedUser.getFavs()){
            if(tmp.getId() == id){
                // this is the movie to remove
                movieToRemove = tmp;
            }
        }

        if(movieToRemove != null) {
            fetchedUser.getFavs().remove(movieToRemove);
        }
        userRepository.save(fetchedUser);
        // send them to the home page
        return "redirect:/mvc/secure/movie/favs";
    }

    @RequestMapping(value = "favs/add", method = RequestMethod.GET)
    public String addFavorite(@RequestParam("id") Long id, HttpServletRequest request){
        // get current logged in user, need to case (IronUser) to proper type
        IronUser user = (IronUser)request.getSession().getAttribute("user");

        // refetch user from db
        IronUser fetchedUser = userRepository.findOne(user.getId());

        Movie movieToAddToFavs = movieRepository.findOne(id);

        if(fetchedUser.getFavs() == null){
            fetchedUser.setFavs(new HashSet<>());
        }
        fetchedUser.getFavs().add(movieToAddToFavs);

        userRepository.save(fetchedUser);
        // send them to the home page
        return "redirect:/mvc/secure/movie/all";
    }
}
