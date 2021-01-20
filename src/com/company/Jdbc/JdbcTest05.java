package com.company.Jdbc;
/*
    使用资源配置文件进行
 */

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcTest05 {
    public static void main(String[] args) {
        //使用资源绑定器绑定属性配置文件，注意这里得是src下的根目录
        ResourceBundle bundle = ResourceBundle.getBundle("com\\company\\Jdbc\\jdbc");
        Connection con =null;
        Statement stat = null;
        try{
            //1、注册驱动
            String driver=bundle.getString("driver");
            System.out.println(driver);
            Class.forName(driver);
            //2、获取连接
            String url=bundle.getString("url");
            String user=bundle.getString("user");
            String passWord=bundle.getString("passWord");
            System.out.println(driver+" "+user+" "+url+" "+passWord);
            con = DriverManager.getConnection(url, user, passWord);
            //3、获取数据库SQL对象
            stat = con.createStatement();
            //4、执行SQL对象
            String sql="insert into student values ('201215128', '黎明','男', 30, 'MA')";
            int count = stat.executeUpdate(sql);
            System.out.println(count);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            //6、关闭资源
            try {
                if(stat!=null)  stat.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                if(con!=null)   con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
