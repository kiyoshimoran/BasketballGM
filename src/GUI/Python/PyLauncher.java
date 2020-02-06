package GUI.Python;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PyLauncher {
    Process mProcess;
    Process p;

    public PyLauncher() {
    }

    public void doStuff()
    {
        System.out.println("running pylauncher");
        try {
            String prg = "python ..\\..\\..\\dataVisualizer.py";
            System.out.println(prg);
            System.out.println("launching python");
            ProcessBuilder pb = new ProcessBuilder("python", "dataVisualizer.py");
            pb.start();
            System.out.println("after start");
        }
        catch(IOException e)
        {
            System.out.println("PyLauncher: " + e);
        }
    }

    public void runScript(){
        Process process;
        try{
            process = Runtime.getRuntime().exec(new String[]{"C:\\Python36\\python C:\\Users\\kiyos\\Documents\\My shit\\BasketballGM\\dataVisualizer.py","arg1","arg2"});
            mProcess = process;
        }catch(Exception e) {
            System.out.println("Exception Raised " + e.toString());
        }
        InputStream stdout = mProcess.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdout,StandardCharsets.UTF_8));
        String line;
        try{
            while((line = reader.readLine()) != null){
                System.out.println("stdout: "+ line);
            }
        }catch(IOException e){
            System.out.println("Exception in reading output"+ e.toString());
        }
    }
}
