package Task7_2;

import Task2.Calc;
import java.util.List;

/**
 * Клас ConsoleNumberObserver реалізує інтерфейс NumberObserver
 * і відповідає за виведення інформації про колекцію чисел у консоль.
 *
 * Для кожного числа додатково використовується клас Calc з Task2,
 * щоб показати десяткове значення, двійкове представлення та кількість тетрад.
 *
 * @author Sofia
 * @version 1.0
 */
public class ConsoleNumberObserver implements NumberObserver {
    /**
     * Метод викликається при кожному оновленні колекції чисел.
     * Виводить список чисел та детальну інформацію про кожне число.
     *
     * @param numbers оновлений список чисел
     */
    @Override
    public void update(List<Integer> numbers) {
        System.out.println("Колекція: " + numbers);
        Calc calc = new Calc();
        for (int number : numbers) {
            calc.setValue(number);
            calc.show();
        }
    }
}
