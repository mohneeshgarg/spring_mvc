package com.group4.twitter.Services;

import com.group4.twitter.DAO.UserDAO;
import com.group4.twitter.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserDAO userDAO;

    public String addUser(User user){
        user.setRole("User");
        userDAO.save(user);
        return "User with email " + user.getUsername() + " has been added successfully!";
    }
    public List<User> findAllUsers(){
        List<User> allUsers = userDAO.findAll();
        return allUsers;
    }
    public User findUser(int id){
        return userDAO.findById(id).get();
    }
    public String updateUser(User user){
        userDAO.save(user);
        return "User updated successfully!";
    }
    public String deleteUser(int id){
        User user = userDAO.findById(id).get();
        userDAO.delete(user);
        return "User deleted successfully!";
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("Not Found");
        }
        return user;
    }
}
