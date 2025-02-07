package com.example.demo.controller;

import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    //Dependency Injection (DI) – Tiêm phụ thuộc.
    @Autowired
    private UserService userService;

    //dữ liệu gửi đi từ fe (json) -> cần chuyển qua object để xử lý
    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest request)
    {
        return userService.createUser(request); //từ obeject tự chuyển về json theo cơ chế của spring boot
    }

    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")//truyền vào userId ở fe (ví dụ localhost:8080/user/123
    User getUser( @PathVariable ("userId") String userId){ // tự lấy userId (123) kia và gán vào userId (string)
        return userService.getUser(userId); //truyền userId vào method đeer xử lý và tự chuyển thành Json để trả cho client
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request)
    {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId)
    {
        userService.deleteUser(userId);
        return "user deleted";
    }


}
