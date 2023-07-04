package phonebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {

    public static void serialize(Object obj, File file) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            output.writeObject(obj);
        }
    }

    public static void serialize(Object obj, String path) throws IOException {
        serialize(obj, new File(path));
    }

    public static Object deserialize(File file) throws IOException, ClassNotFoundException {
        Object obj = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
            obj = input.readObject();
        }
        return obj;
    }

    public static Object deserialize(String path) throws IOException, ClassNotFoundException {
        return deserialize(new File(path));
    }
}
