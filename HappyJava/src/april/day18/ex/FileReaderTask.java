package april.day18.ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTask implements Runnable { // -> 파일에서 데이터를 읽어 콘솔에 출력하는 스레드 구현 클래스
    private String fileName; // 파일 이름

    public FileReaderTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));){
            String line; // 읽어온 파일의 내용을 한줄씩 담기 위한 변수

            while ((line = reader.readLine()) != null) { // 파일에서 한 줄씩 읽어서 콘솔에 출력
                System.out. println(line);
            }

        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage()); // 파일 읽기 오류 처리
        }
    }
}