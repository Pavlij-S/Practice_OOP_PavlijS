package Task2;

/**
 * Клас для ручної перевірки правильності обчислень
 * і роботи серіалізації та десеріалізації.
 */
public class MainTest {
    public static void main(String[] args) {
        Calc calc = new Calc();
        try {
            // Перевірка обчислень для кількох тестових чисел.
            int[] numbers = {5, 10, 16, 255, 1024};

            for (int n : numbers) {
                calc.convert(n);
                System.out.println("Тест обчислення для числа " + n + ":");
                System.out.println(calc.getData());
                System.out.println("-------------------------");
            }

            // Перевірка збереження об'єкта у файл.
            calc.convert(255);
            calc.save();
            System.out.println("Збереження успішне.");

            // Перевірка відновлення об'єкта з файлу.
            calc.restore();
            System.out.println("Відновлення успішне.");
            System.out.println(calc.getData());

        } catch (Exception e) {
            System.out.println("ПОМИЛКА ТЕСТУВАННЯ");
            e.printStackTrace();
        }
    }
}
