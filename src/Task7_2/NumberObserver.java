package Task7_2;

import java.util.List;

/**
 * Інтерфейс NumberObserver визначає контракт для спостерігачів,
 * які реагують на зміни у колекції чисел.
 *
 * Кожен клас, що реалізує цей інтерфейс, повинен визначити
 * метод update для обробки нового списку чисел.
 *
 * @author Sofia
 * @version 1.0
 */
public interface NumberObserver {
    /**
     * Викликається щоразу, коли змінюється список чисел.
     *
     * @param numbers оновлений список чисел
     */
    void update(List<Integer> numbers);
}
