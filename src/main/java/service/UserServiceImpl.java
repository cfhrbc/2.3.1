package service;

import dao.UserDAO;
import model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userDAO.findUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.findAllUser();
    }
}
