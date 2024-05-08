package exam.jdbc.dept;

import java.util.List;

public class DeptMain {
    public static void main(String[] args) {
        // DBConnectionManager 생성
        DBConnectionManager DBConnectionManager = new DBConnectionManager("jdbc:mysql://localhost:3306/exampledb", "root", "240311");

        // DeptDAO 생성
        DeptDAO deptDAO = new DeptDAO(DBConnectionManager);

        // DeptService 생성
        DeptService deptService = new DeptService(deptDAO);

        // 새로운 부서 추가
        DeptDTO newDept = new DeptDTO(50, "영업부", "서울");
        boolean success = deptService.addDept(newDept);
        System.out.println("부서 추가 성공 여부: " + success);

        // 모든 부서 정보 가져오기
        List<DeptDTO> allDepts = deptService.getAllDepts();
        System.out.println("모든 부서 정보:");
        for (DeptDTO dept : allDepts) {
            System.out.println(dept);
        }

        // 특정 부서 정보 가져오기
        int deptno = 50;
        DeptDTO retrievedDept = deptService.getDept(deptno);
        if (retrievedDept != null) {
            System.out.println("부서번호 " + deptno + "의 정보: " + retrievedDept);
        } else {
            System.out.println("부서번호 " + deptno + "의 정보를 찾을 수 없습니다.");
        }

        // 부서 정보 수정
        retrievedDept.setLoc("부산");
        boolean updateSuccess = deptService.updateDept(retrievedDept);
        System.out.println("부서 정보 수정 성공 여부: " + updateSuccess);

        // 부서 삭제
        int deptToDelete = 50;
        boolean deleteSuccess = deptService.deleteDept(deptToDelete);
        System.out.println("부서 삭제 성공 여부: " + deleteSuccess);
    }
}