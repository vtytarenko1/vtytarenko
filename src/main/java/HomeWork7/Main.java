package HomeWork7;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        taskOne();
//        taskTwo();
        taskThree();

    }

    public static void taskOne() {

        Integer[] iArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0};
        String[] sArray = {" one ", " two ", " three ", " four ", " five ", " six ", " seven "};
        try {
            swapTwoElementsInArray(iArray, 0, 2);
            swapTwoElementsInArray(dArray, 0, 2);
            swapTwoElementsInArray(sArray, 0, 2);
        } catch (WrongPositionException e) {
            e.printStackTrace();
        }
        System.out.println("Swap result in integer array: " + Arrays.toString(iArray));
        System.out.println("Swap result in double array: " + Arrays.toString(dArray));
        System.out.println("Swap result in string array: " + Arrays.toString(sArray));
    }

    public static void taskTwo() {
        Integer[] iArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0};
        String[] sArray = {"one", "two", "three", "four", "five"};
        arrayToArrayList(iArray);
        arrayToArrayList(dArray);
        arrayToArrayList(sArray);
        System.out.println(Arrays.toString(iArray));
        System.out.println(Arrays.toString(dArray));
        System.out.println(Arrays.toString(sArray));
    }

    public static void taskThree() {
        Box<Apple> boxWithApple = new Box<>(new Apple(), new Apple(), new Apple()); //picking apples in box
        Box<Orange> boxWithOranges = new Box<>(new Orange(), new Orange()); //picking apples in box
        Box<Orange> anotherBoxWithOranges = new Box<>();
        System.out.println("A box of apples weighs " + boxWithApple.getWeight()); //weight box with apples
        System.out.println("A box of oranges weight " + boxWithOranges.getWeight()); //weight box with apples
        System.out.println(boxWithApple.compare(boxWithOranges));
        boxWithOranges.replaceFruitsToAnotherBox(anotherBoxWithOranges);
        System.out.println(boxWithOranges.getBox());
        System.out.println(anotherBoxWithOranges.getBox());
    }

//          это я просто баловался для первого задания, для решения задачи не подходит...
//          или подходит но я знаю как ксорить int только))))
//        try {
//            swapTwoNumbersInArray(iArray, 4, 7);
//        } catch (WrongPositionException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Arrays.toString(iArray));

    private static void swapTwoNumbersInArray(int[] array, int firstNumberPos, int secondNumberPos) throws WrongPositionException {
        if (firstNumberPos < 0 || firstNumberPos > array.length ||
                secondNumberPos < 0 || secondNumberPos > array.length || firstNumberPos == secondNumberPos) {
            throw new WrongPositionException("Неправильно указаны позиции элементов для замены");
        }
        array[firstNumberPos] ^= array[secondNumberPos];
        array[secondNumberPos] ^= array[firstNumberPos];
        array[firstNumberPos] ^= array[secondNumberPos];
    }

    private static void swapTwoElementsInArray(Object[] array, int firstNumPos, int secondNumPos) throws WrongPositionException {
        if (firstNumPos < 0 || firstNumPos > array.length ||
                secondNumPos < 0 || secondNumPos > array.length || firstNumPos == secondNumPos) {
            throw new WrongPositionException("Неправильно указаны позиции элементов для замены");
        }
        Object temp = array[firstNumPos];
        array[firstNumPos] = array[secondNumPos];
        array[secondNumPos] = temp;
    }

    private static <T> ArrayList arrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
