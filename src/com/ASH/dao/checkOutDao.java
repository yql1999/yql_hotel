package com.ASH.dao;

import com.ASH.entity.CheckOut;
import com.ASH.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class checkOutDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<CheckOut> selectByIDcard(int type,String idCard) {
        ArrayList<CheckOut> checkOuts = new ArrayList<CheckOut>();
        String sql = "select * from as_hotel_mis.check_out where document_type=? and document_number=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,type);
            ps.setString(2,idCard);
            rs = ps.executeQuery();
            while (rs.next()) {
                CheckOut checkOut=new CheckOut();
                checkOut.setId(rs.getInt("id"));
                checkOut.setCheckinDate(rs.getDate("checkin_date"));
                checkOut.setCheckoutDate(rs.getDate("checkout_date"));
                checkOut.setPrice(rs.getDouble("price"));
                checkOut.setName(rs.getString("name"));
                checkOut.setDocumentType(rs.getInt("document_type"));
                checkOut.setDocumentNumber(rs.getString("document_number"));
                checkOut.setRoomId(rs.getInt("room_id"));
                //checkOut.setCheckInId(rs.getInt("checkin_id"));
                checkOuts.add(checkOut);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return checkOuts;
    }
}
