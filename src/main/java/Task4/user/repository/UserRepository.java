package Task4.user.repository;

import Task4.user.domain.User;

import java.util.Optional;


import java.util.List;

public interface UserRepository {

    void save(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findById(String id);

    void update(User user);

    List<User> findAll();
}