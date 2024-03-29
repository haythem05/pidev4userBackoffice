package com.example.pokerr.Controllers;

import com.example.pokerr.Entities.User;
import com.example.pokerr.Repositories.UserRepository;
import com.example.pokerr.Services.UserServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/api/auth")


public class UserController {

    @Autowired
    private UserServices userServices;



    @GetMapping("/ShowallUsers")
    public List<User> ShowAllUsers(){
        return  userServices.ShowAllUsers();
    }

    @GetMapping("/GetUserById/{userid}")
    public ResponseEntity<User> GetUserById(@PathVariable Long userid){
        return userServices.GetUserById(userid);
    }


    @PutMapping("/UpdateUser/{UserId}")
    public ResponseEntity<User> UpdateUser(@PathVariable Long UserId, @RequestBody User user){
        return  userServices.UpdateUser(UserId , user);
    }


    @DeleteMapping("/DeleteUser/{userId}")
    public void DeleteUser(@PathVariable Long userId){
        this.userServices.DeleteUser(userId);
    }


}
