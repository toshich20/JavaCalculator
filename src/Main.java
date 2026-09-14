import java.util.Scanner;

public class Main {

    private static double getOperand(Scanner scanner) {
        while (true) {
            System.out.print("Введите операнд: ");
            if (scanner.hasNextDouble()) {
                double operand = scanner.nextDouble();
                return operand;
            } else {
                System.out.println("Операнд должен быть числом!");
                scanner.next();
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstOperand = getOperand(scanner);
    }
}
