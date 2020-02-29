package com.ASH.dao;

import com.ASH.entity.Visitor;
import com.ASH.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class visitorDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Visitor> selectAll() {
        ArrayList<Visitor> visitors = new ArrayList<Visitor>();
        String sql = "select * from visitor";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Visitor visitor = new Visitor();
                visitor.setId(rs.getInt("id"));
                visitor.setName(rs.getString("name"));
                visitor.setPhoneNumber(rs.getString("phone_number"));
                visitor.setPower(rs.getString("power"));
                visitor.setRoomId(rs.getInt("room_id"));
                visitors.add(visitor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return visitors;
    }

}
