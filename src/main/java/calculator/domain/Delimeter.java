package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Delimeter {
    private final List<String> defaultDelimeter= List.of(Pattern.quote(","),Pattern.quote(":"));
    private final List<String> customDelimeter=new ArrayList<>();

    public Delimeter(){
    }

    public void addCustomDelimeter(String delimeter){
        customDelimeter.add((Pattern.quote(delimeter)));
    }

    public String getTotalDelimeter(){
        List<String> mergedList = new ArrayList<>();
        mergedList.addAll(List.copyOf(defaultDelimeter));
        mergedList.addAll(List.copyOf(customDelimeter));
        return String.join("|",mergedList);
    }
}
