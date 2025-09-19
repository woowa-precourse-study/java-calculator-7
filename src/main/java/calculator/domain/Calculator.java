package calculator.domain;

import java.math.BigInteger;

public class Calculator {
    private final Operands operands;

    public Calculator(String inputString) {
        Separator separator = new Separator(inputString);
        String[] splitInput = separator.split(inputString);
        this.operands = new Operands(splitInput);
    }

    public BigInteger sum() {
        return operands.getOperands().stream()
                .map(Operand::getValue)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
