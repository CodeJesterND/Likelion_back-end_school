package april.day17.ex;

/**
 * 전화번호부의 한 항목을 나타내는 클래스
 */
public class PhoneEntry {
    private String name; // 이름
    private String phoneNumber; // 전화번호

    /**
     * PhoneEntry의 생성자
     * @param name        이름
     * @param phoneNumber 전화번호
     */

    public PhoneEntry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * 이름 Getter
     * @return 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 이름 Getter
     * @return 전화번호
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}