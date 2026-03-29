package Task2;

import java.io.Serializable;

/**
 * Зберігає десяткове число та результат обчислення:
 * кількість повних тетрад у його двійковому представленні.
 *
 * @author xone
 * @version 2.0
 */
public class Item2d implements Serializable {
    /** Вихідне десяткове число. */
    private int number;

    /** Результат обчислення - кількість повних тетрад. */
    private int result;

    /** Ідентифікатор версії класу для серіалізації. */
    private static final long serialVersionUID = 1L;

    /** Конструктор за замовчуванням. */
    public Item2d() {
        number = 0;
        result = 0;
    }

    /** Конструктор з початковими значеннями полів. */
    public Item2d(int number, int result) {
        this.number = number;
        this.result = result;
    }

    /** Встановлює значення поля `number`. */
    public int setNumber(int number) {
        return this.number = number;
    }

    /** Повертає значення поля `number`. */
    public int getNumber() {
        return number;
    }

    /** Встановлює значення поля `result`. */
    public int setTetrads(int tetrads) {
        return this.result = tetrads;
    }

    /** Повертає значення поля `result`. */
    public int getResult() {
        return result;
    }

    /** Оновлює обидва поля одним викликом. */
    public Item2d setValues(int number, int tetrads) {
        this.number = number;
        this.result = tetrads;
        return this;
    }

    /** Формує рядок з даними об'єкта для виведення. */
    @Override
    public String toString() {
        return "Decimal number = " + number +
                ", Binary = " + Integer.toBinaryString(number) +
                ", Full result = " + result;
    }

    /** Порівнює два об'єкти за значеннями їхніх полів. */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Item2d other = (Item2d) obj;
        return this.number == other.number &&
                this.result == other.result;
    }
}
