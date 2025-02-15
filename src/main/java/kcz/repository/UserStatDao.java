package kcz.repository;

import kcz.model.User;
import kcz.model.UserStat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserStatDao extends Dao {
    public UserStatDao() {
    }


    public List<UserStat> getStats(User user) {
        List<UserStat> stats = new ArrayList<UserStat>();
        String sql = "select * from user_stats where user_id=?";

        try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserStat stat = new UserStat();
                stat.setId(rs.getInt("id"));
                stat.setUser(user);
                stat.setWeight(rs.getInt("weight"));
                stat.setHeight(rs.getInt("height"));
                stat.setDate(rs.getDate("date"));
                stats.add(stat);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stats;
    }
}
