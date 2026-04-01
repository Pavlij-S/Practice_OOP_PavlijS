package Task5;

import Task3.View;

/**
 * Команда генерації нового набору даних.
 */
public class GenerateConsoleCommand implements ConsoleCommand {
    /** Об'єкт представлення для генерації та показу даних. */
    private View view;

    /** Створює команду для переданого об'єкта представлення. */
    public GenerateConsoleCommand(View view) {
        this.view = view;
    }

    /** Повертає символ команди в меню. */
    @Override
    public char getKey() {
        return 'g';
    }

    /** Повертає текстову назву команди. */
    @Override
    public String toString() {
        return "'g'enerate";
    }

    /** Генерує нові дані та показує їх користувачу. */
    @Override
    public void execute() {
        System.out.println("Random generation.");
        view.viewInit();
        view.viewShow();
    }
}
