package calculator.view;

import java.math.BigInteger;

public class OutputView {
    private static final String OUTPUT_MSG = "결과 : ";

    public void printOutput(BigInteger sum) {
        System.out.println(OUTPUT_MSG + sum);
    }
}
