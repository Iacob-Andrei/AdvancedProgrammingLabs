package testClasses;

import annotations.Test;

public class TestClass {

    @Test
    public static void test1(){
        System.out.println("This is first test!");
    }

    @Test
    public static void test2(){
        System.out.println("This is the second test! :)");
    }

    public static void test3(){
        System.out.println("Third test, should be called in homework!");
    }

    @Test
    public static void test4(String name){
        System.out.println("Hello, " + name);
    }
}
