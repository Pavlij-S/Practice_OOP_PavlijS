package Task5;

import Task3.View;

/**
 * Команда перегляду поточного стану даних.
 */
public class ViewConsoleCommand implements ConsoleCommand {
    /** Об'єкт представлення для виводу даних. */
    private View view;

    /** Створює команду перегляду для переданого представлення. */
    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    /** Повертає символ команди в меню. */
    @Override
    public char getKey() {
        return 'v';
    }

    /** Повертає текстову назву команди. */
    @Override
    public String toString() {
        return "'v'iew";
    }

    /** Виводить поточні дані користувачу. */
    @Override
    public void execute() {
        System.out.println("View current.");
        view.viewShow();
    }
}
