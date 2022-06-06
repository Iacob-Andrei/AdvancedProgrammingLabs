package customJavaP;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CustomJavaP {
    public static void show(Class<?> dynamicClass) {

        System.out.println("Fields of class");

        for (Field field : dynamicClass.getDeclaredFields()) {
            System.out.println(field);
        }

        System.out.println("\nConstructors of class");

        for (Constructor<?> constructor : dynamicClass.getDeclaredConstructors()) {
            System.out.println(constructor);
        }

        System.out.println("\nMethods of class");
        for (Method method : dynamicClass.getDeclaredMethods()) {
            System.out.println(method);
        }

        System.out.println();
    }
}
