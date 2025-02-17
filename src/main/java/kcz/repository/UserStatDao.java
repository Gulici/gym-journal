package kcz.repository;

import kcz.model.User;
import kcz.model.UserStat;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserStatDao extends Dao {
    public UserStatDao() {
    }

    public void createUserStat(UserStat userStat) {
        String sql = "insert into user_stats(user_id,weight,height,date_create) values(?,?,?,?)";
        try(Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,userStat.getUser().getId());
            ps.setInt(2,userStat.getWeight());
            ps.setInt(3,userStat.getHeight());
            ps.setString(4, Date.valueOf(userStat.getDateCreate()).toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserStat> getStats(User user) {
        List<UserStat> stats = new ArrayList<UserStat>();
        String sql = "select * from user_stats where user_id=?";

        try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,user.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserStat stat = new UserStat();
                stat.setId(rs.getInt("id"));
                stat.setUser(user);
                stat.setWeight(rs.getInt("weight"));
                stat.setHeight(rs.getInt("height"));

                String dateStr = rs.getString("date_create");
                LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                stat.setDateCreate(date);
                stats.add(stat);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stats;
    }

    public void removeUserStat(int id) {
        String sql = "delete from user_stats where id=?";
        try(Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
