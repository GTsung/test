package com.gradle.demo.base.io;

import java.io.*;

/**
 * @author guxc
 * @date 2020/5/20
 */
public class ByteArrayInputStreamTest {
    private static final int LEN = 5;

    // 对应英文字母“abcddefghijklmnopqrsttuvwxyz”
    private static final byte[] ArrayLetters = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
    };

    public static void main(String[] args) throws IOException {
//        readTest();
        testByteArrayInputStream();
    }

    private static void readTest() throws IOException {
        char c;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("q end");
        do {
            c = (char) reader.read();
            System.out.println(c);
        } while (c != 'q');
    }

    // byteArrayInputStream
    private static void testByteArrayInputStream() throws IOException {
        // 创建字节流，内容为ArrayLetters字节数组
        ByteArrayInputStream byteArray = new ByteArrayInputStream(ArrayLetters);

        for (int i = 0; i < LEN; i++) {
            // 若能继续读下一字节
            if (byteArray.available() >= 0) {
                int tmp = byteArray.read();
                System.out.println(tmp + " " + (byte)tmp);
                System.out.printf("%d : 0x%s\n", i, Integer.toHexString(tmp));
            }
        }

        // 该流是否支持标记
        if (!byteArray.markSupported()) {
            System.out.println("mark is not supported");
            return;
        }

        // 参数无实际意义，标记字节流下一个被读取的位置，即标记0x66，
        // mark与reset配套，reset方法pos = mark; 即将下一个读取的位置置为mark中标记的位置
        byteArray.mark(0);

        byteArray.skip(5); // 跳过五个字节

        byte[] buf = new byte[LEN];
        // read(byte[], offset, len);将流中内容写入byte数组
        byteArray.read(buf, 0 , LEN);
        String s1 = new String(buf);
        System.out.printf("s1=%s\n", s1); // klmno

        // reset将下一个读取的位置置为mark标记的位置
        byteArray.reset();
        byteArray.read(buf, 0 , LEN);
        String s2 = new String(buf);
        System.out.printf("s2=%s\n", s2); // fghij
    }
}
