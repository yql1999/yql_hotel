package com.ASH.dao;

import com.ASH.entity.Room;
import com.ASH.entity.RoomType;
import com.ASH.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class roomDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public Room selectById(long roomId) {
        Room room=new Room();
        String sql = "select * from room where id=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1,roomId);
            rs = ps.executeQuery();
            while (rs.next()) {
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getString("room_number"));
                room.setTypeId(rs.getInt("type_id"));
                room.setState(rs.getString("state"));
                return room;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return null;
    }

    public ArrayList<Room> selectAll() {
        Room room=new Room();
        String sql = "select * from room";
        ArrayList<Room> arrayList=new ArrayList<Room>();
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getString("room_number"));
                room.setTypeId(rs.getInt("type_id"));
                room.setState(rs.getString("state"));
                arrayList.add(room);
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return null;
    }

    public boolean del(String room_number) {
        String sql = "delete from room where room_number=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,room_number);
            int x = ps.executeUpdate();
            if (x>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return false;
    }

    public boolean add(String room_number, Long type_id, String state) {
        String sql = "insert into room values (default ,?,?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,room_number);
            ps.setLong(2,type_id);
            ps.setString(3,state);
            System.out.println(sql);
            int x = ps.executeUpdate();
            if (x>0)
                return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
    }

    public boolean update(String room_number, Long type_id, String state) {
        String sql = "update room set room_number=?,type_id=?,state=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,room_number);
            ps.setLong(2,type_id);
            ps.setString(3,state);
            System.out.println(sql);
            int x = ps.executeUpdate();
            if (x>0)
                return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
    }
}
