package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.constant.ErrorMessage;

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

    public static void validateDuplicateName(List<String> carNames){
        Set<String> carNameSet = new HashSet<>();
        for (String carName : carNames) {
            if(!carNameSet.add(carName)){
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME);
            }
        }
    }
}
