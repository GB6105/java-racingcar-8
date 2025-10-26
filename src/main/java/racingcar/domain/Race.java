package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void raceOneRound() {
        cars.moveAll();
    }

    public List<String> findWinner() {
        List<Car> carList = cars.getCars();
        int maxDistance = carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        List<String> winnerNames = new ArrayList<>();
        for (Car car : carList) {
            if (car.getDistance() == maxDistance) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
