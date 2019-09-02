package com.example.bookstore.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return (List<User>) this.userRepo.findAll();
    }

    public User getAnUser(int userId) {
        return this.userRepo.findById(userId).get();
    }

    public User createUser(User user) {
        return this.userRepo.save(user);
    }

    public User updateUser(User user, int userId) {
        user.setId(userId);
        return this.userRepo.save(user);
    }

    public User deleteUser(int userId) {
        User user = this.getAnUser(userId);
        this.userRepo.delete(user);
        return user;
    }
}
