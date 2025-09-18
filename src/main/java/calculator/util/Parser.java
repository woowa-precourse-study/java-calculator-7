package calculator.util;

public class Parser {

  public static int[] parseStringToIntArray(String input) {
    String[] stringNumbers = input.split("[,:]");
    int[] targetNumbersInt = new int[stringNumbers.length];
    for (int i = 0; i < stringNumbers.length; i++) {
      targetNumbersInt[i] = Integer.parseInt(stringNumbers[i]);
    }
    return targetNumbersInt;
  }

}
