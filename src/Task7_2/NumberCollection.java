package Task7_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас NumberCollection зберігає список чисел та реалізує
 * механізм сповіщення спостерігачів про зміни.
 *
 * Використовує патерн Observer: спостерігачі підписуються
 * на колекцію і отримують повідомлення при додаванні або
 * очищенні чисел.
 *
 * @author Sofia
 * @version 1.0
 */
public class NumberCollection {
    /** Основний список чисел, за змінами якого стежать спостерігачі. */
    private final List<Integer> numbers = new ArrayList<>();
    /** Список спостерігачів, які отримують повідомлення про зміни. */
    private final List<NumberObserver> observers = new ArrayList<>();

    /**
     * Додає нового спостерігача до списку.
     *
     * @param observer об'єкт, який буде отримувати оновлення
     */
    public void addObserver(NumberObserver observer) {
        observers.add(observer);
    }

    /**
     * Додає нове число до колекції та сповіщає спостерігачів.
     *
     * @param value число для додавання
     */
    public void addNumber(int value) {
        numbers.add(value);
        notifyObservers();
    }

    /**
     * Очищає колекцію чисел та сповіщає спостерігачів.
     */
    public void clearNumbers() {
        numbers.clear();
        notifyObservers();
    }

    /**
     * Повертає поточний список чисел.
     *
     * @return список чисел
     */
    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * Сповіщає всіх підписаних спостерігачів про зміни у колекції.
     */
    private void notifyObservers() {
        for (NumberObserver observer : observers) {
            observer.update(numbers);
        }
    }
}
