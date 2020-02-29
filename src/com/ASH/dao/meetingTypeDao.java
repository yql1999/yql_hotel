package com.ASH.dao;

import com.ASH.entity.MeetingType;
import com.ASH.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class meetingTypeDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public MeetingType selectById(long meetingTypeId) {
        MeetingType meetingType=new MeetingType();
        String sql = "select * from meeting_type where id=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1,meetingTypeId);
            rs = ps.executeQuery();
            while (rs.next()) {
                meetingType.setId(rs.getInt("id"));
                meetingType.setPrice(rs.getDouble("price"));
                return meetingType;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return null;
    }
}
