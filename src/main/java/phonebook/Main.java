package phonebook;

public class Main {

    public static void main(String[] args) {
        String baseFile = "dateBase.txt";
        Menu menu = new Menu(baseFile);
        menu.show();
    }
}
