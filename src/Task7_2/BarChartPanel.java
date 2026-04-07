package Task7_2;

import Task7_2.NumberCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Клас BarChartPanel відповідає за графічне відображення колекції чисел
 * у вигляді стовпчикової діаграми. Кожне число зображається як стовпчик,
 * висота якого відповідає значенню числа, а під ним виводиться саме число.
 *
 * Використовується як спостерігач у патерні Observer для оновлення графіка
 * при зміні колекції чисел.
 *
 * @author Sofia
 * @version 1.0
 */
public class BarChartPanel extends JPanel {
    /** Список чисел, які відображаються на графіку. */
    private List<Integer> numbers;

    /**
     * Конструктор, що ініціалізує панель графіка.
     *
     * @param manager об'єкт NumberCollection, який містить колекцію чисел
     */
    public BarChartPanel(NumberCollection manager) {
        this.numbers = manager.getNumbers();
    }

    /**
     * Оновлює список чисел для відображення та перерисовує графік.
     *
     * @param numbers новий список чисел
     */
    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
        repaint();
    }

    /**
     * Малює стовпчикову діаграму на панелі.
     * Кожне число відображається як синій стовпчик,
     * а під ним виводиться його значення.
     *
     * @param g графічний контекст для малювання
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (numbers == null || numbers.isEmpty()) {
            return;
        }

        g.setColor(Color.BLUE);
        // Початкова позиція для першого стовпчика по осі X.
        int x = 40;
        for (int value : numbers) {
            // Малюємо стовпчик, висота якого відповідає значенню числа.
            g.fillRect(x, getHeight() - value - 40, 20, value);

            // Підписуємо значення під відповідним стовпчиком.
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(value), x, getHeight() - 20);

            // Повертаємо колір стовпчиків перед наступною ітерацією.
            g.setColor(Color.BLUE);
            // Зсуваємося вправо, щоб намалювати наступний стовпчик.
            x += 40;
        }
    }
}
