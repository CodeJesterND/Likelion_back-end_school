package exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    public static void main(String[] args) {
        // 1. 필요한 객체를 선언한다.
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 3. 접속
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl = "jdbc:mysql://localhost:3306/exampledb";
            String user = "root";
            String password = "240311";
            conn = DriverManager.getConnection(dburl, user, password);

            // 4. 쿼리작성
            String sql = "insert into dept(deptno,dname,loc) values (50,'개발부','서울')";
            ps = conn.prepareStatement(sql);

            // 5. 실행
            int count = ps.executeUpdate();
            System.out.println(count + " insert!!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 닫아준다.
            try {
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}