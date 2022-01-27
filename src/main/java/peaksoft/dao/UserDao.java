package peaksoft.dao;

import peaksoft.model.User;

import java.util.List;

public interface UserDao {

    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    List<User> getAllUsers();

    void removeUserByName();

    void UpdateUsers();

    List<User> getAllUser();

    void cleanUsersTable();
}
