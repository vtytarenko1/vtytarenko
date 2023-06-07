package HomeWork_4;

public class Main {
    public static void main(String[] args) {
        String[][] inputArray = {
                {"1", "2", "3", "4"},
                {"5", "invalid 1", "6", "7"},
                {"invalid 2", "8", "9", "0"},
                {"1", "2", "invalid 3", "3"}
        };
        int sum = 0;
        try {
            ArrayValueCalculator calculator = new ArrayValueCalculator();
            sum = calculator.doCalc(inputArray);
        } catch (ArraySizeException | ArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
