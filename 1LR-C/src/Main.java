import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Выберите задание:");
        System.out.print("Ваш выбор: ");
        short task = scanner.nextShort();

        if (task == 0) {
            System.out.println("Выход из программы.");
            break;
        }

        switch (task) {
            case 1: {
                System.out.print("Введите первое число: ");
                double a =  scanner.nextDouble();
                System.out.print("Введите второе число: ");
                double b = scanner.nextDouble();
                System.out.println("Сумма: " + (a + b));
                break;
            }
            case 2: {
                System.out.print("Введите число: ");
                double n = scanner.nextDouble();
                double result;
                if (n < 0) {
                    result = -n;
                } else {
                    result = n;
                }
                System.out.println("Модуль числа: " + result);
                break;
            }
            case 3: {
                System.out.println("Чётные числа от 2 до 100:");
                int i = 2;
                do {
                    System.out.print(i + " ");
                    i+=2;
                } while(i<=100);
                System.out.println();
                break;
            }
            default: {
                System.out.println("Неверный номер задания.");
            }
        }

        System.out.println();
    }

    scanner.close();
}