package numberbaseballgame;

public class Computer {

    private final int NUMBER_LENGTH = 4;
    private final int MAX_NUM = 9;

    private int[] number = new int[NUMBER_LENGTH];

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void generateRandomNumber () {
        int tmpNum = 0;
        for(int i=0; i < NUMBER_LENGTH; i++ ) {
            do {
                tmpNum = (int) ((Math.random() * MAX_NUM) + 1);
            } while(duplicateNumCheck(number, tmpNum));
            number[i] = tmpNum;
        }
    }

    private boolean duplicateNumCheck(int[] number, int num) {
        for(int i=0; i < NUMBER_LENGTH; i++ ) {
            if (number[i] == num) {
                return true;
            }
        }
        return false;
    }
}
