package HomeWork5;

import java.util.List;
import java.util.ArrayList;

class toList
{
    public static <T> List<T> convertToList(T[] arr)
    {
        List<T> list = new ArrayList<>();

        for (T i: arr) {
            list.add(i);
        }

        return list;
    }

    public static void main(String[] args)
    {
        String[] str = { "A", "B", "C", "D" };

        List<String> list = convertToList(str);

        System.out.println(list);
    }
}
