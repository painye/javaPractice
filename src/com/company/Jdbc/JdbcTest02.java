package com.company.Jdbc;

import java.sql.*;

public class JdbcTest02 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stat = null;
        try{
            //1、注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //2、获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4", "root", "");
            //3、获取数据库SQL对象
            stat = con.createStatement();
            //4、执行SQL语句
            String sql = "delete from student where sno = '201215128'";
            int count = stat.executeUpdate(sql);
            System.out.println(count);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(stat != null)    stat.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(con != null) con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}

