package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers = new ArrayList<>();

    public Numbers(List<String> nums){
        for (String num:nums){
            numbers.add(new Number(num));
        }
    }

    public int getSum(){
        int total=0;
        for (Number number:numbers){
            total+=number.getNumber();
        }
        return total;
    }


}
