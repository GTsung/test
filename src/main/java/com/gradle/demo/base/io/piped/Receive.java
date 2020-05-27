package com.gradle.demo.base.io.piped;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 接收者线程
 * @date 2020/5/27
 */
public class Receive extends Thread {

    // 管道输入流对象，和管道输出流对象绑定来接收管道输出流的数据，再让用户读取数据
    private PipedInputStream pipedInputStream = new PipedInputStream();

    public PipedInputStream getPipedInputStream() {
        return pipedInputStream;
    }

    @Override
    public void run() {
        readMessageOnce();
//        readMessageContinued();
    }

    // 从管道中读取1次数据
    public void readMessageOnce() {
        // 虽然此处大小为2048，但读取时最多1024字节
        // 管道输入流默认容量为1024个字节
        byte[] buf = new byte[2048];
        try {
            int len = pipedInputStream.read(buf);
            System.out.println(new String(buf, 0 , len));
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessageContinued() {
        byte[] buf = new byte[1024];
        int totle = 0;
        while(true) {
            try {
                int len = pipedInputStream.read(buf);
                totle += len;
                System.out.println(new String(buf, 0 , len));
                // 若读取超过1024个字节则退出
                if (totle > 1024) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
