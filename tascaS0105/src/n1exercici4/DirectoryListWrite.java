package n1exercici4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OCuevas
 */
public class DirectoryListWrite {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: DirectoryList <dir>");
        }

        String result = args[0];
        File file = new File(result);
        File fileTxt = new File("fileTxt.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(fileTxt);
            writeFilesNameInTxt(file, fileWriter);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(DirectoryListWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
        readTxtFiles(fileTxt);
    }

    public static void writeFilesNameInTxt(File file, FileWriter fileWriter) throws IOException {

        if (file.exists()) {
            File[] directorys = file.listFiles();
            Arrays.sort(directorys);

            for (int i = 0; i < directorys.length; i++) {

                String type = (directorys[i].isDirectory()) ? "D" : "F";
                java.util.Date dateModify = new java.util.Date(directorys[i].lastModified());

                String line = type + "-" + directorys[i].getName() + " Modification Date " + dateModify.toString() + "\n";
                fileWriter.write(line);
                if (directorys[i].isDirectory()) {
                    fileWriter.write("------Subdirectory--------\n");
                    writeFilesNameInTxt(directorys[i], fileWriter);
                    fileWriter.write("---------------------------\n");
                }

            }

        } else {
            System.out.println("This address does not contain directories.");
        }

    }

    public static void readTxtFiles(File fileTxt) {

        FileReader fr = null;
        BufferedReader br = null;

        try {

            fr = new FileReader(fileTxt);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
