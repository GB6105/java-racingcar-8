package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.constant.Message;
import racingcar.validation.Validator;

public class InputView {
    public List<String> inputCarNames(){
        System.out.println(Message.REQUIRE_CAR_NAMES);
        String input = Console.readLine();
        String[] names = input.split(",");
        List<String> carNames = new ArrayList<>();
        for(String name : names) {
            String trimmedName = name.trim();
            Validator.validateCarName(trimmedName);
            carNames.add(trimmedName);
        }
        Validator.validateDuplicateName(carNames);
        return carNames;
    }

    public int inputTryNumber(){
        System.out.println(Message.REQUIRE_TRY_NUMBER);
        String input = Console.readLine();
        Validator.validateTryNumber(input);
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
           throw new IllegalArgumentException("Invalid try number");
        }
    }
}
