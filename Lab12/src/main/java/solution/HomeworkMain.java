package solution;

import loadAndExecute.LoadAndExecuteHomework;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class HomeworkMain {

    private static List<String> getClassNamesInFolder(String folderName) {
        File folder = new File(folderName);
        List<File> listOfFiles = List.of(Objects.requireNonNull(folder.listFiles()));

        List<String> classes = new LinkedList<>();

        for (File file : listOfFiles)
            if (file.isFile() && file.getName().endsWith(".class"))
                classes.add(file.getName());

        return classes;
    }

    private static List<String> getClassesNamesInJar(String pathToJar) {
        List<String> classes = new ArrayList<>();

        try {
            JarInputStream jarFile = new JarInputStream(new FileInputStream(pathToJar));
            JarEntry jarEntry;

            while (true) {
                jarEntry = jarFile.getNextJarEntry();
                if (jarEntry == null) {
                    break;
                }
                if (jarEntry.getName().endsWith(".class")) {
                    classes.add(jarEntry.getName().replaceAll("/", "\\."));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        String path = "E:\\Codes\\AdvancedProgrammingLabs\\Lab12\\target\\classes";

        List<String> classesInFolder = getClassNamesInFolder(path);
        for( String className : classesInFolder ){
            LoadAndExecuteHomework loadAndExecute = new LoadAndExecuteHomework(path, className.substring(0, className.length() - 6));
            loadAndExecute.execute();
        }
    }
}
