package com.gradle.demo.base.io;

import java.io.*;

/**
 * @author guxc
 * @date 2020/6/5
 */
public class DataInputStreamTest {

    private static final int LEN = 5;

    public static void main(String[] args) {

    }

    private static void testOut() throws IOException {
        File file = new File("dFile.txt");
        DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
        out.writeBoolean(false);
        out.writeByte((byte)0x41);

    }
}
