package customJavaP;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CustomJavaP {
    public static void show(Class<?> dynamicClass) {

        System.out.println("Fields of class");

        Field[] fields = dynamicClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("\nConstructors of class");

        Constructor<?>[] cons = dynamicClass.getDeclaredConstructors();
        for (Constructor<?> constructor : cons) {
            System.out.println(constructor);
        }

        System.out.println("\nMethods of class");

        Method[] methods = dynamicClass.getDeclaredMethods();
        for (Method method : methods)
            System.out.println(method);

        System.out.println();
    }
}
