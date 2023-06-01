package com.fsb.searchfiltre.Controller;

import com.fsb.searchfiltre.Entity.User;
import com.fsb.searchfiltre.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/search")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getall() throws IOException {
        try{
            return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("User not Found", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("user/{id}")
    public ResponseEntity<User> getbyid(@PathVariable long id) throws IOException {
        try{
            return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("User not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("user/getuser")
    public ResponseEntity<List<User>> getbyid(@RequestParam("firstname") String firstname, @RequestParam("secondname") String secondname) throws IOException {
        try{
            return new ResponseEntity<>(userService.getByUsername(firstname,secondname), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("User not Found", HttpStatus.NOT_FOUND);
        }
    }
//    @GetMapping("user/getdescription/{description}")
//    public ResponseEntity<Iterable<User>> getbydescription(@PathVariable String description) throws IOException {
//        try{
//            return new ResponseEntity<>(userService.performFuzzySearch(description), HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity("User not Found", HttpStatus.NOT_FOUND);
//        }
//    }

}
