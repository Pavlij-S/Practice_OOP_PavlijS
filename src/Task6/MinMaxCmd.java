package Task6;

import java.util.concurrent.TimeUnit;
import Task2.Item2d;
import Task3.ViewResult;
import Task5.Command;

public class MinMaxCmd implements Command {
    private int resultMin = -1; // індекс мінімального позитивного
    private int resultMax = -1; // індекс максимального негативного
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

    /** Метод для перевірки, чи команда ще виконується */
    public boolean running() {
        return progress < 100;
    }

    @Override
    public void execute() {
        progress = 0;
        System.out.println("MinMax executed...");
        int idx = 0, size = viewResult.getItems().size();

        for (Item2d item : viewResult.getItems()) {
            int value = item.getNumber(); // тепер працюємо з першим стовпцем

            // шукаємо мінімальне
            if (resultMin == -1 || value < viewResult.getItems().get(resultMin).getNumber()) {
                resultMin = idx;
            }

            // шукаємо максимальне
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
