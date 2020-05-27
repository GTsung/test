package com.gradle.demo.base.io.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author guxc
 * @date 2020/5/27
 */
public class Sender extends Thread {

    // 管道输出流，与管道输入流绑定，从而使数据发送给对应的输入流，使用户可以从输入流中读取数据
    private PipedOutputStream outputStream = new PipedOutputStream();

    public PipedOutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public void run() {
//        writeShortMessage();
        writeLongMessage();
    }

    public void writeShortMessage() {
        String msg = "This is a short msg.";
        try {
            // 将数据写入到输出流
            // PipedOutputStream.write中会调用PipedInputStream.receive将数据存储到管道输入流的缓冲区
            outputStream.write(msg.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLongMessage() {
        StringBuilder builder = new StringBuilder();
        // 写1020个字节
        for (int i=0; i<102;i++) {
            builder.append("1234567890");
        }
        // 写入26个字节
        builder.append("abcdefghijklmnopqrstuvwxyz");
        String str = builder.toString();

        try {
            // 写入输出流
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
