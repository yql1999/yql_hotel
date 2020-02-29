package com.ASH.dao;

import com.ASH.entity.CheckIn;
import com.ASH.entity.Meeting;
import com.ASH.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class meetingDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Meeting> getAll() {
        ArrayList<Meeting> meetings = new ArrayList<Meeting>();
        String sql = "select * from meeting";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Meeting meeting = new Meeting();
                meeting.setId(rs.getInt("id"));
                meeting.setMeetingNumber(rs.getString("meeting_number"));
                meeting.setTypeId(rs.getInt("type_id"));
                meeting.setState(rs.getString("state"));
                meetings.add(meeting);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return meetings;
    }

    public boolean del(String meeting_number) {
        String sql = "delete from meeting where meeting_number=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,meeting_number);
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

    public boolean add(String meeting_number, Long type_id, String state) {
        String sql = "insert into meeting values (default ,?,?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,meeting_number);
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

    public boolean update(String meeting_number, Long type_id) {
        String sql = "update meeting set meeting_number=?,type_id=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,meeting_number);
            ps.setLong(2,type_id);
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
