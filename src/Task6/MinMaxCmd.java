package Task6;

import java.util.concurrent.TimeUnit;
import Task2.Item2d;
import Task3.ViewResult;
import Task5.Command;

public class MinMaxCmd implements Command {
    // Індекси елементів з мінімальним і максимальним значенням number.
    private int resultMin = -1;
    private int resultMax = -1;
    private int progress = 0;
    private ViewResult viewResult;

    public MinMaxCmd(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    public ViewResult getViewResult() {
        return viewResult;
    }

    public void setViewResult(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    public int getResultMin() {
        return resultMin;
    }

    public int getResultMax() {
        return resultMax;
    }

    // Повертає true, доки команда ще не завершила обробку даних.
    public boolean running() {
        return progress < 100;
    }

    @Override
    public void execute() {
        progress = 0;
        System.out.println("MinMax executed...");
        int idx = 0, size = viewResult.getItems().size();

        for (Item2d item : viewResult.getItems()) {
            // Порівняння виконується за початковим числовим полем елемента.
            int value = item.getNumber();

            // Якщо знайшли менше значення, оновлюємо індекс мінімуму.
            if (resultMin == -1 || value < viewResult.getItems().get(resultMin).getNumber()) {
                resultMin = idx;
            }

            // Якщо знайшли більше значення, оновлюємо індекс максимуму.
            if (resultMax == -1 || value > viewResult.getItems().get(resultMax).getNumber()) {
                resultMax = idx;
            }

            idx++;
            progress = idx * 100 / size;
            if (size > 5 && idx % (size / 5) == 0) {
                System.out.println("MinMax " + progress + "%");
            }

            try {
                TimeUnit.MILLISECONDS.sleep(5000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }

        System.out.println("--- MinMax Results ---");
        System.out.println("Minimum value: "
                + viewResult.getItems().get(resultMin).getNumber()
                + " (Item #" + resultMin + ")");
        System.out.println("Maximum value: "
                + viewResult.getItems().get(resultMax).getNumber()
                + " (Item #" + resultMax + ")");
        System.out.println("----------------------");
        System.out.println("All threads finished.");

    }
}
