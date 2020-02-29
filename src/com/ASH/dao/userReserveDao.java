package com.ASH.dao;

import com.ASH.entity.UserReserve;
import com.ASH.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;

public class userReserveDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<UserReserve> selectAll() {
        ArrayList<UserReserve> arrayList = new ArrayList<UserReserve>();
        String sql = "SELECT * FROM user_reserve";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserReserve userReserve = new UserReserve();
                userReserve.setId(rs.getInt("id"));
                userReserve.setName(rs.getString("name"));
                userReserve.setCheckinDate(rs.getDate("checkin_date"));
                userReserve.setCheckoutDate(rs.getDate("checkout_date"));
                userReserve.setRoomType(rs.getString("room_type"));
                userReserve.setPhoneNumber(rs.getString("phone_number"));
                arrayList.add(userReserve);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return arrayList;
    }

    public boolean del(String name) {
        String sql = "delete from user_reserve where name=? order by id desc";
        try {
            conn = DBUtil.getConnection();
            ps.setString(1,name);
            ps = conn.prepareStatement(sql);
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

    public boolean add(String name, Date checkin_date,Date checkout_date,String room_type,String phone_number) {
        String sql = "insert into user_reserve values (default ,?,?,?,?,default ,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDate(2,checkin_date);
            ps.setDate(3,checkout_date);
            ps.setString(4,room_type);
            ps.setString(5,phone_number);
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

    public boolean update(String name, Date checkin_date,Date checkout_date,String room_type) {
        String sql = "update user_reserve set name=?,checkin_date=?,checkout_date=?,room_type=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDate(2,checkin_date);
            ps.setDate(3,checkout_date);
            ps.setString(4,room_type);
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
