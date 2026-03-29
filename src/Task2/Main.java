package Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /** Об'єкт, який виконує обчислення та роботу з файлом. */
    private Calc calc = new Calc();

    /** Запускає консольне меню для взаємодії з користувачем. */
    private void menu() throws IOException {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore : ");
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);

            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;
                case 'v':
                    System.out.println("View current.");
                    calc.show();
                    break;
                case 'g':
                    System.out.println("Random generation.");
                    int randomNumber = (int) (Math.random() * 1000);
                    calc.setValue(randomNumber); // Встановлює випадкове число та оновлює результат.
                    calc.show(); // Показує дані для щойно згенерованого числа.
                    break;
                case 's':
                    System.out.println("Save current.");
                    calc.save();
                    calc.show();
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    try {
                        calc.restore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while (s.charAt(0) != 'q');
    }

    /** Точка входу в програму. */
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.menu();
    }
}
