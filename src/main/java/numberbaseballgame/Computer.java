package numberbaseballgame;

public class Computer {

    public final int NUMBER_LENGTH = 4;
    public final int MAX_NUM = 9;

    private final int[] computerNumber = new int[NUMBER_LENGTH];

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void generateRandomNumber () {
        int tmpNum;
        for(int i=0; i < NUMBER_LENGTH; i++ ) {
            do {
                tmpNum = (int) ((Math.random() * MAX_NUM) + 1);
            } while(duplicateNumCheck(computerNumber, tmpNum));
            computerNumber[i] = tmpNum;
        }
    }

    private boolean duplicateNumCheck(int[] computerNumber, int num) {
        for(int i=0; i < NUMBER_LENGTH; i++ ) {
            if (computerNumber[i] == num) {
                return true;
            }
        }
        return false;
    }
}
