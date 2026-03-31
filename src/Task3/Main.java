package Task3;

import Task4.ViewTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /** Об'єкт представлення, через який виконується вся робота з даними. */
    private View view;

    /** Створює головний клас програми з переданим об'єктом представлення. */
    public Main(View view) {
        this.view = view;
    }

    /** Запускає консольне меню для взаємодії з користувачем. */
    protected void menu() throws IOException {
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
                    view.show();
                    break;
                case 'g':
                    System.out.println("Random generation.");
                    int randomNumber = (int) (Math.random() * 1000);
                    view.setValue(randomNumber); // Оновлює набір даних новими випадковими значеннями.
                    view.show(); // Одразу показує згенерований результат.
                    break;
                case 's':
                    System.out.println("Save current.");
                    view.save();
                    view.show();
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    try {
                        view.restore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.show();
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while (s.charAt(0) != 'q');
    }

    /** Точка входу в програму. */
    public static void main(String[] args) throws IOException {
        Viewable viewable = new ViewableResult();
        View view = new ViewTable();
        Main main = new Main(view);
        main.menu();
    }
}
