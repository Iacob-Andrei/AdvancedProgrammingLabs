package solution;

import loadAndExecute.LoadAndExecuteCompulsory;

public class CompulsoryMain {

    public static void main(String[] args) {
        String path = "E:\\Codes\\AdvancedProgrammingLabs\\Lab12\\target\\classes";
        String file = "testClasses.TestClass";

        LoadAndExecuteCompulsory loadAndExecuteCompulsory = new LoadAndExecuteCompulsory(path, file);
        loadAndExecuteCompulsory.execute();
    }
}
