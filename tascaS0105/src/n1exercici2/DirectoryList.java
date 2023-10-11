package n1exercici2;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

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
        showDirectory(file);

    }

    public static void showDirectory(File file) {
        if (file.exists()) {
            File[] directorys = file.listFiles();
            Arrays.sort(directorys);

            for (int i = 0; i < directorys.length; i++) {

                String type = (directorys[i].isDirectory()) ? "D" : "F";
                java.util.Date dateModify = new java.util.Date(directorys[i].lastModified());

                System.out.println(type + "-" + directorys[i].getName() + " Modification Date " + dateModify.toString() + "\n");
                if (directorys[i].isDirectory()) {
                    System.out.println("------Subdirectory-------\n");
                    showDirectory(directorys[i]);
                    System.out.println("---------------------------\n");
                }

            }

        } else {
            System.out.println("This address does not contain directories.");
        }
    }
}
