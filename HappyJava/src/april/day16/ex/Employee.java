package april.day16.ex;

public class Employee {
    private String name; // 이름
    private String id; // 아이디
    private String department; // 부서

    // 사원 정보 생성
    public Employee(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    // 아이디 조회
    public String getId() {
        return id;
    }

    // 이름 조회
    public String getName() {
        return name;
    }

    // 부서 조회
    public String getDepartment() {
        return department;
    }

    // 참조값, 클래스 형태, 필드값을 비교
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return id.equals(employee.id);
    }

    // 아이디를 기준으로 해시코드를 생성
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}