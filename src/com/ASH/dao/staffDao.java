package com.ASH.dao;

import com.ASH.entity.Staff;
import com.ASH.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class staffDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Staff> selectAll() {
        ArrayList<Staff> staffs = new ArrayList<Staff>();
        String sql = "select * from staff";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setId(rs.getInt("id"));
                staff.setName(rs.getString("name"));
                staff.setDocument_type(rs.getString("document_type"));
                staff.setDocument_number(rs.getString("document_number"));
                staff.setWork(rs.getString("job"));
                staffs.add(staff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return staffs;
    }

    public boolean del(String name) {
        String sql = "delete from staff where name=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
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

    public boolean add(String name,String document_type, String document_number, String gender,String job) {
        String sql = "insert into staff values (default ,?,default ,?,?,?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,document_type);
            ps.setString(3,document_number);
            ps.setString(4,gender);
            ps.setString(5,job);
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

    public boolean update(String name,String job) {
        String sql = "update staff set name=?,job=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,job);
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
