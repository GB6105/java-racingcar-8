package racingcar;

import java.util.List;
import racingcar.controller.RaceController;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RaceGame {
    public static void run() {
        InputView inputView = new InputView();
        List<String> inputNames = inputView.inputCarNames();
        int tryNumber = inputView.inputTryNumber();
        RaceController raceController = new RaceController();
        raceController.startRace(tryNumber,new Cars(inputNames));
    }
}
