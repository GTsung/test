package com.gradle.demo.base.io;

import java.io.*;

/**
 * @author guxc
 * @date 2020/6/6
 */
public class StreamByteToCharTest {

    private static final String FILE = "byte2char.txt";

    private static final String CHARSET_NAME = "utf-8";

    public static void main(String[] args) throws IOException {
        testWrite();
        testRead();
    }

    private static void testWrite() throws IOException {
        // 将字节流转换为字符流
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(FILE), CHARSET_NAME);
        writer.write("write char");
        writer.write("01211312313123123");
        writer.close();
    }

    private static void testRead() throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(FILE), CHARSET_NAME);
        char c = (char) reader.read();
        System.out.println("c=" + c);

        reader.skip(3);

        char[] buf = new char[34];
        reader.read(buf, 0, buf.length);
        System.out.println("buf="+new String(buf));
    }
}
