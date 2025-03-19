package org.example.bookmyshow.services;

import org.example.bookmyshow.exceptions.DuplicateUserException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User loginUser(String email, String password) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("No User Found");
        }
        User user = optionalUser.get();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(bCryptPasswordEncoder.matches(password, user.getPassword())){
            System.out.println("Logged in sucessfully");
            return user;
        }

        return null;
    }
}
