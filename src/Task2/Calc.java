package Task2;

import java.io.*;

/**
 * Клас для підрахунку кількості повних тетрад
 * у двійковому представленні десяткового числа.
 */
public class Calc implements Serializable {
    private static final String FNAME = "Item2d.bin";

    /** Вихідне десяткове число. */
    private int number;

    /** Кількість повних груп по 4 біти у двійковому записі числа. */
    private int result;

    /** Конструктор за замовчуванням. */
    public Calc() {
        number = 0;
        result = 0;
    }

    /** Обчислює кількість повних тетрад для переданого числа. */
    private int calculateTetrads(int n) {
        String binary = Integer.toBinaryString(n);
        int length = binary.length();
        return length / 4; // Враховуються лише повні групи по 4 біти.
    }

    /** Ініціалізує об'єкт новим числом і одразу обчислює результат. */
    public int init(int n) {
        this.number = n;
        this.result = calculateTetrads(n);
        return result;
    }

    /** Виводить поточні дані об'єкта в консоль. */
    public void show() {
        System.out.println("Десяткове число: " + number);
        System.out.println("Двійкове представлення: " + Integer.toBinaryString(number));
        System.out.println("Кількість повних тетрад: " + result);
    }

    /** Серіалізує поточний стан об'єкта у файл. */
    public void save() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME))) {
            os.writeObject(this);
        }
    }

    /** Відновлює стан об'єкта з раніше збереженого файлу. */
    public void restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME))) {
            Calc tmp = (Calc) is.readObject();
            this.number = tmp.number;
            this.result = tmp.result;
        }
    }

    /** Оновлює число та перераховує результат. */
    public void convert(int n) {
        this.number = n;
        this.result = calculateTetrads(n);
    }

    /** Повертає текстове представлення поточного стану об'єкта. */
    public String getData() {
        return "Десяткове число: " + number +
                "\nДвійкове представлення: " + Integer.toBinaryString(number) +
                "\nКількість повних тетрад: " + result;
    }

    /** Встановлює нове число та автоматично оновлює результат. */
    public void setValue(int n) {
        this.number = n;
        this.result = calculateTetrads(n);
    }
}
