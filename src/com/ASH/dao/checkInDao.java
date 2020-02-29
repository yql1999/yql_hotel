package com.ASH.dao;


import com.ASH.entity.CheckIn;
import com.ASH.util.DBUtil;
import com.ASH.util.faceRecUtil;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class checkInDao {
    public checkInDao(){
        super();
    }
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<CheckIn> getAll() {
        ArrayList<CheckIn> checkIns = new ArrayList<CheckIn>();
        String sql = "select * from check_in";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CheckIn checkIn = new CheckIn();
                checkIn.setId(rs.getInt("id"));
                checkIn.setName(rs.getString("name"));
                checkIn.setDocumentType(rs.getString("document_type"));
                checkIn.setDocumentNumber(rs.getString("document_number"));
                checkIn.setGender(rs.getString("gender"));
                checkIn.setFace(rs.getBytes("face"));
                checkIn.setCheckinDate(rs.getDate("checkin_date"));
                checkIn.setCheckoutDate(rs.getDate("checkout_date"));
                checkIn.setTime(rs.getString("time"));
                checkIn.setRoomId(rs.getInt("room_id"));
                checkIn.setRelatedRoom(rs.getString("related_room"));
                checkIn.setPhoneNumber(rs.getString("phone_number"));
                checkIns.add(checkIn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return checkIns;
    }

    public CheckIn getByRoomId(int id) {
        CheckIn checkIn = new CheckIn();
        String sql = "select * from check_in where id=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                checkIn.setName(rs.getString("name"));
                checkIn.setDocumentType(rs.getString("document_type"));
                checkIn.setDocumentNumber(rs.getString("document_number"));
                checkIn.setGender(rs.getString("gender"));
                checkIn.setFace(rs.getBytes("face"));
                checkIn.setCheckinDate(rs.getDate("checkin_date"));
                checkIn.setCheckoutDate(rs.getDate("checkout_date"));
                checkIn.setTime(rs.getString("time"));
                checkIn.setRoomId(rs.getInt("room_id"));
                checkIn.setRelatedRoom(rs.getString("related_room"));
                checkIn.setPhoneNumber(rs.getString("phone_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return checkIn;
    }

    public boolean del(String name) {
        CheckIn checkIn = new CheckIn();
        String sql = "delete from check_in where name=?";
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

    public boolean add(String name, String document_type, String document_number, String gender,
                       Date checkin_date, Date checkout_date, String time, String phone_number) {
        String sql = "insert into check_in values (default ,?,?,?,?,default ,?,?,?,default ,default ,?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,document_type);
            ps.setString(3,document_number);
            ps.setString(4,gender);
            ps.setDate(5,checkin_date);
            ps.setDate(6,checkout_date);
            ps.setString(7,time);
            ps.setInt(8,0);
            ps.setString(9,phone_number);
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

    public boolean update(String name, Date checkin_date, Date checkout_date, String time) {
        String sql = "update check_in set name=?,checkout_date=?,checkout_date=?,time=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDate(2,checkin_date);
            ps.setDate(3,checkout_date);
            ps.setString(4,time);
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

    public Map<String,Object> getAllIn() {
        Map<String,Object> map = new HashMap<String,Object>();
        ArrayList<CheckIn> checkIns = new ArrayList<CheckIn>();
        String sql = "select * from as_hotel_mis.check_in where is_check_out=0";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CheckIn checkIn = new CheckIn();
                checkIn.setId(rs.getInt("id"));
                checkIn.setName(rs.getString("name"));
                checkIn.setDocumentType(rs.getString("document_type"));
                checkIn.setDocumentNumber(rs.getString("document_number"));
                checkIn.setGender(rs.getString("gender"));
                checkIn.setFace(rs.getBytes("face"));
                checkIn.setCheckinDate(rs.getDate("checkin_date"));
                checkIn.setCheckoutDate(rs.getDate("checkout_date"));
                checkIn.setTime(rs.getString("time"));
                checkIn.setRoomId(rs.getInt("room_id"));
                checkIn.setRelatedRoom(rs.getString("related_room"));
                checkIn.setPhoneNumber(rs.getString("phone_number"));
                checkIns.add(checkIn);
                map.put("ok",1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("ok",-1);
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        if(checkIns.size()==0)
            map.put("ok",0);
        map.put("checkIn",checkIns);
        return map;
    }

    public CheckIn findByFace(byte[] face) {
        CheckIn checkIn = new CheckIn();
        String sql = "select * from as_hotel_mis.check_in where face=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setBytes(1,face);
            rs = ps.executeQuery();
            while (rs.next()) {
                checkIn.setId(rs.getInt("id"));
                checkIn.setName(rs.getString("name"));
                checkIn.setDocumentType(rs.getString("document_type"));
                checkIn.setDocumentNumber(rs.getString("document_number"));
                checkIn.setGender(rs.getString("gender"));
                checkIn.setCheckinDate(rs.getDate("checkin_date"));
                checkIn.setCheckoutDate(rs.getDate("checkout_date"));
                checkIn.setTime(rs.getString("time"));
                checkIn.setRoomId(rs.getInt("room_id"));
                checkIn.setRelatedRoom(rs.getString("related_room"));
                checkIn.setPhoneNumber(rs.getString("phone_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return checkIn;
    }

    /**
     * 得到至今为止的入住天数
     * @return
     */
    public int getDays(int roomId) {
        int days=0;
        String sql = "SELECT (to_days(now()) - to_days(checkin_date)) days FROM check_in where room_id=? and is_check_out=0;";
        //返回结果第一行为null
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,roomId);
            rs = ps.executeQuery();
            while (rs.next()) {
                days=rs.getInt("days");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return days;
    }

    public boolean insertfortest(String name, String phone, boolean isCheckOut, File file) {
        int r=-1;
        String sql = "insert into check_in(name, phone_number, face, is_check_out) values (?,?,?,?)";
        byte[] face=new byte[1032];
        face=new faceRecUtil().getFaceFeature(file).getFeatureData();
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,phone);
            ps.setBytes(3,face);
            ps.setBoolean(4,isCheckOut);
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

    public ArrayList<CheckIn>DailyCheckIn(String checkin_date){
        ArrayList<CheckIn> DailyCheckIn=new ArrayList<>();
        String sql = "select * from check_in where checkin_date = ? and time is not null ";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,checkin_date);
            rs = ps.executeQuery();
            while (rs.next()) {
                CheckIn checkIn = new CheckIn();
                checkIn.setId(rs.getInt("id"));
                checkIn.setName(rs.getString("name"));
                checkIn.setDocumentType(rs.getString("document_type"));
                checkIn.setDocumentNumber(rs.getString("document_number"));
                checkIn.setGender(rs.getString("gender"));
                checkIn.setFace(rs.getBytes("face"));
                checkIn.setCheckinDate(rs.getDate("checkin_date"));
                checkIn.setCheckoutDate(rs.getDate("checkout_date"));
                checkIn.setTime(rs.getString("time"));
                checkIn.setRoomId(rs.getInt("room_id"));
                checkIn.setRelatedRoom(rs.getString("related_room"));
                checkIn.setPhoneNumber(rs.getString("phone_number"));
                DailyCheckIn.add(checkIn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return DailyCheckIn;
    }

    public ArrayList<CheckIn>MonthlyCheckIn(String year,String month){
        ArrayList<CheckIn> MonthlyCheckIn=new ArrayList<>();
        String sql = "select * from check_in where checkin_date LIKE ?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            String s=year+"-"+month+"%";
            ps.setString(1,s);
            //System.out.println(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CheckIn checkIn = new CheckIn();
                checkIn.setId(rs.getInt("id"));
                checkIn.setName(rs.getString("name"));
                checkIn.setDocumentType(rs.getString("document_type"));
                checkIn.setDocumentNumber(rs.getString("document_number"));
                checkIn.setGender(rs.getString("gender"));
                checkIn.setFace(rs.getBytes("face"));
                checkIn.setCheckinDate(rs.getDate("checkin_date"));
                checkIn.setCheckoutDate(rs.getDate("checkout_date"));
                checkIn.setTime(rs.getString("time"));
                checkIn.setRoomId(rs.getInt("room_id"));
                checkIn.setRelatedRoom(rs.getString("related_room"));
                checkIn.setPhoneNumber(rs.getString("phone_number"));
                MonthlyCheckIn.add(checkIn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return MonthlyCheckIn;
    }


}
