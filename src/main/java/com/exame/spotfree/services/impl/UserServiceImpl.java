package com.exame.spotfree.services.impl;

import com.exame.spotfree.models.User;
import com.exame.spotfree.repositorys.UserRepository;
import com.exame.spotfree.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User getOne(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(userRepository::delete);
    }

    public void deactivate(Long id){
        Optional<User> user = userRepository.findById(id);

        user.ifPresent(
            presentUser -> {
                presentUser.setStatus(false);

                userRepository.save(presentUser);
            }
        );
    }
}
