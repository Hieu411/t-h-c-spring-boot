package com.example.demo.mapper;


import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.dto.respone.UserRespone;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserRespone toUserRespone(User user);
    //map data tu UserUpdateRequest vao User
    void updateUser(@MappingTarget User user, UserUpdateRequest request );
}
