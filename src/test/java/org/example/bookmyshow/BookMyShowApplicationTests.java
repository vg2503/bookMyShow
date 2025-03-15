package org.example.bookmyshow;

import org.example.bookmyshow.controllers.UserController;
import org.example.bookmyshow.dtos.SignUpRequestDto;
import org.example.bookmyshow.dtos.SignUpResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookMyShowApplicationTests {
    @Autowired
    private UserController userController;
//    @Test
//    void contextLoads() {
//    }
    @Test
    public void sampleTest() {
        SignUpRequestDto requestDto = new SignUpRequestDto();
        requestDto.setName("John Doe");
        requestDto.setEmail("john.doe@example.com");
        requestDto.setPassword("password");
        SignUpResponseDto response = userController.signUpUser(requestDto);
        System.out.println(response.getUserId());

    }

}
