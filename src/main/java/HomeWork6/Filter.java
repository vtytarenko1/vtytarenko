package HomeWork6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Filter {

    public static void serialize(Object obj, File file) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            output.writeObject(obj);
        } catch (IOException ex) {
            System.out.println("ERROR save object!");
        }
    }

    public static void serialize(Object obj, String path) {
        serialize(obj, new File(path));
    }

    public static Object deserialize(File file) {
        Object obj = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
            obj = input.readObject();
        } catch (IOException | ClassNotFoundException | ExceptionInInitializerError ex) {
            System.out.println("ERROR load object!");
            file.delete();
        }

        return obj;
    }

    public static Object deserialize(String path) {
        return deserialize(new File(path));
    }
}
