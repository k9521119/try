import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintWriter;

/**
 * Created on 2017/2/24.
 */
public class FileNameSelector implements FilenameFilter {
    String extension = ".";

    public FileNameSelector(String fileExtensionNoDot) {
        extension += fileExtensionNoDot;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(extension);
    }

    public static void main(String[] args) throws Exception {
        File directory = new File(".");
//        System.out.println(directory);

        /**
        // List all the files in directory
        File[] files = directory.listFiles();
        System.out.println("\n目录" + directory.getName() + "下的所有文件:");
        for (File file : files) {
            System.out.print(file.getName() + "\n");
        }
         */

        File txtFileList = new File("txtFileList.txt");
        // Create a file to save the txt file list
        PrintWriter output = new PrintWriter(txtFileList);

        // List all the txt files in directory
        File[] txtFiles = directory.listFiles(new FileNameSelector("txt"));
//        System.out.println("\n当前目录下的所有txt文件:");
        for (File file : txtFiles) {
//            System.out.print(file.getName() + "\n");
            output.write(file.getName() + "\r\n");
        }

        // Close file
        output.close();
    }
}
