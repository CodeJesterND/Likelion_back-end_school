package april.day18.ex;

import java.io.*;

public class FileWriterTask implements Runnable {
    private final String fileName; // 파일 이름

    public FileWriterTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true)); BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.print("출력할 내용을 입력하세요 (종료하려면 'exit' 입력): ");
                String input = reader.readLine(); // 사용자 입력을 파일에 쓰기

                if (input.equals("exit")) {
                    break;
                }
                writer.println(input);
            }
            System.out.println("파일에 데이터를 쓰기를 종료합니다."); // 파일 쓰기 완료 메시지

        } catch (IOException e) {
            // 파일 쓰기 오류 처리
            System.err.println("파일 쓰기 오류: " + e.getMessage());
        }
    }
}
