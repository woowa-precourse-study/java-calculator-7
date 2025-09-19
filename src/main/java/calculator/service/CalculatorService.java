package calculator.service;

public class CalculatorService {
  public static int calculate(int[] numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return sum;
  }
}
