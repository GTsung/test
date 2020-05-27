package com.gradle.demo.base.io.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author guxc
 * @date 2020/5/27
 */
public class PipedInputStreamTest {

    public static void main(String[] args) throws IOException {
        Sender sender = new Sender();
        Receive receive = new Receive();

        PipedOutputStream outputStream = sender.getOutputStream();
        PipedInputStream inputStream = receive.getPipedInputStream();

        // 关联管道输出流与输入流
        inputStream.connect(outputStream);
//        outputStream.connect(inputStream);

        sender.start(); // 开始写入
        receive.start(); // 将输出流写入的数据接收并读出
    }

}
