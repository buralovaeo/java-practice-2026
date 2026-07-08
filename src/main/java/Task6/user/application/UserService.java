package Task6.user.application;

import Task6.user.api.dto.UserDto;
import Task6.user.domain.User;
import Task6.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);
        return new UserDto(user.getId(), user.getEmail(), user.getProfileDescription());
    }

    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return new UserDto(user.getId(), user.getEmail(), user.getProfileDescription());
    }

    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDto(user.getId(), user.getEmail(), user.getProfileDescription()))
                .collect(Collectors.toList());
    }

    public List<UserDto> findAllUsersByProfileDescription(String profileDescription) {
        return userRepository.findAllByProfileDescription(profileDescription).stream()
                .map(user -> new UserDto(user.getId(), user.getEmail(), user.getProfileDescription()))
                .collect(Collectors.toList());
    }

    public void signUp(String name, String email, String password, String profileDescription) {
        User user = new User(name, email, password, profileDescription);
        userRepository.save(user);
    }

    public boolean signIn(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            return userOptional.get().getPassword().equals(password);
        }
        return false;
    }

    public void updateProfileDescriptionByEmail(String email, String newProfileDescription) {
        userRepository.updateProfileDescriptionByEmail(email, newProfileDescription);
    }
}