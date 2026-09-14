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

    private static char getOperation(Scanner scanner) {
        while (true) {
            System.out.print("Введите операцию [+|-|*|/]: ");
            String input = scanner.next();
            if (input.length() == 1) {
                char operation = input.charAt(0);
                if (operation == '+' || operation == '-' || operation == '*' || operation == '/' ) {
                    return operation;
                }
            }
            System.out.println("Некорректная операция! Попробуйте снова.");
        }
    }

    private static double calculate(double firstOperand, char operation, double secondOperand) {
        switch (operation) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if (secondOperand == 0) {
                    throw new ArithmeticException("Нельзя делить на ноль!");
                }
                return firstOperand / secondOperand;
            default:
                return firstOperand;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstOperand = getOperand(scanner);
        char operation = getOperation(scanner);
        double secondOperand = getOperand(scanner);
        try {
            double result = calculate(firstOperand, operation, secondOperand);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
