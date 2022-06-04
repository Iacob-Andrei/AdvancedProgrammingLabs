package loadAndExecute;

import annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class LoadAndExecuteCompulsory {

    private final String path;
    private final String fileName;

    public LoadAndExecuteCompulsory(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    public Class load(){
        try{
            URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{
                    new URL("file:///" + path)
            }, this.getClass().getClassLoader());

            return urlClassLoader.loadClass(fileName);
        } catch (MalformedURLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void execute(){
        Class loadedClass = load();

        System.out.println("Package: " + loadedClass.getPackageName());
        System.out.println("Methods: " + Arrays.toString(loadedClass.getMethods()));

        int countInvoked = 0;
        for(Method method : loadedClass.getMethods()){
            if( method.isAnnotationPresent(Test.class) && method.getParameterCount() == 0 ){
                try{
                    method.invoke(null);
                    countInvoked++;
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(countInvoked + " methods invoked.");
    }
}
