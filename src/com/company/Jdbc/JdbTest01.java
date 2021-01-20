package com.company.Jdbc;

import java.sql.*;

public class JdbTest01 {
    public static void main(String[] args) {
        //1、注册驱动
        Statement statement = null;
        Connection con = null;
        try {
            Driver drive= new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(drive);
            String url="jdbc:mysql://127.0.0.1:3306/db4";
            //2、获取连接
        /*
            url：统一资源定位符，网络中某个资源的绝对路径
            jdbc:mysql://127.0.0.1:3306/db4
              协议         ip地址    端口号  数据库实例名
              localhost 和127.0.0.1都是本机密码
         */
            String user="root";
            String password="";
             con= DriverManager.getConnection(url, user, password);
            System.out.println(con);

            //3、获取数据库sql语句
            statement = con.createStatement();

            //4、执行SQL语句
            String sql="insert into student (sno, sname, ssex, sage, sdept) values ('201215128', '李明', '男', 30, 'MA')";
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            //5、处理查询结果

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6、释放资源， 从小到大依次关闭
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }



    }
}
