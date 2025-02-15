package kcz.model;

import java.util.Date;

public class UserStat {
    private int id;
    private User user;
    private int weight;
    private int height;
    private Date date;

    public UserStat(User user, int weight, int height, Date date) {
        this.user = user;
        this.weight = weight;
        this.height = height;
        this.date = date;
    }

    public UserStat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
