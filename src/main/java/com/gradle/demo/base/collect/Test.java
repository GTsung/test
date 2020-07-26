package com.gradle.demo.base.collect;

/**
 * @author guxc
 * @date 2020/6/28
 */
public class Test{
    public static void main(String[] args) {
        // 只输出了supperClass init,表明当子类调用父类的静态属性时只有父类初始化，而子类并没有初始化
//        System.out.println(SubClass.value);

        // 数组定义来引用类，不会触发此类的初始化
//        SupperClass[] sca = new SupperClass[10];
        // 调用常量不会触发定义常量类的初始化
        System.out.println(ConstClass.HELLO_WORLD);
    }
}
class ConstClass{
    static {
        System.out.println("ConstClass init");
    }
    public static final String HELLO_WORLD = "HELLO WORLD";
}
class SupperClass {
    static{
        System.out.println("SuperClass init");
    }
    public static int value = 123;
}
class SubClass extends SupperClass {
    static{
        System.out.println("subClass init");
    }
}
