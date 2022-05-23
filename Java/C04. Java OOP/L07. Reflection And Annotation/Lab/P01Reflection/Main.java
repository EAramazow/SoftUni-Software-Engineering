package L07ReflectionAndAnnotation.Lab.P01Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class; // take the class

        System.out.println(clazz);

        System.out.println(clazz.getSuperclass());

        try {

            Arrays.stream(clazz.getInterfaces())
                    .forEach(System.out::println);


            Constructor<Reflection> constructor = clazz.getDeclaredConstructor();

            constructor.setAccessible(true);

            Reflection reflection = constructor.newInstance();

            System.out.println(reflection);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException ex) {

            ex.printStackTrace();
        }

    }

}
