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
            System.out.print("Введите операцию (+, -, *, /, c - сброс, s - выход): ");
            String input = scanner.next().toLowerCase();
            if (input.length() == 1) {
                char operation = input.charAt(0);
                if (operation == '+' || operation == '-' || operation == '*' || operation == '/' || operation == 'c' || operation == 's') {
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
                return firstOperand / secondOperand;
            default:
                return firstOperand;
        }
    }

    private static boolean isZeroDivision(char operation, double secondOperand) {
        return operation == '/' && secondOperand == 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstOperand = getOperand(scanner);

        while (true) {
            char operation = getOperation(scanner);

            switch (operation) {
                case 'c':
                    System.out.println("Результат сброшен.");
                    firstOperand = getOperand(scanner);
                    continue;
                case 's':
                    System.out.println("Работа калькулятора завершена.");
                    return;
                default:
                    double secondOperand = getOperand(scanner);
                    while (isZeroDivision(operation, secondOperand)) {
                        System.out.println("На ноль делить нельзя! Измените второй операнд.");
                        secondOperand = getOperand(scanner);
                    }
                    double result = calculate(firstOperand, operation, secondOperand);
                    System.out.println(result);
                    firstOperand = result;
            }
        }
    }
}
