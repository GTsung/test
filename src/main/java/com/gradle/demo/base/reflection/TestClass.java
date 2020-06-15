package com.gradle.demo.base.reflection;

import java.lang.reflect.Field;

/**
 * @author guxc
 * @date 2020/6/6
 */
public class TestClass {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Animal animal = new Monkey();
        System.out.println(animal.getClass());
        System.out.println(Monkey.class);
        Class clazz = Class.forName("com.gradle.demo.base.reflection.Monkey");
        System.out.println(clazz);
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        String name = (String) field.get(animal);
        System.out.println(name);
        field.set(animal, "kaoyao");
        System.out.println(field.get(animal));

        byte b = 0b1;
        Byte.toUnsignedInt((byte) 0b1);
    }
}
