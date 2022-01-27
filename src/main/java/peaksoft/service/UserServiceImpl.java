package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    UserDao userDao = new UserDaoImpl();
    @Override
    public void createUsersTable() {
    userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
    userDao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
    userDao.saveUser(name,lastName,age);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void removeUserByName() {
        userDao.removeUserByName();
    }

    @Override
    public void UpdateUsers() {
    userDao.UpdateUsers();
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void cleanUsersTable() {
    userDao.cleanUsersTable();
    }
}
