package com.ASH.dao;

import com.ASH.entity.User;
import com.ASH.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class userDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<User>();
        String sql = "select * from user";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setPhoneNumber(rs.getString("phone_number"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return users;
    }

    public User selectByOpenId(String openId) {
        User user=new User();
        String sql = "select * from user where open_id=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,openId);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setOpenId(rs.getNString("open_id"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return null;
    }

    /**
     * 将人脸信息插入user表中，返回true成功，返回false失败
     * @return
     */
    public boolean insertFace(byte[] face) {
        int r=-1;
        String sql = "insert into user(face) values (?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setBytes(1,face);
            r=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        if(r>0)
            return true;
        return false;
    }

    public boolean insertOpenId(String openId) {
        int r=-1;
        String sql = "insert into user(open_id) values (?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,openId);
            r=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        if(r>0)
            return true;
        return false;
    }
}
