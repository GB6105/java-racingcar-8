package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.OutputView;

public class RaceController {
    public void startRace(int tryNumber, Cars cars){
        Race race = new Race(cars);
        while(tryNumber > 0){
            race.raceOneRound();
            OutputView.printProgress(cars);
            tryNumber--;
        }
        List<String> winnerNames =  race.findWinner();
        OutputView.printWinner(winnerNames);
    }
}
