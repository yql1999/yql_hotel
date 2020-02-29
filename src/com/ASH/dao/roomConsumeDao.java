package com.ASH.dao;

import com.ASH.entity.RoomConsume;
import com.ASH.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class roomConsumeDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<RoomConsume> selectByIdTillNow(int roomId) {
        ArrayList<RoomConsume> roomConsumeEntities = new ArrayList<RoomConsume>();
//        roomConsumeEntities=null;
        String sql = "SELECT * FROM room_consume\n" +
                "where room_id=? and \n" +
                "\ttime>(select checkin_date from check_in where room_id=? and is_check_out=0)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, roomId);
            ps.setInt(2, roomId);
            System.out.println(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RoomConsume roomConsume = new RoomConsume();
                roomConsume.setId(rs.getInt("id"));
                roomConsume.setItem(rs.getString("item"));
                roomConsume.setPrice(rs.getDouble("price"));
                roomConsume.setTime(rs.getDate("time"));
                roomConsume.setRoomId(rs.getInt("room_id"));
                roomConsumeEntities.add(roomConsume);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return roomConsumeEntities;
    }

    public ArrayList<RoomConsume> selectAll() {
        ArrayList<RoomConsume> arrayList = new ArrayList<RoomConsume>();
        String sql = "SELECT * FROM room_consume";// where time>Date.now() - 7*8.64e7
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RoomConsume roomConsume = new RoomConsume();
                roomConsume.setId(rs.getInt("id"));
                roomConsume.setItem(rs.getString("item"));
                roomConsume.setPrice(rs.getDouble("price"));
                roomConsume.setTime(rs.getDate("time"));
                roomConsume.setRoomId(rs.getInt("room_id"));
                arrayList.add(roomConsume);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return arrayList;
    }
}
