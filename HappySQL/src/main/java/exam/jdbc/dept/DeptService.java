package exam.jdbc.dept;

import java.util.List;

public class DeptService {
    private DeptDAO deptDAO;

    public DeptService(DeptDAO deptDAO) {
        this.deptDAO = deptDAO;
    }

    // 새로운 부서 추가
    public boolean addDept(DeptDTO dept) {
        return deptDAO.addDept(dept);
    }

    // 모든 부서 정보 가져오기
    public List<DeptDTO> getAllDepts() {
        return deptDAO.getAllDepts();
    }

    // 특정 부서 정보 가져오기
    public DeptDTO getDept(int deptno) {
        return deptDAO.getDept(deptno);
    }

    // 부서 정보 수정
    public boolean updateDept(DeptDTO dept) {
        return deptDAO.updateDept(dept);
    }

    // 부서 삭제
    public boolean deleteDept(int deptno) {
        return deptDAO.deleteDept(deptno);
    }
}