package exam.jdbc.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private final String URL;
    private final String USER;
    private final String PASSWORD;

    // 생성자
    public DBConnectionManager(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    // 커넥션 풀에서 커넥션을 가져오는 메서드
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}