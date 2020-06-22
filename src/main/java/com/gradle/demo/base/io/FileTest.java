package com.gradle.demo.base.io;

import java.io.File;
import java.io.IOException;

/**
 * @author guxc
 * @date 2020/5/28
 */
public class FileTest {

    public static void main(String[] args) {
        test3();
    }

    private static void test() {
        // 相对路径创建目录
        File file = new File("dir");
        file.mkdir();
        File file2 = new File("d:/dir");
        // 新建子目录
        File file3 = new File(file, "sub");
        file3.mkdir();

        // dir2也自动创建
        File file4 = new File("dir2/sub2");
        file4.mkdirs();
    }

    private static void test2() throws IOException {
        // 创建文件
        File dir = new File("dir");
        File file = new File(dir, "sub.txt");
        file.createNewFile();

        File file2 = new File("dir","sub2.txt");
        file2.createNewFile();

        // 绝对
        File file3 = new File("d:/dir/sub3.txt");
        file3.createNewFile();
    }

    private static void test3() {
        System.out.printf("File.pathSeparator=\"%s\"\n",File.pathSeparator);
        System.out.printf("File.pathSeparatorChar=\"%c\"\n",File.pathSeparatorChar);
        System.out.printf("File.separator=\"%s\"\n",File.separator);
        System.out.printf("File.separatorChar=\"%c\"\n",File.separatorChar);
    }
}
