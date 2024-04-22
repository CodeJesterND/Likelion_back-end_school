package april.day17.ex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook { // -> 전화번호부를 관리하는 클래스
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in)); // 사용자 입력을 받는 BufferedReader 생성
    private static final String FILE_NAME = "phone.txt"; // 파일 이름
    private static final String FILE_PATH = "." + File.separator + FILE_NAME; // 파일 경로
    private static final int NUM_ENTRIES = 3; // 입력받는 데이터의 수

    private List<PhoneEntry> phoneEntries = new ArrayList<>(); // 전화번호부를 저장하는 리스트

    /**
     * 전화번호를 파일에 저장하는 메서드
     */
    public void savePhoneNumbersToFile() {
        try (PrintWriter writer = new PrintWriter(FILE_PATH)) {
            // NUM_ENTRIES만큼 반복하여 사용자로부터 이름과 전화번호를 입력 받고 파일에 저장
            for (int i = 1; i <= NUM_ENTRIES; i++) {
                System.out.print("이름: ");
                String name = READER.readLine();
                System.out.print("전화번호: ");
                String phoneNumber = READER.readLine();
                phoneEntries.add(new PhoneEntry(name, phoneNumber)); // PhoneEntry 객체 생성 후 리스트에 추가
                writer.println(name + " " + phoneNumber); // 파일에 데이터 쓰기
            }
            System.out.println("전화번호가 " + FILE_PATH + "에 저장되었습니다.");
        } catch (IOException e) {
            // 파일 쓰기 중 오류 발생 시 예외 처리
            System.err.println("파일에 쓰기 오류가 발생했습니다: " + e.getMessage());
        }
    }

    /*
     * 파일에서 전화번호를 읽어와 출력하는 메서드
     */
    public void readPhoneNumbersFromFile() {
    }
}
