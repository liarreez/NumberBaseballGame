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

    public void playGame() {
        printStartMessage();
        generateRandomNumber();
        repeatInput();
        resetGame();
        gameRestart();
    }

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
    }

    public void strikeChecker(int[] userNumber) {
        for (int i = 0; i < computerNumber.length; i++) {
            if (userNumber[i] == computerNumber[i]) {
                strike++;
            } else {
                for (int j : computerNumber) {
                    if (userNumber[i] == j) {
                        ball++;
                        break;
                    }
                }
            }
        }
    }

    public void printHint() {
        int remainGamePlayCount = NUMBER_GAMEPLAY_LIMIT - gamePlayCount;
        if (strike == 0 && ball == 0) {
            System.out.println("아웃");
        } else if (strike != 0 && ball == 0) {
            System.out.printf("%d스트라이크 (잔여 횟수 : %d)%n", strike, remainGamePlayCount);
        } else if (strike == 0 && ball != 0) {
            System.out.printf("%d볼 (잔여 횟수 : %d)%n", ball, remainGamePlayCount);
        } else if (strike != 0 && ball != 0) {
            System.out.printf("%d스트라이크 %d볼 (잔여 횟수 : %d)%n", strike, ball, remainGamePlayCount);
        }
    }

    public void repeatInput() {
        for (int i = 0; i < NUMBER_GAMEPLAY_LIMIT+1; i++) {
            if (strike == 4 || gamePlayCount == NUMBER_GAMEPLAY_LIMIT) {
                printGameResult();
                break;
            }
            gamePlayCount++;
            strike = 0;
            ball = 0;
            user.inputNumber();
            hintCalculator(user.userNumber);
        }
    }

    public void printGameResult() {
        if (strike == 4) {
            System.out.printf("정답입니다!(시도 횟수 : %d)%n", gamePlayCount);
        } else if (gamePlayCount == NUMBER_GAMEPLAY_LIMIT) {
            System.out.println("실패입니다! 다음에 다시 도전해주세요.");
        }
    }

    public void gameRestart() {
        String inputRestart = user.inputRestart();
        if(inputRestart.equals("q")) {
            System.out.println("게임 종료");
        } else if(inputRestart.equals("c")) {
            playGame();
        }
    }

    public void resetGame() {
        gamePlayCount = 0;
        strike = 0;
        ball = 0;
    }
}
