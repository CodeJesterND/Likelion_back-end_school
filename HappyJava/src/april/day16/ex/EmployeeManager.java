package april.day16.ex;

import java.util.HashSet;
import java.util.Set;

class EmployeeManager {
    private Set<Employee> employees; // 중복을 허용하지 않는 HashSet 활용

    // 생성자(사원)
    public EmployeeManager() {
        employees = new HashSet<>();
    }

    // 사원 추가
    public void addEmployee(Employee employee) {
        if (employees.contains(employee)) { // 중복 체크
            System.out.println("중복된 사원 정보입니다.");
            return;
        }
        employees.add(employee);
        System.out.println("사원 정보가 추가되었습니다.");
    }

    // 사원 삭제
    public void removeEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            System.out.println("사원 정보가 삭제되었습니다.");
            return;
        }
        System.out.println("삭제할 사원 정보가 존재하지 않습니다.");
    }

    // 사원 검색
    public void findEmployee(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) { // 아이디로 사원 검색
                System.out.println("사원 정보를 찾았습니다:");
                System.out.println("이름: " + employee.getName() + ", 아이디: " + employee.getId() + ", 부서: " + employee.getDepartment());
                return;
            }
        }
        System.out.println("해당 아이디의 사원 정보를 찾을 수 없습니다.");
    }
}