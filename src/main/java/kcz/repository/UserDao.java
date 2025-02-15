package kcz.repository;

import kcz.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Dao {
    public UserDao() {
        super();
    }

     public List<User> getUsers() {
        String sql = "select * from users";
        List<User> users = new ArrayList<User>();

        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
     }

     public User getUser(int id) {
        String sql = "select * from users where id=?";
        User user = null;
        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(!rs.isBeforeFirst()) return null;
            rs.next();
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
     }

    public User getUser(String username ) {
        String sql = "select * from users where username=?";
        User user = null;
        try(Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(!rs.isBeforeFirst()) return null;
            rs.next();
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

     public void addUser(User user) {
        String sql = "insert into users (username) values (?)";

        try (Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.executeUpdate();
        } catch (SQLException e ) {
                throw new RuntimeException(e);
        }
     }
}
