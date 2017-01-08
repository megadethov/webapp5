package lesson6;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class FileMain {
    public static void main(String[] args) throws IOException {

        // var-1
       /* Stream<String> lines = Files.lines(Paths.get("c:\\VRayLog.txt"), StandardCharsets.UTF_8);
        Iterator<String> it = lines.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }Files*/

       // var-2
//        Files.lines(Paths.get("c:\\VRayLog.txt"), StandardCharsets.UTF_8).forEach(System.out::println);

        // var-3
        BufferedReader reader = new BufferedReader(new InputStreamReader((new FileInputStream("c:\\VRayLog.txt")), "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
