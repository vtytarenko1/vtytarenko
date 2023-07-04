package HomeWork4;

public class Main {
    public static void main(String[] args) {
        String[][] inputArray = {
                {"1", "1", "1", "1"},
                {"2", "invalid 1", "2", "2"},
                {"invalid 2", "3", "3", "3"},
                {"4", "4", "invalid 3", "4"}
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
