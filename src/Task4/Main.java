package Task4;

import Task3.View;

import java.io.IOException;

/**
 * Головний клас для запуску четвертого завдання.
 * Наслідує консольну логіку меню з попереднього завдання.
 */
public class Main extends Task3.Main {

    /** Передає об'єкт представлення в батьківський клас. */
    public Main(View view) {
        super(view);
    }

    /** Точка входу в програму. */
    public static void main(String[] args) throws IOException {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}
