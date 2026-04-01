package Task5;

import Task3.View;

/**
 * Команда відновлення даних із файлу.
 */
public class RestoreConsoleCommand implements ConsoleCommand {
    /** Об'єкт представлення, який виконує відновлення. */
    private View view;

    /** Створює команду відновлення для переданого представлення. */
    public RestoreConsoleCommand(View view) {
        this.view = view;
    }

    /** Повертає символ команди в меню. */
    @Override
    public char getKey() {
        return 'r';
    }

    /** Повертає текстову назву команди. */
    @Override
    public String toString() {
        return "'r'estore";
    }

    /** Відновлює дані з файлу та показує результат. */
    @Override
    public void execute() {
        System.out.println("Restore last saved.");
        try {
            view.viewRestore();
        } catch (Exception e) {
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    }
}
