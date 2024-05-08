package exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {
    public static void main(String[] args) {
        // 1. 필요한 객체를 선언한다.
        String dburl = "jdbc:mysql://localhost:3306/exampledb";
        String user = "root";
        String password = "240311";

        String dname = "인사부";
        int deptno = 50;

        // 3. 접속
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 4. 쿼리작성
        String sql = "update dept set dname = ? where deptno = ?";
        try (Connection conn = DriverManager.getConnection(dburl, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            // 5. 실행
            // 6. ? 에 대한 값을 바인딩한다.
            ps.setString(1, dname);
            ps.setInt(2, deptno);
            int count = ps.executeUpdate();
            System.out.println(count + " update!!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}