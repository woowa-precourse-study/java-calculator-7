package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] officialSign = new String[]{",", ":"};
        String[] customSign = new String[]{"//", "\\n"};


        System.out.println("덧셈할 문자열을 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        StringBuilder input = new StringBuilder();
        try {
            input = new StringBuilder(br.readLine());

            // 1) "// ~ \n" 세트는 우선 전부 공백으로 치환 (검증에서 제외)
            String temp = input.toString().replaceAll("//.*?\\\\n", " ");

            // 2) 이제 숫자, ',', ':' 만 남아야 함
            if (!temp.matches("[0-9,: ]+")) {
                throw new IllegalArgumentException("허용되지 않은 문자가 포함되어 있습니다: " + input);
            }


        } catch (IOException | IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
            return;
        }


        for (int i = 0; i < 3; i++) {
            String[] parts;
            if (i == 2) {
                parts = input.toString().split("//.*?\\\\\\\\n");
                input = new StringBuilder();
                for (String part : parts) {
                    if (part.matches("\\d+")) { // 숫자인 경우만
                        result += Integer.parseInt(part);
                    }
                }
            } else {
                parts = input.toString().split(officialSign[i]);
                input = new StringBuilder();
                for (String part : parts) {
                    if (part.matches("\\d+")) {
                        result += Integer.parseInt(part);
                        continue;
                    }
                    input.append(part);
                }
            }

        }


        System.out.println(result);
    }
}
