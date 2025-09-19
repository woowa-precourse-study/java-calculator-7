package calculator.io;

public class OutputView {
    private static final String RESULT_FORMAT = "결과 : %d";
    private static final String ERROR_FORMAT = "오류: %s";

    private OutputView() {
    }

    public static void printResult(int result) {
        System.out.println(String.format(RESULT_FORMAT, result));
    }

    public static void printError(String message) {
        System.out.println(String.format(ERROR_FORMAT, message));
    }
}
