package com.gradle.demo.base.io.cpiped;

import java.io.IOException;
import java.io.PipedReader;

/**
 * @author guxc
 * @date 2020/6/5
 */
public class CReceiver extends Thread {

    private PipedReader pipedReader = new PipedReader();

    public PipedReader getPipedReader() {
        return pipedReader;
    }

    @Override
    public void run() {
        readMessageOnce();

//        readMessageContinued();
    }

    public void readMessageOnce() {
        char[] buf = new char[2048];
        int len = 0;
        try {
            len = pipedReader.read(buf);
            System.out.println(new String(buf, 0, len));
            pipedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessageContinued() {
        int total = 0;
        while (true) {
            char[] buf = new char[1024];
            int len = 0;
            try {
                len = pipedReader.read(buf);
                total += len;
                System.out.println(new String(buf, 0, len));
                if (total > 1024) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            pipedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
