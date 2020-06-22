package com.gradle.demo.base.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * @author guxc
 * @date 2020/5/29
 */
public class CharArrayReaderTest {

    private static final int LEN = 5;

    private static final char[] ArrayLetters = new char[]
            {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void main(String[] args) throws IOException {
        testRead();
        testWriter();
    }

    private static void testRead() throws IOException {
        CharArrayReader reader = new CharArrayReader(ArrayLetters);

        for(int i=0; i<LEN; i++) {
            // 是否能继续读
            if (reader.ready()) {
                char temp = (char) reader.read();
                System.out.printf("%d, %c\n", i, temp);
            }
        }

        if(!reader.markSupported()) {
            return;
        }

        reader.mark(0);
        reader.skip(LEN);
        char[] buf=new char[LEN];
        reader.read(buf,0,LEN);
        System.out.printf("buf= %s\n",new String(buf));

        reader.reset();
        reader.read(buf,0,LEN);
        System.out.printf("buf= %s\n",String.valueOf(buf));

    }

    private static void testWriter() throws IOException {
        CharArrayWriter writer = new CharArrayWriter();

        writer.write('A');
        writer.write("BC");

        writer.write(ArrayLetters, 3,8);

        writer.append('a').append("12");
        System.out.printf("writer = %s\n", writer);

        System.out.println(writer.toCharArray());

        CharArrayWriter writer2 = new CharArrayWriter();
        writer.writeTo(writer2);
        System.out.println(writer);

    }
}
