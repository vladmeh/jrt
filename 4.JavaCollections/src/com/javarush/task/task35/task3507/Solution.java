package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        return null;
    }

    public static class MyClassLoader extends ClassLoader{
        public Class<?> load(Path path, String packageName) {
            try {
                String className = packageName + "." + path.getFileName().toString().replace(".class", "");
                byte[] b = Files.readAllBytes(path);
                return defineClass(className, b, 0, b.length); //here main magic
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
