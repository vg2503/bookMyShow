package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.*;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public SignUpResponseDto signUpUser(SignUpRequestDto requestDto){
        SignUpResponseDto responseDto = new SignUpResponseDto();
        try{
            User user = userService.signUpUser(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
            responseDto.setUserId(user.getId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            responseDto.setResponseStatus(ResponseStatus.ERROR);
        }
        return responseDto;
    }

    public LogInResponseDto logInUser(LogInRequestDto requestDto){
        LogInResponseDto responseDto = new LogInResponseDto();
        try{
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            User user = userService.loginUser(requestDto.getEmail(), requestDto.getPassword());
            responseDto.setUser(user);
        }
        catch(Exception e){
            responseDto.setResponseStatus(ResponseStatus.ERROR);
        }
        return responseDto;
    }
}
