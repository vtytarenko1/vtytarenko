package HomeWork4;

public class ArrayValueCalculator {
    public int doCalc(String[][] array) throws ArraySizeException {
        int sumOfElements = 0;
        int lengthInput = array.length;
        if (lengthInput != 4) {
            throw new ArraySizeException("Invalid array length: " + lengthInput);
        } else {
            for (String[] row : array) {
                if (row.length != 4) {
                    throw new ArraySizeException("Invalid array row length: " + row.length);
                }
            }
        }
        int rowCounter = 0;
        for (String[] row : array) {
            int columnCounter = 0;
            for (String value : row) {
                try {
                    sumOfElements += Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid value:" + " [" + rowCounter + "," + columnCounter + "]\n" + e);
                }
                columnCounter++;
            }
            rowCounter++;
        }
        return sumOfElements;
    }
}
