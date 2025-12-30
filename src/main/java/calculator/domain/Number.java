package calculator.domain;

public class Number {
    private final int number;

    public Number(String num){
        int number=validateIsNumber(num);
        validatePositiveNumber(number);
        this.number=number;
    }


    private int validateIsNumber(String input) {
        try{
            return Integer.parseInt(input);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void validatePositiveNumber(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    public int getNumber(){
        return number;
    }



}
