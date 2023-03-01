package numberbaseballgame;

import java.util.*;

public class User {
    private final Scanner scanner = new Scanner(System.in);
    private final Computer computer = new Computer();
    public int[] userNumber = new int[computer.NUMBER_LENGTH];

    public void inputNumber() {
        try {
            System.out.println("숫자를 입력해주세요 : ");
            String tmpInput = scanner.nextLine();
            for (int i = 0; i < computer.NUMBER_LENGTH; i++) {
                userNumber[i] = (tmpInput.charAt(i) - '0');
            }
            if (tmpInput.length() != computer.NUMBER_LENGTH)
                throw new StringIndexOutOfBoundsException();
            if (duplicateNumCheck(userNumber)) {
                throw new StringIndexOutOfBoundsException();
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("1부터 9까지 서로 다른 수로 이루어진 4자리의 숫자로 올바르게 다시 입력해주세요.");
            this.inputNumber();
        }
    }

    private boolean duplicateNumCheck(int[] userNumber) {
        Set<Integer> set = new HashSet<>(userNumber.length);
        for (int i : userNumber) {
            set.add(i);
        }

        return userNumber.length != set.size();
    }

    public String inputRestart() {
        try {
            System.out.println("게임을 새로 시작하려면 c, 종료하려면 q를 입력하세요.");
            String inputRestart = scanner.nextLine();
            String gameRestart = inputRestart.toLowerCase();
            if (!(gameRestart.equals("c") || gameRestart.equals("q"))) {
                throw new IllegalArgumentException();
            }
            return gameRestart;
        } catch (IllegalArgumentException e) {
                System.out.println("적절하지 않은 명령어 입니다. 게임을 새로 시작하려면 c, 종료하려면 q를 입력하세요.");
        }
        return null;
    }
}
