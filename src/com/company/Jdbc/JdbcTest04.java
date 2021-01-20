package com.company.Jdbc;
/*
    注册驱动的第二种方法使用反射来注册驱动
 */

import java.sql.*;
public class JdbcTest04 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stat=null;
        try {
            //1、注册驱动
            //这里采用了反射来创捷一个class =，也就是运行类的实例。
            //当着哥被创建的时候，类就会被加载，应为在com.mysql.cj.jdbc.Driver类中有个静态代码块实现可下列功能
            // DriverManager.rejisterDriver(new com.mysql.cj.jdbc.Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4", "root", "");
            System.out.println(con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
