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

    public static void validateTryNumber(String tryNumber){
        if(!Pattern.matches(Regex.TRY_NUMBER,tryNumber)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_NUMBER);
        }
    }
}
