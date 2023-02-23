package numberbaseballgame;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.printStartMessage();
        computer.generateRandomNumber();
    }
}
