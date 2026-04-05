package Task6;

import java.util.concurrent.TimeUnit;
import Task2.Item2d;
import Task3.ViewResult;
import Task5.Command;

public class AvgCmd implements Command {
    private double result = 0.0;
    private int progress = 0;
    private ViewResult viewResult;

    public AvgCmd(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    public ViewResult getViewResult() {
        return viewResult;
    }

    public void setViewResult(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    public double getResult() {
        return result;
    }

    public boolean running() {
        return progress < 100;
    }

    @Override
    public void execute() {
        progress = 0;
        System.out.println("Average executed...");
        result = 0.0;
        int idx = 0, size = viewResult.getItems().size();

        for (Item2d item : viewResult.getItems()) {
            result += item.getResult();
            idx++;
            progress = idx * 100 / size;

            if (size > 1 && idx % (size / 2) == 0) {
                System.out.println("Average " + progress + "%");
            }

            try {
                TimeUnit.MILLISECONDS.sleep(2000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }

        result /= size;
        System.out.println("Average done. Result = " + String.format("%.2f", result));
        progress = 100;
    }
}
