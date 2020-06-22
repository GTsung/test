package com.gradle.demo.base.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintStream;

/**
 * @author guxc
 * @date 2020/5/29
 */
public class BufferfdStreamTest {

    private static final Integer LEN = 5;

    public static void main(String[] args) {

    }

    private static void test() throws Exception {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(""));
        inputStream.read();

        PrintStream printStream = null;
    }
}
