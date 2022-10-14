package com.zadanie2.demo.controller;

import com.zadanie2.demo.customExceptionsHandling.NoSuchUser;
import com.zadanie2.demo.entity.User;
import com.zadanie2.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/hello-world")         //Made for test
    public String helloWorld(){
        return "Hello World";
    }

//    @GetMapping("/")
//    public String greeting(){
//        return "greeting";
//    }
//
//    @GetMapping("/main")
//    public String mainPage(){
//        return "main-page";
//    }

    @GetMapping("/users")
    public List<User> showAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        User user = userService.getUser(id);
        if(user == null){
            throw new NoSuchUser("No such user with ID: " + id + " in DB");
        }
        return user;
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        User user = userService.getUser(id);
        if(user == null){
            throw new NoSuchUser("No such user with ID: " + id + " in DB");
        }
        userService.deleteUser(id);
        return "User with id " + id + " was deleted!";
    }

    @PutMapping("/users/{id}/disk_increase/{number}")
    public String updateUserDisk_Size(@PathVariable int id,@Max(value = 1000) @PathVariable int number){
        User user = userService.getUser(id);
        if(user == null){
            throw new NoSuchUser("No such user with ID: " + id + " in DB");
        }

        userService.disk_SizeIncrease(id,number);
        return "User disk_Size with id " + id +" was changed";
    }

    @PostMapping("/users/{id}/add_file/{text}")
    public String addFile(@PathVariable int id, @PathVariable String text){
        User user = userService.getUser(id);
        if(user == null){
            throw new NoSuchUser("No such user with ID: " + id + " in DB");
        }
        userService.addFile(id,text);
        return "User file with id " + id + " was updated";
    }

    @DeleteMapping("/users/remove_file/{id}")
    public String removeFile(@PathVariable int id){
        User user = userService.getUser(id);
        if(user == null){
            throw new NoSuchUser("No such user with ID: " + id + " in DB");
        }
        userService.removeFile(id);
        return "User file with id " + id + " was made empty";
    }


}
