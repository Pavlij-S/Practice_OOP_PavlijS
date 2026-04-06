package Task6;

import java.util.concurrent.TimeUnit;
import Task3.ViewResult;
import Task5.Command;

public class MaxCmd implements Command{
    private int result = -1;
    private int progress = 0;
    private ViewResult viewResult;
    public ViewResult getVaiewResult(){
        return viewResult;
    }
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }
    public MaxCmd(ViewResult viewResult) {
        this.viewResult = viewResult;
    }
    public int getResult() {
        return result;
    }
    public boolean running() {
        return progress < 100;
    }
    @Override
    public void execute() {
        progress = 0;
        System.out.println("Max executed...");
        int size = viewResult.getItems().size();
        result = 0;
        for (int idx = 1; idx < size; idx++) {
            // Зберігаємо індекс елемента з найбільшим значенням result.
            if (viewResult.getItems().get(result).getResult() <
                    viewResult.getItems().get(idx).getResult()) {
                result = idx;
            }
            progress = idx * 100 / size;
            if (idx % (size / 3) == 0) {
                System.out.println("Max " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(3000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.println("Max done. ");
        progress = 100;
    }

}
