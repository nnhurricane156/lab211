package Model;

import java.io.File;

public class file {
    private String diskDriver;
    private String fileName;
    private String fileExtension;
    private String folderName;
    private String pathToFile;


    public file(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        // Disk driver
        this.diskDriver = file.toPath().getRoot().toString();

        // File name
        this.fileName = file.getName();

        // File extension
        this.fileExtension = "";
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex != -1) {
            this.fileExtension = fileName.substring(dotIndex + 1);
        }

        // Folders name
        this.folderName = file.getParent();
        if (folderName == null) {
            this.folderName = "This file is located in the root directory.";
        }

        // Path to file folder
        this.pathToFile = file.getParentFile().getAbsolutePath();
    }

    public String getDiskDriver() {
        return diskDriver;
    }

    public void setDiskDriver(String diskDrive) {
        this.diskDriver = diskDrive;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }
}
