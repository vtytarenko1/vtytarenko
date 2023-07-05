package HomeWork5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class findUnique {
    public static int singleElement(int[] arr)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int freq = map.getOrDefault(arr[i], 0);
            map.put(arr[i], freq + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return arr[i];
            }
        }
        return -1; // indicates no unique element found
    }

    public static void main(String[] args)
    {
        int[] arr = { 2, 2, 3, 5, 4, 5, 3, 4, 5, 6 };
        Arrays.sort(arr);
        int single = singleElement(arr);
        if (single == -1) {
            System.out.println("No unique element found");
        }
        else {
            System.out.println("Unique element: " + single);
        }
    }
}
