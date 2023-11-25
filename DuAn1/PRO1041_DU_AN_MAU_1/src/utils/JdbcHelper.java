package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcHelper {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost;database=qlBanCafe;encrypt=false";
    private static String username = "sa";
    private static String password = "songlong";

    /*
     * Nạp driver
     */
    static {
        try {
            Class.forName(driver);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection connection = DriverManager.getConnection(dburl, username, password);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = connection.prepareCall(sql);
        } else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }


    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public static ResultSet query(String sql, Object... args) {
        ResultSet rs = null;
        try {
            PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static Object value(String sql, Object... args) {
        Object ob = null;
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            if (rs.next()) {
                ob = rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;
    }
}
