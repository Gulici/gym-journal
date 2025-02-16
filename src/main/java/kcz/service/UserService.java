package kcz.service;

import kcz.model.User;
import kcz.model.UserStat;
import kcz.model.Workout;
import kcz.repository.UserDao;
import kcz.repository.UserStatDao;

import java.util.List;

public class UserService {
    private UserDao userDao;
    private UserStatDao userStatDao;

    public UserService(UserDao userDao, UserStatDao userStatDao) {
        this.userDao = userDao;
        this.userStatDao = userStatDao;
    }

    public boolean createUser(String username) {
        boolean result = false;
        if(username == null || username.isEmpty()) {
            return false;
        }
        //look for existing user and add new user
        if(userDao.getUser(username) == null) {
            User user = new User();
            user.setUsername(username);
            userDao.addUser(user);
        }
        return result;
    }

    public User getUser(String username) {
        if(username == null || username.isEmpty()) {
            return null;
        }
        User user = userDao.getUser(username);
        if(user == null) {
            return null;
        }

        List<UserStat> userStats =  userStatDao.getStats(user);
        user.setUserStats(userStats);

//        List<Workout> workouts = workout;


        return userDao.getUser(username);
    }
}
