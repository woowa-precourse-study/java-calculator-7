package calculator.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operands {
    private final List<Operand> operands;

    public Operands(String[] elements) {
        this.operands = Stream.of(elements)
                .filter(e -> !e.isBlank())
                .map(Operand::new)
                .collect(Collectors.toList());
    }

    public List<Operand> getOperands() {
        return operands;
    }
}
