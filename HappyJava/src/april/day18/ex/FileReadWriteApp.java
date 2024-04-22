package april.day18.ex;

public class FileReadWriteApp {
    public static void main(String[] args) {
        final String INPUT_FILE = "input.txt";
        final String OUTPUT_FILE = "output.txt";

        // 파일 읽기 스레드 생성 및 실행
        Thread readerThread = new Thread(new FileReaderTask(INPUT_FILE));
        readerThread.start();

        // 파일 쓰기 스레드 생성 및 실행
        Thread writerThread = new Thread(new FileWriterTask(OUTPUT_FILE));
        writerThread.start();
    }
}