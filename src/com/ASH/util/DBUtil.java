package com.ASH.util;

import java.sql.*;

public class DBUtil {
    //获取连接
    public static Connection getConnection(){
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/as_hotel_mis?serverTimezone=UTC";
        final String USER = "root";
        final String PASSWORD = "123456";

        try{
            Class.forName(JDBC_DRIVER);
            Connection conn= DriverManager.getConnection(DB_URL,USER,PASSWORD);
            System.out.println("链接数据库成功");
            return conn;
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //关闭连接，释放资源
    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if(rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(ps != null){
                    ps.close();
                    ps = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(conn != null) {
                        conn.close();
                        conn = null;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //没有结果集释放资源
    public static void close(Statement ps, Connection con) {
        try {
            if(ps != null){
                ps.close();
                ps = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
