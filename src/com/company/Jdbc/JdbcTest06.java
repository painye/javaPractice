package com.company.Jdbc;
/*
    练习porpertries属性文件
 */
import java.sql.*;
import java.util.ResourceBundle;

public class JdbcTest06 {
    public static void main(String[] args) {
        //使用资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("com\\company\\Jdbc\\jdbc");
        String driver=bundle.getString("driver");
        String url =bundle.getString("url");
        String user=bundle.getString("user");
        String passWord=bundle.getString("passWord");
        //1、注册驱动
        Connection con =null;
        Statement stat = null;
        try{
            Class.forName(driver);
            //2、获取连接
            con = DriverManager.getConnection(url, user, passWord);
            System.out.println(con);
            //3、获取数据库操作对象
            stat= con.createStatement();
            //4、执行SQL语句
            String sql = "";

            //5、处理查询结果
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }


        //6、关闭资源
    }
}
