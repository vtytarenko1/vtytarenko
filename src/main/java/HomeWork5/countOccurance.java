package HomeWork5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class countOccurance {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("I");
        items.add("TRIED");
        items.add("TO");
        items.add("DO");
        items.add("THIS");
        items.add("PART");
        items.add("FOR");
        items.add("TWO");
        items.add("DAYS");
        items.add("AND");
        items.add("NOTHING");
        items.add("WORKED");

        Iterator<String> iter = items.iterator();
        while (iter.hasNext()) {
            String next = iter.next();
            System.out.println("1: " + next);
        }


    }
}
