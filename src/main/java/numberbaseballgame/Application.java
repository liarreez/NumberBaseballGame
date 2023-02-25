package numberbaseballgame;

public class Application {

    private static final Computer computer = new Computer();
    private static final User user = new User();

    public static void main(String[] args) {
        computer.printStartMessage();
        computer.generateRandomNumber();
        user.inputNumber();
        computer.hintCalculator(user.userNumber);
    }
}
