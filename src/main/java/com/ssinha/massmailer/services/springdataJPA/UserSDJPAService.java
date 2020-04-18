package com.ssinha.massmailer.services.springdataJPA;

import java.util.HashSet;
import java.util.Set;

import com.ssinha.massmailer.models.User;
import com.ssinha.massmailer.repositries.UserRepository;
import com.ssinha.massmailer.services.UserService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value = "default")
public class UserSDJPAService implements UserService {

    private final UserRepository userRepository;

    public UserSDJPAService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(User -> users.add(User));
        return users;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}