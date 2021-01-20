package MyUtil;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import static javafx.application.Platform.exit;

public class JdbcUtil {
    public JdbcUtil() {
    }

    /**
     * 静态代码块，实现每次该类只要被加载就注册驱动
     */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @throws SQLException
     * 该函数实现功能如下:获取连接JDBC
     */
    public static Connection getConnection() throws SQLException {
        ResourceBundle bundle = ResourceBundle.getBundle("MyUtil\\MyJdbc");
        String url=bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("passWord");
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("连接完成");
        return con;
    }


    /**
     *
     * @param con：连接对象
     * @param ps： 获取数据库操作的对象，可进行预编译
     * @param rs： 进行查询结果后返回的查询结果集
     *          函数主要是实现了各种操作的关闭
     */
    public static void closeJdbc(Connection con, PreparedStatement ps, ResultSet rs){
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
        }if(con!=null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        System.out.println("关闭完成");
    }

    /**
     *
     * @param con
     * @param ps
     *      该方法是一个重载，解决的是执行增删改后进行的关闭，只用关闭两个资源
     */
   public static void closeJdbc(Connection con, PreparedStatement ps){
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
       System.out.println("关闭完成");
    }

    /**
     * 该方法是一个SQL模糊查询的语句
     *      selectColumn:是查询的条件属性段
     *      myModule：是selectColumn所要匹配的属性
     * @param con
     * @return
     */
    public static ResultSet sqlQuery(Connection con){
        int flag = 1;
        ResultSet rs=null;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入您想要查询的表:");
        String selectTable = sc.next();
        //对选择的表的类型做标记，方便输出;
        if(selectTable.equals("student"))   flag=1;
        else if(selectTable.equals("course"))  flag=2;
        else if(selectTable.equals("sc"))       flag=3;
        else {
            System.out.println("!!!!!!!!!!!!!!您选择了错误的表!!!!!!!!!!!!!!!");
            exit();
        }
        System.out.print("您想将哪个字段作为查询条件:");
        String selectColumn=sc.next();
        System.out.print("请输入该字段的匹配条件：");
        String myModule = sc.next();
        String sql = "select * from "+selectTable+" where "+selectColumn+" like ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,myModule);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }



    /**
     * 插入语句
     * @param con
     * @return
     */
    public static int sqlInsert(Connection con){
        System.out.println("您好你当前正在执行的是插入事务");
        PreparedStatement ps = null;
        int count= 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("sno =:");
        String sno =sc.next();
        System.out.print("sname =:");
        String sname = sc.next();
        System.out.print("ssex =:");
        String ssex = sc.next();
        System.out.print("sage =:");
        int sage = sc.nextInt();
        System.out.print("sdept = :");
        String sdept = sc.next();
        String sql = "insert into student values (?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sno);
            ps.setString(2, sname);
            ps.setString(3, ssex);
            ps.setInt(4, sage);
            ps.setString(5, sdept);
            count = ps.executeUpdate();
            System.out.println("有"+count+"条记录已经插入成功");
            ps.clearParameters();
            ps = con.prepareStatement("select * from student");
            printResult(ps.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    public static int sqlUpdate(Connection con){
        PreparedStatement ps = null;
        ResultSet rs =null;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您想要修改的记录的特征是哪一个列的：");
        String selectColumn = sc.next();
        System.out.println("请输入该列匹配的特征");
        String myModule = sc.next();
        System.out.print("ssex =:");
        String ssex = sc.next();
        System.out.print("sage =:");
        int sage = sc.nextInt();
        System.out.print("sdept = :");
        String sdept = sc.next();
        String sql = "update student set ssex=?, sage=?, sdept=? where "+selectColumn+" like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,ssex);
            ps.setInt(2,sage);
            ps.setString(3,sdept);
            ps.setString(4, myModule);
            count=ps.executeUpdate();
            System.out.println("有"+count+"条记录已经修改成功");
            ps.clearParameters();
            ps = con.prepareStatement("select * from student where "+selectColumn+" like ?");
            ps.setString(1, myModule);
            printResult(ps.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int sqlDelete (Connection con){
        int count = 0;
        Scanner sc = new  Scanner(System.in);
        System.out.println("您当前正在执行的事务是删除");
        System.out.println("您要执行那张表：");
        String selectTable = sc.next();
        System.out.println("请输入您想要修改的记录的特征是哪一个列的：");
        String selectColumn = sc.next();
        System.out.println("请输入该列匹配的特征");
        String myModule = sc.next();
        String sql = "delete from student where "+selectColumn+" like ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,myModule);
            count = ps.executeUpdate();
            System.out.println("有"+count+"条记录已经删除成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    public static void printResult(ResultSet rs){
            try {
                if(rs==null)    return;
                /*
                while(rs.next()){
                    System.out.print(rs.getString("sno")+ " ");
                    System.out.print(rs.getString("sname")+ " ");
                    System.out.print(rs.getString("ssex")+ " ");
                    System.out.print(rs.getString("sage")+ " ");
                    System.out.println(rs.getString("sdept"));
                }
                 */
                while(rs.next()){
                    System.out.print(rs.getString(1)+ " ");
                    System.out.print(rs.getString(2)+ " ");
                    System.out.print(rs.getString(3)+ " ");
                    System.out.print(rs.getString(4)+ " ");
                    System.out.println(rs.getString(5));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
