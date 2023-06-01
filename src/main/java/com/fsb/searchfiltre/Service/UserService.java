package com.fsb.searchfiltre.Service;

import com.fsb.searchfiltre.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {
    User addUser(User user);
    List<User> getAll();
    User getById(long id);
    List<User> getByUsername(String firstname,String secondname);
    // Iterable<User> performFuzzySearch(String searchTerm) ;
    }
