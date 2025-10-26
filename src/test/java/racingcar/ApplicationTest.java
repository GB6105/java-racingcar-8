package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.view.InputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Test
    void 이름_입력_테스트() {
        System.setIn(new ByteArrayInputStream("pobi,woni,jun".getBytes()));
        InputView inputView = new InputView();
        List<String> expect = List.of("pobi", "woni", "jun");
        assertThat(inputView.inputCarNames()).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "nameLengthOver",
            "한글문자길이초과",
            "123456",
            "name!",
            "name%",
            "*@(#",
            " ",
            ""
    })
    void 검증기_테스트(String names) {
        assertThatThrownBy(() -> Validator.validateCarName(names)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_입력_테스트(){
        System.setIn(new ByteArrayInputStream("10".getBytes()));
        InputView inputView = new InputView();
        assertThat(inputView.inputTryNumber()).isEqualTo(10);
    }

    @Test
    void 자동차_생성_테스트(){
        String testName = "pobi";
        Car car = new Car(testName);
        assertThat(car.getName()).isEqualTo(testName);
        assertThat(car.getDistance()).isEqualTo(0);

    }

    @Test
    void 자동차_이동_테스트(){
        String testName = "pobi";
        Car car = new Car(testName);
        car.increaseDistance();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
