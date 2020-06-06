package com.gradle.demo.base.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author guxc
 * @date 2020/6/6
 */
public class FileReaderWriterTest {

    private static final String FILE = "fileReaderOrWriter.txt";

    public static void main(String[] args) throws IOException {
        writer();
        reader();
    }

    private static void writer() throws IOException {
        // FileWriter extends OutputStreamWriter
        FileWriter writer = new FileWriter(FILE);
        writer.write("kaoyao");
        writer.write("121231231231");
        writer.close();
    }

    private static void reader() throws IOException {
        FileReader reader = new FileReader(FILE);
        char c = (char) reader.read();
        System.out.println("c="+c);

        char[] buf = new char[20];
        reader.read(buf, 0 ,10);
        System.out.println("buf=" + new String(buf));
    }
}
