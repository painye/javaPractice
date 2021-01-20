package com.company.Jdbc;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
public class JdbcTest07 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stat = null;
        ResultSet rs=null;
        try{
            //1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、连接驱动
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4", "root", "");
            //3、获取数据库操作对象a
            stat = con.createStatement();
            //4、执行SQL语句
            String sql="select sno,sname,ssex,sage as a, sdept from student where sage<=20";
            //executeUpdate只能适用于增删改（insert，update， delete）
            rs= stat.executeQuery(sql);
            String sno =null;
            String sname=null;
            String ssex=null;
            String sage=null;
            String sdept=null;
            //5、操作返回结果哦
            /*使用列下标123获取字符串
            while(rs.next()){
                sno = rs.getString(1);
                sname=rs.getString(2);
                ssex = rs.getString(3);
                sage = rs.getString(4);
                sdex = rs.getString(5);
                System.out.println(sno + " "+sname +" "+ ssex+" "+sage+" "+ sdept);
            }
            */


            /*
            while(rs.next()){
                sno = rs.getString("sno");
                sname = rs.getString("sname");
                ssex = rs.getString("ssex");
                sage = rs.getString("a");//在getString处的列明不是数据库表中的列名，而实我sql中查找的列名
                sdept = rs.getString("sdept");
                System.out.println(sno + " "+sname +" "+ ssex+" "+sage+" "+ sdept);
            }
             */

            while(rs.next()){
                sno = rs.getString("sno");
                sname = rs.getString("sname");
                ssex = rs.getString("ssex");
                int age = rs.getInt("a");//在getString处的列明不是数据库表中的列名，而实我sql中查找的列名
                sdept = rs.getString("sdept");
                System.out.println(sno + " "+sname +" "+ ssex+" "+age+" "+ sdept);
            }



        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(rs!=null) rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if(con !=null)  con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                if(stat!=null)  stat.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
