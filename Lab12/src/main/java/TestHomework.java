import annotations.Test;

public class TestHomework {

    public TestHomework(){
    }

    public TestHomework(int number){
    }

    @Test
    public static void test1(int number1, int number2){
        System.out.println("TEST 1");
        System.out.println(number1 + " + " + number2 + " = " + (number1 + number2) );
    }

    @Test
    public void test2(String name){
        System.out.println("TEST 2");
        System.out.println("Hello, " + name);
    }

    @Test
    public void test3(){
        System.out.println("TEST 3");
        System.out.println("No params method");
    }
}
