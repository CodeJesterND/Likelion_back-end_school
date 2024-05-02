package com.exam.day06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOExam02 {
    public static void main(String[] args) {
       //문자열을 파일에다가 출력하는 코드 작성
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            String output = "hello, world!!";
            fos.write(output.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
