package com.gradle.demo.base.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author guxc
 * @date 2020/5/26
 */
public class ByteArrayOutputStreamTest {

    private static final int LEN = 5;

    // 对应英文字母“abcddefghijklmnopqrsttuvwxyz”
    private static final byte[] ArrayLetters = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
    };

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        // 可指定容量
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(0x41); // A
        outputStream.write(0x42); // B
        outputStream.write(0x43); // C
        // write是将字节或者字节数组写入到输出流中
        System.out.printf("outputStream=%s\n", outputStream); // ABC

        // 从数组第4个位置写入6个长度
        outputStream.write(ArrayLetters, 3, 6);
        System.out.printf("outputStream=%s\n", outputStream);

        int size = outputStream.size();
        System.out.println(size); // 长度

        byte[] bytes = outputStream.toByteArray();
        String str = new String(bytes);
        System.out.printf("str=%s\n", str);

        try {
            // 写入到另一个输出流
            ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
            outputStream.writeTo(outputStream2);
            System.out.printf("outputStream2=%s\n", outputStream2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

