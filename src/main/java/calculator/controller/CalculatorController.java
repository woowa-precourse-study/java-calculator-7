package calculator.controller;

import calculator.domain.Delimeter;
import calculator.domain.Numbers;
import calculator.service.CalculatorService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {
    private final InputView inputView;
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.inputView = new InputView();
        this.service = service;
    }

    public void run() {
        String names = inputView.readMessage();

        Delimeter delimeter=new Delimeter();

        Pattern pattern = Pattern.compile("//[\\S{1}]\\\\n");
        while(!names.isBlank()){
            Matcher matcher = pattern.matcher(names);
            if (matcher.find()){
                if (matcher.start( )!=0){
                    throw new IllegalArgumentException("[ERROR] 입력 형식이 올바르지 않습니다.");
                }
                delimeter.addCustomDelimeter(String.valueOf(matcher.group().charAt(2)));
                names=names.substring(5);
                continue;
            }
            break;
        }
        List<String> nums=List.of(names.split(delimeter.getTotalDelimeter()));
        Numbers numbers = new Numbers(nums);
        OutputView.printResult(numbers.getSum());

    }


}

