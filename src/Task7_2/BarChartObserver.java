package Task7_2;

import Task7_2.BarChartPanel;

import java.util.List;

/**
 * Клас BarChartObserver реалізує інтерфейс NumberObserver
 * і відповідає за оновлення графічної панелі BarChartPanel
 * при зміні колекції чисел.
 *
 * Використовується у патерні Observer для передачі нових даних
 * від NumberCollection до BarChartPanel.
 *
 * @author Sofia
 * @version 1.0
 */
public class BarChartObserver implements NumberObserver {
    /** Панель для відображення стовпчикової діаграми. */
    private final BarChartPanel panel;

    /**
     * Конструктор, що створює спостерігача для заданої панелі.
     *
     * @param panel панель, яка буде оновлюватися при зміні даних
     */
    public BarChartObserver(BarChartPanel panel) {
        this.panel = panel;
    }

    /**
     * Метод оновлення, викликається при зміні колекції чисел.
     * Передає нові дані панелі, щоб вона перемалювала графік.
     *
     * @param numbers список чисел, які потрібно відобразити
     */
    @Override
    public void update(List<Integer> numbers) {
        panel.setNumbers(numbers);
    }
}
