package april.day17.ex;

public class PhoneBookManager {
    // 파일 이름과 경로, 입력할 전화번호의 개수를 상수로 정의
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook(); // PhoneBook 객체 생성
        phoneBook.savePhoneNumbersToFile(); // 전화번호를 파일에 저장하는 메서드 호출
        phoneBook.readPhoneNumbersFromFile(); // 파일에서 전화번호를 읽어와 출력하는 메서드 호출
    }
}