package org.example.bookmyshow.services;

import org.example.bookmyshow.exceptions.DuplicateUserException;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User signUpUser(String userName, String password, String email) throws DuplicateUserException {
        User user = new User();

        //check if user with same email id is not present
        List<User> users = userRepository.findUserByEmail(email);
        if(!users.isEmpty()){
            throw new DuplicateUserException("User with same email already exists");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        //set the users parameter
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setName(userName);

        //save the user
        //return the user
        return userRepository.save(user);

    }
}
