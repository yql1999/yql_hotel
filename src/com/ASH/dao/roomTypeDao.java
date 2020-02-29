package com.ASH.dao;

import com.ASH.entity.RoomType;
import com.ASH.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class roomTypeDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public RoomType selectById(long roomTypeId) {
        RoomType roomType=new RoomType();
        String sql = "select * from room_type where id=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1,roomTypeId);
            rs = ps.executeQuery();
            while (rs.next()) {
                roomType.setId(rs.getInt("id"));
                roomType.setPrice(rs.getDouble("price"));
                roomType.setName(rs.getString("name"));
                return roomType;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return null;
    }
}
