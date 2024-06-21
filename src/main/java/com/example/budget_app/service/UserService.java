package com.example.budget_app.service;

import com.example.budget_app.dto.UserDto;
import com.example.budget_app.model.User;
import com.example.budget_app.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addUsers(List<UserDto> userDTOList) {
        List<User> userList = userDTOList.stream()
                .map(userDTO -> {
                    User user = new User();
                    user.setName(userDTO.getName());
                    user.setPassword(userDTO.getPassword());
                    return user;
                })
                .collect(Collectors.toList());

        userRepository.saveAll(userList);
    }

    public List<User> getUsers() {
       return userRepository.findAll();
    }
}
