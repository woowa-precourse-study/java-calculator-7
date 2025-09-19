package calculator.domain;

import java.math.BigInteger;

public class Operand {
    private final BigInteger value;

    public Operand(String element) {
        this.value = parse(element);
        validatePositive(this.value);
    }

    public BigInteger getValue() {
        return value;
    }

    private BigInteger parse(String element) {
        try {
            return new BigInteger(element.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되었습니다: " + element);
        }
    }

    private void validatePositive(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("[ERROR] 음수나 0은 허용되지 않습니다: " + value);
        }
    }
}
