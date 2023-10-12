package n1exercici1;

import java.io.File;
import java.util.Arrays;

/**
 *
 * @author OCuevas
 */
public class DirectoryList {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: DirectoryList <dir>");
        }
        
        String result = args[0];
        File file = new File(result);
        if (file.isDirectory()) {
            File[] directorys = file.listFiles();
            Arrays.sort(directorys);
            for (File directory : directorys) {
                System.out.println(directory.getName());
            }
        } else {
            System.out.println("This address does not contain directories.");
        }

    }
}
