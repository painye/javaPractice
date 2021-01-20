package com.company.Jdbc;
/*
    练习praperStatement的预编译
 */
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class JdbcTest09 {
    public static void main(String[] args) {
        //配置资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("com\\company\\Jdbc\\jdbc");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("passWord");

        String sno = "201215124";
        String sname = "张三";
        String ssex = "男";
        int sage = 20;
        String sdept = "MA";

        Scanner sc = new Scanner(System.in);
        System.out.print("sname = :");
        sname = sc.next();


        try{
            //1、注册驱动

            Class.forName(driver);
            //2、获取连接
            con = DriverManager.getConnection(url, user, password);
            //3、获取数据库操作对象
            String sql ="select * from student where sname = ?";
            ps=con.prepareStatement(sql);
            //4、执行SQL语句
            ps.setString(1, sname);
            rs =ps.executeQuery();
            //5、处理返回结果
            while (rs.next()){
                System.out.print(rs.getString("sno")+ " ");
                System.out.print(rs.getString("sname")+ " ");
                System.out.print(rs.getString("ssex")+ " ");
                System.out.print(rs.getString("sage")+ " ");
                System.out.println(rs.getString("sdept"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //6、关闭资源
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
