package com.gradle.demo.base.io.cpiped;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * @author guxc
 * @date 2020/6/5
 */
public class CSender extends Thread {

    private PipedWriter pipedWriter = new PipedWriter();

    public PipedWriter getPipedWriter() {
        return pipedWriter;
    }

    @Override
    public void run() {
        writerShort();
//        writerLong();
    }

    private void writerShort() {
        String msg = "this is a short message";
        try {
            pipedWriter.write(msg.toCharArray());
            pipedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writerLong() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 102; i++) {
            sb.append("1234567890");
        }
        sb.append("abcdefghijklmnopqrstuvwxyz");
        String str = sb.toString();
        try {
            pipedWriter.write(str);
            pipedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
