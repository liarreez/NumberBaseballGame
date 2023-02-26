package numberbaseballgame;

import java.util.Arrays;

public class Computer {

    public final int NUMBER_LENGTH = 4;
    public final int MAX_NUM = 9;
    public final int NUMBER_GAMEPLAY_LIMIT = 10;
    private int gamePlayCount = 0;
    private int strike = 0;
    private int ball = 0;
    private static final User user = new User();
    private final int[] computerNumber = new int[NUMBER_LENGTH];


    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void generateRandomNumber() {
        int tmpNum;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            do {
                tmpNum = (int) ((Math.random() * MAX_NUM) + 1);
            } while (duplicateNumCheck(computerNumber, tmpNum));
            computerNumber[i] = tmpNum;
        }
    }

    private boolean duplicateNumCheck(int[] computerNumber, int num) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumber[i] == num) {
                return true;
            }
        }
        return false;
    }

    public void hintCalculator(int[] userNumber) {
        strikeChecker(userNumber);
        printHint();
        System.out.println(Arrays.toString(computerNumber));
    }

    public void strikeChecker(int[] userNumber) {
        for(int i=0; i < computerNumber.length; i++) {
            if(userNumber[i] == computerNumber[i]) {
                strike++;
            } else {
                for(int j : computerNumber) {
                    if(userNumber[i] == j) {
                        ball++;
                        break;
                    }
                }
            }
        }
    }

    public void printHint() {
        if (strike == 0 && ball == 0) {
            System.out.println("아웃");
        } else if (strike != 0 && ball == 0) {
            System.out.printf("%d스트라이크%n", strike);
        } else if (strike == 0 && ball != 0) {
            System.out.printf("%d볼%n", ball);
        } else if (strike != 0 && ball != 0) {
            System.out.printf("%d스트라이크 %d볼%n", strike, ball);
        }
    }

    public void repeatInput() {
        for(int i=0; i < NUMBER_GAMEPLAY_LIMIT; i++) {
            if(strike == 4 || gamePlayCount == 10)
                break;
            gamePlayCount++;
            strike = 0;
            ball = 0;
            user.inputNumber();
            hintCalculator(user.userNumber);
        }
    }
}
