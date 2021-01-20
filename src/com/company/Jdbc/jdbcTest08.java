package com.company.Jdbc;
/*
    sql注入语句的实现
 */

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class jdbcTest08 {
    public static void main(String[] args) {
        Connection con = null;
        Statement state=null;
        ResultSet rs=null;
        //使用资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("MyUtil\\jdbc");
        String driver=bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String pasWord = bundle.getString("passWord");

        String sno = "201215124";
        String sname = "张三";
        String ssex = "男";
        int sage = 20;
        String sdept = "MA";

        Scanner sc = new Scanner(System.in);
        System.out.print("sno =:");
        sno =sc.next();
        System.out.print("sname =:");
        sname = sc.next();
        System.out.print("ssex =:");
        ssex = sc.next();
        System.out.print("sage =:");
        sage = sc.nextInt();
        System.out.print("sdept = :");
        sdept = sc.next();




        try{
            //1、注册驱动
            Class.forName(driver);
            //2、获取连接
            con = DriverManager.getConnection(url, user, pasWord);
            //3、获取数据库操作对象
            state = con.createStatement();
            //4、执行SQL语句
            //String sql = "select *  from student where sname = '"+ sname +"'";
            //String sql = "select * from student order by sno "+sname;
            //rs = state.executeQuery(sql);

            String sql = "insert into student (sno, sname, ssex, sage, sdept) values ('"+sno+"', '"+sname+"', '"+ssex+"', "+sage+", '"+sdept+"')";
            //String sql = "insert into student (sno, sname, ssex, sage, sdept) values ('201215126', '李四', '男', 25, 'SG')";
            int count  = state.executeUpdate(sql);

           /*
            //5、处理查询结果
            while(rs.next()){
                System.out.print(rs.getString(1)+ " ");
                System.out.print(rs.getString(2)+ " ");
                System.out.print(rs.getString(3)+ " ");
                System.out.print(rs.getString(4)+ " ");
                System.out.println(rs.getString(5));

            }
            */
        }catch (Exception e){
            e.printStackTrace();
        }finally{
           if(rs!=null) {
               try {
                   rs.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
            if(state!=null) {
                try {
                    state.close();
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
