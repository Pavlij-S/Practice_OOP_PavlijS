package Task4;

import Task2.Item2d;
import Task3.ViewResult;

/**
 * Клас для табличного відображення списку результатів.
 */
public class ViewTable extends ViewResult {
    /** Стандартна ширина таблиці. */
    private static final int DEFAULT_WIDTH = 20;

    /** Поточна ширина форматування таблиці. */
    private int width;

    /** Створює таблицю зі стандартною шириною. */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    /** Створює таблицю із заданою шириною та кількістю елементів. */
    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }

    /** Повертає поточну ширину таблиці. */
    public int setWidth() {
        return width;
    }

    /** Виводить розділювальну лінію таблиці. */
    private void outLineLn() {
        System.out.println("--------------------");
    }

    /** Виводить заголовок таблиці. */
    private void outHeader() {
        System.out.printf("%-10s | %-10s\n", "x", "y");
    }

    /** Виводить усі рядки таблиці на основі поточної колекції. */
    private void outBody() {
        for (Item2d item : getItems()) {
            System.out.printf("%-10d | %-10d%n", item.getNumber(), item.getResult());
        }
    }

    /** Встановлює нову ширину та перевизначає дані таблиці. */
    public final void setWidth(int width) {
        this.width = width;
        viewInit();
    }

    /** Ініціалізує таблицю з указаною шириною та кроком по осі X. */
    public final void init(int width, double stepX) {
        this.width = width;
        init(stepX);
    }

    /** Формує колекцію значень з однаковим кроком. */
    @Override
    public void init(double stepX) {
        getItems().clear();
        for (int i = 0; i < 5; i++) {
            int number = (int) (i * stepX);
            super.init(number); // Виклик базового методу для додавання одного елемента.
        }
    }

    /** Виводить заголовок таблиці разом із розділювачем. */
    @Override
    public void ViewHeader() {
        outHeader();
        outLineLn();
    }

    /** Виводить основну частину таблиці. */
    @Override
    public void viewBody() {
        outBody();
    }

    /** Виводить завершальну лінію таблиці. */
    @Override
    public void viewFooter() {
        outLineLn();
    }
}
