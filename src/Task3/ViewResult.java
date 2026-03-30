package Task3;

import Task2.Item2d;

import java.io.*;
import java.util.ArrayList;

public class ViewResult implements View {
    /** Назва файлу для серіалізації колекції. */
    private static final String FNAME = "items.bin";

    /** Кількість елементів, що створюються за замовчуванням. */
    private static final int DEFAULT_NUM = 5;

    /** Колекція об'єктів з числами та результатами обчислень. */
    private ArrayList<Item2d> items = new ArrayList<>();

    /** Створює колекцію стандартного розміру. */
    public ViewResult() {
        this(DEFAULT_NUM);
    }

    /** Створює колекцію з вказаною кількістю випадкових елементів. */
    public ViewResult(int n) {
        items.clear();
        for (int i = 0; i < n; i++) {
            int randomNumber = (int) (Math.random() * 1000);
            init(randomNumber);
        }
    }

    /** Повертає поточний список елементів. */
    public ArrayList<Item2d> getItems() {
        return items;
    }

    /** Підраховує кількість повних тетрад, тобто груп по 4 біти. */
    private int calculateTetrads(int n) {
        String binary = Integer.toBinaryString(n);
        int length = binary.length();
        return length / 4;
    }

    /** Додає до колекції один новий елемент на основі переданого числа. */
    public void init(int n) {
        int tetrads = calculateTetrads(n);
        Item2d item = new Item2d(n, tetrads);
        items.add(item);
    }

    /** Повністю перевизначає колекцію новими випадковими значеннями. */
    @Override
    public void viewInit() {
        items.clear();
        for (int i = 0; i < DEFAULT_NUM; i++) {
            int randomNumber = (int) (Math.random() * 1000);
            init(randomNumber);
        }
    }

    @Override
    public void viewSave() throws IOException {
        // Зберігаємо весь список одразу, щоб потім відновити його без втрат.
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }

    @Override
    public void viewRestore() throws Exception {
        // Відновлюємо колекцію з файлу у тому самому вигляді, в якому вона була збережена.
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Item2d>) is.readObject();
        is.close();
    }

    @Override
    public void viewHeader() {
        System.out.println("Results:");
    }

    @Override
    public void viewBody() {
        for (Item2d item : items) {
            System.out.println(item); // Для виводу автоматично використовується toString().
        }
    }

    @Override
    public void viewFooter() {
        System.out.println("End.");
    }

    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }

    public void show() {
        viewShow();
    }

    @Override
    public void setValue(int randomNumber) {
        // Параметр randomNumber тут не використовується: метод повністю генерує новий набір даних.
        items.clear();
        for (int i = 0; i < DEFAULT_NUM; i++) {
            int newRandom = (int) (Math.random() * 1000);
            int tetrads = calculateTetrads(newRandom);
            Item2d item = new Item2d(newRandom, tetrads);
            items.add(item);
        }
    }

    /** Делегує збереження до методу `viewSave`. */
    public void save() throws IOException {
        viewSave();
    }

    /** Делегує відновлення до методу `viewRestore`. */
    public void restore() throws Exception {
        viewRestore();
    }
}
