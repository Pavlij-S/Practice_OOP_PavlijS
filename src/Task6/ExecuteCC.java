package Task6;

import java.util.concurrent.TimeUnit;
import Task3.View;
import Task3.ViewResult;
import Task5.ConsoleCommand;

public class ExecuteCC implements ConsoleCommand {
    private View view;

    public ExecuteCC(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'e';
    }

    @Override
    public String toString() {
        return "'e'xecute";
    }

    @Override
    public void execute() {
        CmdQueue queue1 = new CmdQueue();
        CmdQueue queue2 = new CmdQueue();

        // створюємо команди
        MinMaxCmd minMaxCmd = new MinMaxCmd((ViewResult) view);
        MaxCmd maxCmd = new MaxCmd((ViewResult) view);
        AvgCmd avgCmd = new AvgCmd((ViewResult) view);

        System.out.println("Execute all threads...");

        // додаємо команди в черги
        queue1.put(minMaxCmd);
        queue2.put(maxCmd);
        queue2.put(avgCmd);

        try {
            while (avgCmd.running() || maxCmd.running() || minMaxCmd.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue1.shutdown();
            queue2.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        System.out.println("All done.");
    }
}
