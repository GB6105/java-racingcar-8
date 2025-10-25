package racingcar;

import java.util.regex.Pattern;
import racingcar.util.ErrorMessage;
import racingcar.util.Regex;

public class Validator {
    public Validator(){};

    public static void validateCarName(String carName){
        if(!Pattern.matches(Regex.CAR_NAME,carName)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME);
        }
    }
}
