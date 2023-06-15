package com.exame.spotfree.services;

import com.exame.spotfree.models.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User getOne(Long id);

    List<User> getAll();

    User update(User user);

    void delete(Long id);

    void deactivate(Long id);
}
