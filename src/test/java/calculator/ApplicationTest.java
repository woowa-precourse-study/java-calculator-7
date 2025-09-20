package calculator;

import calculator.dto.ParsedResult;
import calculator.util.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {

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
  void 기본_문자열_검증() {
    ParsedResult pr = Validator.validate("1,2:3");
    assertNull(pr.getCustomSeparator());
    assertEquals("1,2:3", pr.getMainString());
  }

  @Test
  void 커스텀_구분자_구분기능() {
    ParsedResult pr = Validator.validate("//&\n1,2:3");
    assertEquals("&", pr.getCustomSeparator());
    assertEquals("1,2:3", pr.getMainString());
  }

  @Test
  void 입력값_예외_테스트_구분자_중복() {
    assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,,2,3"))
                    .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  void 입력값_예외_테스트_숫자_부족() {
    assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("4,5,6,"))
                    .isInstanceOf(IllegalArgumentException.class)
    );
  }


  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}
