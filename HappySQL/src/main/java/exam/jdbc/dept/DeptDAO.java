package exam.jdbc.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {
    private final DBConnectionManager DBConnectionManager;

    // 생성자
    public DeptDAO(DBConnectionManager DBConnectionManager) {
        this.DBConnectionManager = DBConnectionManager;
    }

    // 새로운 부서 추가
    public boolean addDept(DeptDTO dept) {
        String sql = "INSERT INTO dept (deptno, dname, loc) VALUES (?, ?, ?)";
        boolean success = false;

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dept.getDeptno());
            ps.setString(2, dept.getDname());
            ps.setString(3, dept.getLoc());
            int rowCount = ps.executeUpdate();
            success = (rowCount > 0); // 영향 받은 행이 1 이상이면 성공으로 간주

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    // 모든 부서 정보 가져오기
    public List<DeptDTO> getAllDepts() {
        List<DeptDTO> depts = new ArrayList<>();
        String sql = "SELECT * FROM dept";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DeptDTO dept = new DeptDTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
                depts.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depts;
    }

    // 특정 부서 정보 가져오기
    public DeptDTO getDept(int deptno) {
        DeptDTO dept = null;
        String sql = "SELECT * FROM dept WHERE deptno = ?";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, deptno);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dept = new DeptDTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dept;
    }

    // 부서 정보 수정
    public boolean updateDept(DeptDTO dept) {
        String sql = "UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?";
        boolean isSuccess = false;

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dept.getDname());
            ps.setString(2, dept.getLoc());
            ps.setInt(3, dept.getDeptno());
            int rowsAffected = ps.executeUpdate();
            isSuccess = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    // 부서 삭제
    public boolean deleteDept(int deptno) {
        String sql = "DELETE FROM dept WHERE deptno = ?";
        boolean isSuccess = false;

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, deptno);
            int rowsAffected = ps.executeUpdate();
            isSuccess = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }
}

/*
DAO는 "Data Access Object"의 약자로, 데이터베이스나 다른 영구 저장소에 접근하는 객체를 말합니다.
DAO는 일반적으로 데이터베이스 연산을 수행하는 메서드를 제공하여 비즈니스 로직과 데이터베이스 접근을 분리하는 데 사용됩니다.
이를 통해 코드의 유지보수성과 가독성을 향상시키고, 데이터베이스 구현의 변경이 비즈니스 로직에 영향을 미치지 않도록 합니다.

DAO의 주요 목적은 다음과 같습니다:

데이터베이스 추상화: DAO는 데이터베이스와의 통신을 추상화하여 비즈니스 로직이 데이터베이스의 구체적인 세부 사항에 종속되지 않도록 합니다.
이는 데이터베이스 변경 시 비즈니스 로직에 영향을 최소화합니다.

CRUD 작업 제공: DAO는 일반적으로 데이터의 생성(Create), 읽기(Read), 갱신(Update), 삭제(Delete)와 같은 기본적인 데이터베이스 연산을 수행하는 메서드를 제공합니다.
이러한 메서드를 통해 데이터를 관리하고 조작할 수 있습니다.

트랜잭션 관리: 일부 DAO 구현은 트랜잭션 관리도 처리합니다. 여러 데이터베이스 작업을 단일 트랜잭션으로 묶어서 원자적인 작업 단위로 처리할 수 있습니다.

도메인 객체와의 상호작용: DAO는 도메인 객체와 데이터베이스 간의 매핑을 담당하기도 합니다.
데이터베이스로부터 데이터를 읽어와 도메인 객체로 변환하거나, 반대로 도메인 객체를 데이터베이스에 저장하는 등의 작업을 수행합니다.

보안 및 검증: DAO는 데이터베이스 액세스 시 보안 규칙을 적용하고 데이터의 유효성을 검증하는 데 사용될 수 있습니다.
대부분의 경우, 각각의 DAO는 특정한 엔터티(테이블)에 대응하며, 해당 엔터티와 관련된 데이터베이스 작업을 수행합니다. 예를 들어, 사용자 엔터티를 다루는 DAO는 사용자 데이터의 생성, 조회, 수정, 삭제 등의 작업을 수행할 수 있습니다.
 */