package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public void moveAll(){
        for(Car car : cars){
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber > 4) {
            car.increaseDistance();
        }
    }
}
