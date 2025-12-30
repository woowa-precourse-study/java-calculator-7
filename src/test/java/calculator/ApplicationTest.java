package calculator;

import calculator.domain.Delimeter;
import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @DisplayName("사용자 지정 구분자 파싱 테스트")
    @Test
    void parsingMessage() {
        Delimeter delimiter = new Delimeter();
        CalculatorService service = new CalculatorService();

        String result = service.parsingMessage("//;\\n1;2", delimiter);

        assertThat(result).isEqualTo("1;2");
        assertThat(delimiter.getTotalDelimeter()).contains(";");
    }

    @DisplayName("합 구하기 테스트")
    @Test
    void calculateTotal(){


    }


    @Test
    void 정상_테스트_구분자_하나()  {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 정상_테스트_숫자빈칸()  {
        assertSimpleTest(() -> {
            run("//)\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 정상_테스트_구분자_둘()  {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 정상_테스트_빈문자열_둘()  {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }




    @Test
    void 정상_지정_구분자_구분자_둘()  {
        assertSimpleTest(() -> {
            run("//)\\n//;\\n1)2,3:4;5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 사용자_지정_구분자_괄호()  {
        assertSimpleTest(() -> {
            run("//)\\n1)2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 사용자_지정_구분자_별()  {
        assertSimpleTest(() -> {
            run("//*\\n1*2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }


    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 정의되지않은_구분자_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1.2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n1;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
