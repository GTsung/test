package com.gradle.demo.base.io.serializa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.*;

/**
 * 静态属性及transient修饰的属性均不能序列化
 * @date 2020/5/28
 */
public class SerialTest2 {

    private static final String FILE_NAME = "serialTest2.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        testWrite();
        testRead();
    }

    private static void testWrite() throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        Box box = Box.builder().name("box").length(1).build();
        outputStream.writeObject(box);
        System.out.println("box" + box);
        outputStream.close();
    }

    private static void testRead() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME));
        Box box = (Box) inputStream.readObject();
        System.out.println(box); // 读取的Box(name=box, length=null)
        inputStream.close();
    }
}

@Data
@Builder
@ToString
@AllArgsConstructor
class Box implements Serializable {
    private static Integer color = 0;
    private String name;
    private transient Integer length;

    // 以下两种方法对transient修饰的属性可进行序列化
//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.defaultWriteObject();
//        out.writeInt(length);
//    }

//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        in.defaultReadObject();
//        length = in.readInt();
//    }
}
