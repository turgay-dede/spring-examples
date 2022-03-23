package com.turgaydede.services;

import com.turgaydede.entities.User;
import com.turgaydede.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean saveUser(User user) {
        userRepository.saveUser(user);
        return true;
    }

    @Override
    public List<User> fetchAllUser() {
        return userRepository.fetchAllUser();
    }

    @Override
    public User fetchUserById(Long id) {
        return userRepository.fetchUserById(id);
    }

    @Override
    public boolean deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(Long id, User user) {
        return userRepository.updateUser(id,user);
    }
}
