package com.gradle.demo.base.io;

import java.io.*;

/**
 * @author guxc
 * @date 2020/5/25
 */
public class FileInputStreamTest {

    private static final String FILE_NAME = "file.txt";

    // 对应英文字母“abcddefghijklmnopqrsttuvwxyz”
    private static final byte[] ArrayLetters = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
    };

    public static void main(String[] args) throws Exception {
        testWrite();
        testRead();
    }

    private static void testWrite() throws IOException {
//        FileOutputStream out = new FileOutputStream(FILE_NAME);
        File file = new File(FILE_NAME);
        FileOutputStream out = new FileOutputStream(file);
        out.write(ArrayLetters); // 生成文件，将字节数组写入到了输出流即文件中
        out.close();

        // 可追加
        FileOutputStream out2 = new FileOutputStream(file, true);
        PrintStream printStream = new PrintStream(out2);
        printStream.print("12345");
        printStream.close();
    }

    private static void testRead() throws IOException {
        FileInputStream in = new FileInputStream("file.txt");

        FileDescriptor descriptor = in.getFD(); // 获取文件描述符
        FileInputStream in2 = new FileInputStream(descriptor); // 根据文件描述符创建输入流
        // 读一个字节
        char c = (char)in2.read();
        System.out.println("c="+c);

        // 读入到字节数组
        byte[] bytes = new byte[10];
        in2.read(bytes,0,bytes.length);
        System.out.println(new String(bytes));

        BufferedInputStream inputStream = new BufferedInputStream(in2);
        char c2 = (char)inputStream.read();
        System.out.println(c2);

        in.close();
        in2.close();
        inputStream.close();
    }
}
