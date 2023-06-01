package com.fsb.searchfiltre.Service;

import com.fsb.searchfiltre.Entity.User;
import com.fsb.searchfiltre.Repository.UserRepository;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImp implements UserService{

    private final LevenshteinDistance levenshteinDistance;

    public UserServiceImp(){
        this.levenshteinDistance = new LevenshteinDistance();
    }
    @Autowired
    UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getByUsername(String firstname,String secondname) {
        List<User> alluser = (List<User>) userRepository.findAll();
        Map<User, Integer> similarityMap = new HashMap<>();
        String username=firstname+" "+secondname;
        for (User user : alluser) {
            int firstnameSimilarity = levenshteinDistance.apply(username, user.getFirstname()+" "+user.getSecondname());
            int secondnameSimilarity = levenshteinDistance.apply(username, user.getSecondname()+" "+user.getFirstname());

            int totalSimilarity = firstnameSimilarity + secondnameSimilarity;
            System.out.println(user+" "+totalSimilarity);
            System.out.println("_________________________________");
            similarityMap.put(user, totalSimilarity);
        }

        List<User> fuzzyResults = new ArrayList<>(similarityMap.keySet());
        fuzzyResults.sort(Comparator.comparingInt(similarityMap::get));

        return fuzzyResults;
    }
//    public List<User> getByUsername(String username) {
//        List<User> alluser = (List<User>) userRepository.findAll();
//        Map<User, Integer> similarityMap = new HashMap<>();
//
//        for (User user : alluser) {
//            int similarity = levenshteinDistance.apply(username, user.getUsername());
//            similarityMap.put(user, similarity);
//        }
//
//        List<User> fuzzyResults = new ArrayList<>(similarityMap.keySet());
//        fuzzyResults.sort(Comparator.comparingInt(similarityMap::get));
//
//        return fuzzyResults;
//    }




}
