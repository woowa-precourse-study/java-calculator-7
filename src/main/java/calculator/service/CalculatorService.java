package calculator.service;

import calculator.domain.Delimeter;
import calculator.domain.Numbers;
import calculator.exception.Validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    public int calculateTotal(String message) {
        Delimeter delimeter = new Delimeter();
        message = parsingMessage(message, delimeter);
        List<String> nums = List.of(message.split(delimeter.getTotalDelimeter()));
        Numbers numbers = new Numbers(nums);
        return numbers.getSum();
    }

    private static String parsingMessage(String message, Delimeter delimeter) {
        Pattern pattern = Pattern.compile("//[\\S{1}]\\\\n");
        while (!message.isBlank()) {
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                Validator.validateInputFormat(matcher);
                delimeter.addCustomDelimeter(String.valueOf(matcher.group().charAt(2)));
                message = message.substring(5);
                continue;
            }
            break;
        }
        return message;
    }

}
