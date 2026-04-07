package Task7_2;

import Task2.Calc;
import Task7_2.BarChartObserver;
import Task7_2.ConsoleNumberObserver;
import Task7_2.NumberCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Клас Main запускає програму з графічним інтерфейсом.
 * Використовує шаблон Observer для відстеження змін у колекції чисел
 * та відображення їх у вигляді стовпчикової діаграми.
 * Передбачено стартове меню з кнопками Start та About.
 *
 * @author Sofia
 * @version 1.0
 */
public class Main {

    /**
     * Точка входу в програму.
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Task7");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CardLayout для переключення між меню та панеллю завдання
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        /**
         * Панель меню з кнопками Start та About.
         * Кнопки розташовані вертикально по центру.
         */
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JButton startButton = new JButton("Start");
        JButton aboutButton = new JButton("About");

        // Вирівнювання кнопок по центру
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Додаємо відступи та кнопки
        menuPanel.add(Box.createVerticalGlue());
        menuPanel.add(startButton);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(aboutButton);
        menuPanel.add(Box.createVerticalGlue());

        /**
         * Панель завдання: колекція чисел, графік та кнопки керування.
         */
        NumberCollection manager = new NumberCollection();
        BarChartPanel graphPanel = new BarChartPanel(manager);
        ConsoleNumberObserver console = new ConsoleNumberObserver();
        BarChartObserver graph = new BarChartObserver(graphPanel);
        manager.addObserver(console);
        manager.addObserver(graph);

        /**
         * Кнопка для додавання числа вручну.
         * Використовує Calc з Task2 для підрахунку тетрад.
         */
        JButton addButton = new JButton("Додати число");
        addButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Введіть число:");
            if (input != null) {
                try {
                    int value = Integer.parseInt(input);
                    if (value > 180) {
                        JOptionPane.showMessageDialog(frame, "Число повинно бути менше 180");
                        return;
                    }
                    manager.addNumber(value);

                    Calc calc = new Calc();
                    calc.setValue(value);
                    JOptionPane.showMessageDialog(frame,
                            "Десяткове число: " + value +
                                    "\nДвійкове представлення: " + Integer.toBinaryString(value) +
                                    "\nКількість повних тетрад: " + calc.init(value));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Потрібно ввести число!");
                }
            }
        });

        /**
         * Кнопка для генерації 5 випадкових чисел.
         * Кожне число додається у колекцію та обробляється Calc.
         */
        JButton randomFiveButton = new JButton("Згенерувати 5 чисел");
        Random rand = new Random();
        randomFiveButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Згенеровані числа:\n");
            Calc calc = new Calc();
            for (int i = 0; i < 5; i++) {
                int value = rand.nextInt(180);
                manager.addNumber(value);
                calc.setValue(value);
                sb.append(calc.getData()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, sb.toString());
        });

        /**
         * Кнопка для очищення графіка.
         */
        JButton clearButton = new JButton("Очистити графік");
        clearButton.addActionListener(e -> manager.clearNumbers());

        // Панель з кнопками керування
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.add(addButton);
        bottomPanel.add(randomFiveButton);
        bottomPanel.add(clearButton);

        // Панель завдання з графіком та кнопками
        JPanel taskPanel = new JPanel(new BorderLayout());
        taskPanel.add(graphPanel, BorderLayout.CENTER);
        taskPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Додаємо панелі у CardLayout
        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(taskPanel, "Task");

        // Логіка кнопок меню
        startButton.addActionListener(e -> cardLayout.show(mainPanel, "Task"));
        aboutButton.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "This assignment was completed by Sofia Pavliy, a student in Group 34"));

        frame.add(mainPanel);
        frame.setVisible(true);

        // Показуємо спочатку меню
        cardLayout.show(mainPanel, "Menu");
    }
}
