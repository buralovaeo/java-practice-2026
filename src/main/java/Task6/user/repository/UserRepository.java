package Task6.user.repository;

import Task6.user.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Integer id);

    List<User> findAll();

    List<User> findAllByProfileDescription(String profileDescription);

    void updateProfileDescriptionByEmail(String email, String newProfileDescription);
}
