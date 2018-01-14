package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(
                Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath()
                        + Solution.class.getPackage().getName().replaceAll("[.]", "/")
                        + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> set = new HashSet<>();
        File[] list = new File(pathToAnimals).listFiles();

        System.out.println(pathToAnimals);
        if (list != null) {
            for (File file: list){
                String packageName = Solution.class.getPackage().getName() + ".data.";
                String className = packageName + file.getName().replace(".class", "");

                try {
                    Class clazz = new MyClassLoader(file.getPath()).findClass(className);
                    if (isAnimals(clazz) && isConstructor(clazz))
                        set.add((Animal) clazz.newInstance());

                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }

        return set;
    }

    private static boolean isAnimals(Class<?> clazz){
        Class<?>[] classes = clazz.getInterfaces();
        for (Class cl: classes)
            if (cl.getSimpleName().equals("Animal"))
                return true;

        return false;
    }

    private static boolean isConstructor(Class<?> clazz){
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor:constructors)
            if (constructor.getParameterCount() == 0)
                return true;

        return false;
    }

    public static class MyClassLoader extends ClassLoader{
        String path;

        MyClassLoader(String path) {
            this.path = path;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {

            try {
                byte[] b = Files.readAllBytes(Paths.get(this.path));
                return defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return super.findClass(name);
        }
    }
}
