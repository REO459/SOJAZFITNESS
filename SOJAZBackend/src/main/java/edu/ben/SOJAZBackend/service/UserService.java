package edu.ben.SOJAZBackend.service;

import edu.ben.SOJAZBackend.Exception.IncorrectPasswordException;
import edu.ben.SOJAZBackend.Exception.NotFoundException;
import edu.ben.SOJAZBackend.model.Food;
import edu.ben.SOJAZBackend.model.dto.userDTO;
import edu.ben.SOJAZBackend.model.user;
import edu.ben.SOJAZBackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    //userDTO loggedInUser;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public userDTO login(String username, String password) {
//        user user = userRepository.findByUsername(username);
//        System.out.println(user);
//        if (user == null) {
//            throw new NotFoundException();
//        } else if (!user.getPassword().equals(password)) {
//            throw new IncorrectPasswordException();
//        } else {
//            loggedInUser = new userDTO(user.getId(), user.getEmail(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getPassword());
//            System.out.println("Get logged1 = " + loggedInUser);
//            return new userDTO(user.getId(), user.getEmail(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getPassword());
//        }
//    }
    public void register(userDTO userDTO){
        userRepository.save(new user(userDTO.getEmail(),userDTO.getUsername(),userDTO.getFirstName(),userDTO.getLastName(),userDTO.getPassword()));
    }

    public userDTO getLoggedInUser(String username) {
        user user = userRepository.findByUsername(username).get();
        return new userDTO(user.getId(), user.getEmail(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getRoles());
    }

//    public userDTO getLoggedInUser() {
//        System.out.println(loggedInUser);
//
//        return loggedInUser;
//    }

    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    public user getUserById(Long user_id) {return userRepository.findById(user_id).get();}

    public user getUserByEmail(String email) {return userRepository.getByEmail(email);}

    public user addUser(user user) {return userRepository.save(user);}

    public user updateUser(Long user_id, user user) {
        user.setId(user_id);
        return userRepository.save(user);
    }

    public void deleteUser(Long user_id) {userRepository.deleteById(user_id);}
}
