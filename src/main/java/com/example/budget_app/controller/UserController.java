package com.example.budget_app.controller;

import com.example.budget_app.dto.UserDto;
import com.example.budget_app.model.User;
import com.example.budget_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/budget")
public class UserController {


@Autowired
private UserService userService;

    @PostMapping("/addUsers")
    public ResponseEntity<String> addUsers(@RequestBody List<UserDto> userDTOList) {

            userService.addUsers(userDTOList);
            return ResponseEntity.ok("Users added successfully");
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }
}
