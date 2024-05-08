package exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {
    public static void main(String[] args) {
        // 1. 필요한 객체를 선언한다.
        String dburl = "jdbc:mysql://localhost:3306/exampledb";
        String user = "root";
        String password = "240311";

        // 3. 접속
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 4. 쿼리작성
        String sql = "delete from dept where deptno = 50";
        try (Connection conn = DriverManager.getConnection(dburl, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            // 5. 실행
            int count = ps.executeUpdate();
            System.out.println(count + " insert!!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}