package Controller;
import Model.file;
import View.Menu;

import java.util.Scanner;

public class filePathController extends Menu{

    @Override
    public void execute(int choice){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file path: ");
        String filePath = scanner.nextLine();
        scanner.close();

        file fileModel = new file(filePath);

        // Print info to screen
        if (fileModel.getDiskDriver() != null) {
            System.out.println("Disk driver: " + fileModel.getDiskDriver());
            System.out.println("File name: " + fileModel.getFileName());
            System.out.println("File extension: " + fileModel.getFileExtension());
            System.out.println("Folders name: " + fileModel.getFolderName());
            System.out.println("Path to file folder: " + fileModel.getPathToFile());
        }
    }

}
