package com.ironyard.repo;

import com.ironyard.Application;
import com.ironyard.data.IronUser;
import com.ironyard.data.Movie;
import com.ironyard.data.Permission;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by jasonskipper on 10/31/16.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IronUserRepositoryTest {

    @Autowired
    private PermissionRepository permRepo;

    @Autowired
    private MovieRepository movieRepo;

    @Autowired
    private IronUserRepository userRepo;


    @Test
    public void testUserDeleteShouldNotDeleteMovieOrPerm() throws Exception{
        // create movie
        Movie savedMovie = movieRepo.save(new Movie("Matrix", "R", "http://url", "Awesome Movie", 209));

        // create permission
        Permission savedPermission = permRepo.save(new Permission("VIEW_RATED_R", "Ability to view movies with an R or below rating."));

        // create user
        IronUser tstUser = new IronUser("skipper", "pass", "Jason Skipper");
        tstUser.setFavs(new HashSet());
        tstUser.getFavs().add(savedMovie);

        tstUser.setAbilities(new HashSet());
        tstUser.getAbilities().add(savedPermission);

        userRepo.save(tstUser);

        // confirm all relationships
        IronUser fetchedUser = userRepo.findOne(tstUser.getId());

        assertEquals(savedPermission.getId(), fetchedUser.getAbilities().iterator().next().getId());
        assertEquals(savedMovie.getId(), fetchedUser.getFavs().iterator().next().getId());

        // we know saving works :D, save off related entity ids
        long movieId = fetchedUser.getFavs().iterator().next().getId();
        long permId = fetchedUser.getAbilities().iterator().next().getId();

        // lets test delete
        userRepo.delete(fetchedUser.getId());

        // movie should
        Assert.assertNotNull(movieRepo.findOne(movieId));
        Assert.assertNotNull(permRepo.findOne(permId));
    }

    @Test
    public void testFindByUsernameAndPass() throws Exception{

        // create user
        IronUser tstUser = new IronUser("skipper", "pass", "Jason Skipper");
        userRepo.save(tstUser);

       // find by user pass
        IronUser found = userRepo.findByUsernameAndPassword("skipper", "pass");
        Assert.assertNotNull(found);
    }

    @Test
    public void testRemoveMovieFromUserFav() throws Exception{
        Movie savedMovie = movieRepo.save(new Movie("Matrix", "R", "http://url", "Awesome Movie", 209));


        // create user
        IronUser tstUser = new IronUser("skipper", "pass", "Jason Skipper");
        tstUser.setFavs(new HashSet());
        tstUser.getFavs().add(savedMovie);
        userRepo.save(tstUser);

        // confirm all relationships
        IronUser fetchedUser = userRepo.findOne(tstUser.getId());
        Assert.assertTrue(!fetchedUser.getFavs().isEmpty());


        for(Movie fav: fetchedUser.getFavs()){
            if(fav.getId() == savedMovie.getId()){
                fetchedUser.getFavs().remove(fav);
            }
        }
        userRepo.save(fetchedUser);

        // movie should
        fetchedUser = userRepo.findOne(tstUser.getId());

        Assert.assertTrue(fetchedUser.getFavs().isEmpty());

    }

}