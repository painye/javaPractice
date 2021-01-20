package com.company.Jdbc;

import java.sql.*;
public class JdbcTest03 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stat=null;
        try{
            //1、驱动注册
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //2、获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4", "root", "");
            //3、获取SQL对象
            stat = con.createStatement();
            //4、执行SQL语句
            String sql = "update student set ssex = '女' where sname = '刘大哥'";
            int count=stat.executeUpdate(sql);
            System.out.println(count);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(stat !=null) stat.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                if(con !=null)  con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
