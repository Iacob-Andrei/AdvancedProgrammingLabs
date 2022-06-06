package solution;

import customCompiler.Compiler;
import loadAndExecute.LoadAndExecuteHomework;

import java.lang.reflect.InvocationTargetException;

public class BonusMain {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        String path = "E:\\Codes\\AdvancedProgrammingLabs\\Lab12\\src\\main\\java\\GlobalTestBonus.java";

        if(Compiler.compile(path)) {
            System.out.println("File Compiled!");
        }
        LoadAndExecuteHomework loadAndExecute = new LoadAndExecuteHomework("", "GlobalTestBonus");
        loadAndExecute.execute();
    }
}
