package HomeWork5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class countOccurance {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("ONE" + "ONE" + "ONE");
        items.add("TWO");
        items.add("THREE");
        items.add("ONE");

        ListIterator<String> listIterator = items.listIterator();
        while (listIterator.hasNext()) {
            //String nextWithIndex = items.get(listIterator.nextIndex());
            String next = listIterator.next();
            if ("ONE".equals(next)) {
                listIterator.set("SWAPPED");
            }
        }

        Iterator<String> iter = items.iterator();
        while (iter.hasNext()) {
            String next = iter.next();
            System.out.println("1: " + next);
        }


        listIterator.forEachRemaining(System.out::println);
    }

}

