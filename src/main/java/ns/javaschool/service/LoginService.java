package ns.javaschool.service;

import ns.javaschool.repository.UserRepository;
import ns.javaschool.domain.User;

import java.util.List;

public class LoginService {

    private static LoginService instance;
    private static UserRepository userRepository;

    public static LoginService getInstance() {
        if (instance == null) {
            instance = new LoginService();
        }
        return instance;
    }

    private LoginService() {
        userRepository = UserRepository.getInstance();
    }

    public List<User> loadAll() {
        return userRepository.listAll();
    }

    public void save(User user) {
        userRepository.create(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public User canLogin(String userName, String password) {
        return userRepository.findByUsernameAndPassword(userName, password);
    }
}
