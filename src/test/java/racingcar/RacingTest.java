package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.validation.Validator;
import racingcar.view.InputView;

class RacingTest {

    @Test
    void 이름_입력_테스트() {
        System.setIn(new ByteArrayInputStream("pobi,woni,jun".getBytes()));
        InputView inputView = new InputView();
        List<String> expect = List.of("pobi", "woni", "jun");
        assertThat(inputView.inputCarNames()).isEqualTo(expect);
        Console.close();
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
    void 횟수_입력_테스트() {
        System.setIn(new ByteArrayInputStream("10\n".getBytes()));
        InputView inputView = new InputView();
        assertThat(inputView.inputTryNumber()).isEqualTo(10);
        Console.close();
    }

    @Test
    void 자동차_생성_테스트() {
        String testName = "pobi";
        Car car = new Car(testName);
        assertThat(car.getName()).isEqualTo(testName);
        assertThat(car.getDistance()).isEqualTo(0);

    }

    @Test
    void 자동차_이동_테스트() {
        String testName = "pobi";
        Car car = new Car(testName);
        car.increaseDistance();
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
