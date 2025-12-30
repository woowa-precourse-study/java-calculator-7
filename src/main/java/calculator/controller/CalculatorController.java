package calculator.controller;

import calculator.service.CalculatorService;

import java.util.Arrays;
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
        String delimeters= String.join("|",List.of(Pattern.quote(","),Pattern.quote(":")));


        Pattern pattern = Pattern.compile("//[\\S{1}]\\\\n");
        while(!names.isBlank()){
            Matcher matcher = pattern.matcher(names);
            if (matcher.find()){
                if (matcher.start( )!=0){
                    throw new IllegalArgumentException("[ERROR] 입력 형식이 올바르지 않습니다.");
                }
                char customDelimeter = matcher.group().charAt(2);
                delimeters+="|"+Pattern.quote(String.valueOf(customDelimeter));
                names=names.substring(5);
                continue;
            }
            break;
        }



        int[] numbers = Arrays.stream(names.split(delimeters))
                .mapToInt(Integer::parseInt).toArray();
        for (int num:numbers){
            if (num<0){
                throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
            }
        }
        OutputView.printResult(Arrays.stream(numbers).sum());

    }


}

