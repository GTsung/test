package com.gradle.demo.base.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guxc
 * @date 2020/5/27
 */
public class ObjectInputStreamTest {

    private static final String TMP_FILE = "box.tmp";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        testWrite();
        testRead();
    }

    private static void testWrite() throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
        outputStream.writeBoolean(true);
        outputStream.writeByte((byte)65);
        outputStream.writeChar('q');
        outputStream.writeInt(12121);
        outputStream.writeFloat(2.1F);
        outputStream.writeDouble(2.21D);

        Map<String, String> map = new HashMap<>();
        map.put("1","a");
        map.put("2","aa");
//        Map<String, String> map = ImmutableMap
        outputStream.writeObject(map);

        Box box = Box.builder().name("myBox").height(10).width(20).build();
        outputStream.writeObject(box);
        outputStream.close();
    }

    private static void testRead() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(TMP_FILE));
        System.out.printf("boolean:%b\n", inputStream.readBoolean());
        System.out.printf("byte:%d\n", inputStream.readByte());
        System.out.printf("char:%c\n", inputStream.readChar());
        System.out.printf("int:%d\n", inputStream.readInt());
        System.out.printf("float:%f\n", inputStream.readFloat());
        System.out.printf("double:%f\n", inputStream.readDouble());

        Map<String, String> map = (HashMap<String, String>)inputStream.readObject();
        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "==" + entry.getValue());
        }

        Box box = (Box) inputStream.readObject();
        System.out.println(box.toString());
        inputStream.close();
    }
}

@Data
@ToString
@Builder
@AllArgsConstructor
class Box implements Serializable {
    private String name;
    private int width;
    private int height;
}
