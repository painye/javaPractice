package com.company.Jdbc;
import MyUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtilTest01 {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;

        try {
            con=JdbcUtil.getConnection();
            System.out.println(con);
            rs = JdbcUtil.sqlQuery(con);
            JdbcUtil.printResult(rs);
            //JdbcUtil.sqlInsert(con);
            //JdbcUtil.sqlUpdate(con);
            //JdbcUtil.sqlDelete(con);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeJdbc(con, ps, rs);
        }

    }
}
