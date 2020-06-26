package com.gradle.demo.base.extend;

/**
 * @author guxc
 * @date 2020/6/11
 */
public class TestExtends {

    public static void main(String[] args) {
        // 父类调用顺序：静态代码块>代码块>构造方法
//        Employee employee = new Employee();

        System.out.println("-------------");

        // 静态代码块只调用一次，employee在上面已经调用，故子类不再调用父类的静态代码块
        // 子类调用顺序，父类静态代码块>子类静态代码块>父类代码块>父类构造方法
        // >子类代码块>子类构造方法
        Manager manager = new Manager();

        Object obj = null;

        Integer i = null;
    }
}
