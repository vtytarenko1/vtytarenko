package HomeWork6;

import java.io.File;

public class FileNavigator {

    public static void main(String[] args) {
        FileData fileSystem = new FileData("c:");
        File file = new File("List.txt");

        if (!file.exists() || !file.isFile() || file.length() == 0) {
            FileData file1 = new FileData("file1", true);
            FileData file2 = new FileData("file2", true);

            FileData dir1 = new FileData("dir1", false);
            FileData dir2 = new FileData("dir2", false);

            dir1.add(file1);
            dir2.add(file1);
            dir2.add(dir1);
            dir2.add(file2);

            dir1.add(file1);
            dir2.add(dir1);
            dir1.add(file1);
            file1.add(dir1);

            fileSystem.add(dir2);
            fileSystem.print();

            Filter.serialize(fileSystem, file);
        } else {
            fileSystem = (FileData) Filter.deserialize(file);
            fileSystem.print();
        }
    }
}
