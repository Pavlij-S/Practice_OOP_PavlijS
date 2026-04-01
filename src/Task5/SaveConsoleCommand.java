package Task5;

import java.io.IOException;
import Task3.View;

/**
 * Команда збереження поточного стану у файл.
 */
public class SaveConsoleCommand implements ConsoleCommand {
    /** Об'єкт представлення, який виконує збереження. */
    private View view;

    /** Створює команду збереження для переданого представлення. */
    public SaveConsoleCommand(View view) {
        this.view = view;
    }

    /** Повертає символ команди в меню. */
    @Override
    public char getKey() {
        return 's';
    }

    /** Повертає текстову назву команди. */
    @Override
    public String toString() {
        return "'s'ave";
    }

    /** Зберігає дані у файл та показує поточний стан. */
    @Override
    public void execute() {
        System.out.println("Save current.");
        try {
            view.viewSave();
        } catch (IOException e) {
            System.err.println("Serialization errror: " + e);
        }
        view.viewShow();
    }
}
