package Task5;

import Task3.View;
import Task4.ViewableTable;

/**
 * Головний клас застосунку.
 * Створює об'єкт представлення, формує меню команд і запускає програму.
 */
public class Application {
    /** Єдиний екземпляр застосунку. */
    private static Application instance = new Application();

    /** Закритий конструктор для реалізації шаблону Singleton. */
    private Application() {}

    /** Повертає єдиний екземпляр застосунку. */
    public static Application getInstance() {
        return instance;
    }

    /** Об'єкт представлення, з яким працюють усі команди. */
    private View view = new ViewableTable().getView();

    /** Меню консольних команд. */
    private Menu menu = new Menu();

    /** Реєструє всі команди та запускає виконання меню. */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.execute();
    }
}
