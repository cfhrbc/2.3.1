package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    void save(User user);

    void update(User user);

    void delete(User user);

    User findUser(long id);

    List<User> findAllUser();
}
