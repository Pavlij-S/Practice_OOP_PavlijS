package Task5;

import Task2.Item2d;

/**
 * Команда для зміни окремого елемента без взаємодії з меню.
 */
public class ChangeItemCommand implements Command {
    /** Елемент, який потрібно змінити. */
    private Item2d item;

    /** Коефіцієнт, на який множиться поточний результат. */
    private double offset;

    /** Встановлює елемент для зміни. */
    public Item2d setItem(Item2d item) {
        return this.item = item;
    }

    /** Повертає елемент, який буде змінено. */
    public Item2d getItem() {
        return item;
    }

    /** Встановлює коефіцієнт зміни та повертає його. */
    public double getOffset(double offset) {
        return this.offset = offset;
    }

    /** Повертає поточний коефіцієнт зміни. */
    public double getOffset() {
        return offset;
    }

    /** Виконує зміну результату вибраного елемента. */
    @Override
    public void execute() {
        item.setTetrads((int) (item.getResult() * offset));
    }
}
