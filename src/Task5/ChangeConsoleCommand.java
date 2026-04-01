package Task5;

import Task2.Item2d;
import Task3.View;

/**
 * Команда зміни одного елемента колекції.
 */
public class ChangeConsoleCommand implements ConsoleCommand {
    /** Елемент, який потрібно змінити. */
    private Item2d item;

    /** Коефіцієнт зміни значення. */
    private double offset;

    /** Об'єкт представлення для оновлення виводу. */
    private View view;

    /** Створює команду для роботи з переданим представленням. */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    /** Встановлює елемент, який буде змінено. */
    public Item2d setItem(Item2d item) {
        return this.item = item;
    }

    /** Повертає поточний елемент для зміни. */
    public Item2d getItem() {
        return item;
    }

    /** Встановлює коефіцієнт зміни. */
    public double setOffset(double offset) {
        return this.offset = offset;
    }

    /** Повертає поточний коефіцієнт зміни. */
    public double getOffset() {
        return offset;
    }

    /** Виконує зміну елемента та оновлює відображення. */
    @Override
    public void execute() {
        if (item == null) {
            System.out.println("No item to change.");
            return;
        }
        item.setTetrads((int) (item.getResult() * offset));
        System.out.println("Change current.");
        view.viewInit();
        view.viewShow();
    }

    /** Повертає символ команди в меню. */
    @Override
    public char getKey() {
        return 'c';
    }

    /** Повертає текстову назву команди для меню. */
    @Override
    public String toString() {
        return "'c'hange";
    }
}
