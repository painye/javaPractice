package com.company.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class JdbcTest11 {
    public static void main(String[] args) {
        //配置资源绑定器帮顶属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("com\\company\\Jdbc\\jdbc");
        Connection con =null;
        PreparedStatement ps = null;

        String driver =bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("passWord");

        String sname="";
        String sno ="";
        String ssex = "";
        int sage=0;
        String sdept="";

        Scanner sc = new Scanner(System.in);
        //System.out.print("sno =:");
        //sno =sc.next();
        System.out.print("sname =:");
        sname = sc.next();
        System.out.print("ssex =:");
        ssex = sc.next();
        System.out.print("sage =:");
        sage = sc.nextInt();
        //System.out.print("sdept = :");
        //sdept = sc.next();

        try{
            //1、注册驱动
            Class.forName(driver);
            //2、获取连接
            con = DriverManager.getConnection(url, user, password);
            //3、获取数据库操作对象
            String sql = "update student set sname = ?, ssex = ?, sage = ? where sname = '刘德华'";
            ps = con.prepareStatement(sql);
            //4、执行SQL语句
            ps.setString(1,sname);
            ps.setString(2,ssex);
            ps.setInt(3,sage);

            int count = ps.executeUpdate();
            System.out.println(count);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(ps!=null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
