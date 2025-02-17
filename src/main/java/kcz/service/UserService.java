package kcz.service;

import kcz.Main;
import kcz.model.User;
import kcz.model.UserStat;
import kcz.model.Workout;
import kcz.repository.UserDao;
import kcz.repository.UserStatDao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class UserService {
    private UserDao userDao;
    private UserStatDao userStatDao;

    public UserService() {
        this.userDao = new UserDao();
        this.userStatDao = new UserStatDao();
    }

    public boolean createUser(User newUser) {
        boolean result = false;
        String username = newUser.getUsername();
        if(username == null || username.isEmpty()) {
            return false;
        }
        //look for existing user and add new user
        if(userDao.getUser(username) == null) {
            User user = new User();
            user.setUsername(username);
            userDao.addUser(user);
            result = true;
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


        return user;
    }

    public List<UserStat> getUserStats(User user) {
        if(user == null) {
            return null;
        }
        return userStatDao.getStats(user);
    }

    public void addUserStat(UserStat userStat) {
        userStat.setDateCreate(LocalDate.now());
        userStat.setUser(Main.currentUser);
        userStatDao.createUserStat(userStat);
    }

    public void removeUserStat(UserStat stat) {
        userStatDao.removeUserStat(stat.getId());
        // reload list in user instance
        Main.currentUser.setUserStats(userStatDao.getStats(Main.currentUser));
    }
}
