package com.gradle.demo.base.io.serializa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.*;

/**
 * 序列化与反序列化
 * 序列化指保存对象的状态，反序列化指将对象状态读出来
 * 1.将对象写入到文件或者数据库
 * 2.用套接字在网络上传送对象
 * 3.提供RMI传输对象
 * @date 2020/5/28
 */
public class SerialTest {

    private static final String FILE_NAME ="serialTest1.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        testWriter();
        testRead();
    }

    private static void testWriter() throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        Box1 box = Box1.builder().color(1).length(1).name("box1").build();
        outputStream.writeObject(box);
        System.out.println("box1="+ box);
        outputStream.close();
    }

    private static void testRead() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME));
        Box1 box = (Box1) inputStream.readObject();
        System.out.println("box1="+ box);
        inputStream.close();
    }
}

@Data
@Builder
@ToString
@AllArgsConstructor
class Box1 implements Serializable {
    private Integer color;
    private String name;
    private Integer length;
}
