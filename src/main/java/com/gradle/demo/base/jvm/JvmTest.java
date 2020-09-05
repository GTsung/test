package com.gradle.demo.base.jvm;

/**
 * @author guxc
 * @date 2020/7/26
 */
public class JvmTest {
    static abstract class Human {}
    static class Man extends Human{}
    static class Woman extends Human{}
    public void sayHello(Human human) {
        System.out.println("hello human");
    }
    public void sayHello(Man man) {
        System.out.println("hello man");
    }
    public void sayHello(Woman woman) {
        System.out.println("hello woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        JvmTest test = new JvmTest();
        // java编译器选择静态类型而非实际类型来调用重载方法，即静态分派
        test.sayHello(man); // hello human
        test.sayHello(woman); // hello human
    }
}
