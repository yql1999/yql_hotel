package com.ASH.dao;

import com.ASH.entity.MeetingReserve;
import com.ASH.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class meetingReserveDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<MeetingReserve> selectAll() {
        ArrayList<MeetingReserve> arrayList = new ArrayList<MeetingReserve>();
        String sql = "SELECT * FROM meeting_reserve";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MeetingReserve meetingReserve = new MeetingReserve();
                meetingReserve.setId(rs.getInt("id"));
                meetingReserve.setName(rs.getString("name"));
                meetingReserve.setMeetingId(rs.getInt("meeting_id"));
                meetingReserve.setTimePeriod(rs.getInt("time_period"));
                meetingReserve.setFace(rs.getBytes("face"));
                meetingReserve.setPhoneNumber(rs.getString("phone_number"));
                meetingReserve.setInviteCode(rs.getString("invite_code"));
                arrayList.add(meetingReserve);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return arrayList;
    }

    public boolean del(String name) {
        String sql = "delete from meeting_reserve where name=? order by id desc";
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

    public boolean add(Long meeting_id, String name,String phone_number,Long time_period) {
        String sql = "insert into meeting_reserve values (default ,?,?,?,default ,?,default )";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1,meeting_id);
            ps.setString(2,name);
            ps.setString(3,phone_number);
            ps.setLong(4,time_period);
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

    public boolean update(Long meeting_id, String name, Long time_period) {
        String sql = "update meeting_reserve set meeting_id=?,name=?,time_period=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1,meeting_id);
            ps.setString(2,name);
            ps.setLong(3,time_period);
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
