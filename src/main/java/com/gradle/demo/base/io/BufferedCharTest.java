package com.gradle.demo.base.io;

import java.io.*;

/**
 * @author guxc
 * @date 2020/6/6
 */
public class BufferedCharTest {

    private static final int LEN = 5;

    private static final char[] ARRAYS_LETTER = new char[]
            {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    private static final String FILE = "bufferedChar.txt";

    public static void main(String[] args) throws IOException {
        testBufferedWriter();
        testBufferedReader();
    }

    // 缓冲写入
    private static void testBufferedWriter() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE));
        // 写入10个字符
        writer.write(ARRAYS_LETTER, 0, 30);
        writer.write('\n');

        writer.flush();
        writer.close();
    }

    private static void testBufferedReader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE));

        for (int i = 0; i < LEN; i++) {
            if (reader.ready()) {
                // 读取字符流的下一个字符
                int tmp = reader.read();
                System.out.printf("%d, %c\n", i, tmp);
            }
        }

        if (!reader.markSupported()) {
            return;
        }

        // 标记第6个字符
        reader.mark(1024);

        // 跳过22个字符
        reader.skip(22);

        char[] buf = new char[LEN];
        reader.read(buf, 0 , LEN);
        System.out.printf("buf=%s\n", String.valueOf(buf));

        System.out.printf("readLine = %s \n" , reader.readLine());

        // 重新回到第六个字符处
        reader.reset();

        reader.read(buf, 0, LEN);
        System.out.printf("buf=%s\n",String.valueOf(buf));
        reader.close();
    }


}
