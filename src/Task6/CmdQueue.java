package Task6;

import java.util.Vector;
import Task5.Command;

public class CmdQueue implements Queue {
    private Vector<Command> tasks;
    private boolean waiting;
    private boolean shutdown;

    public CmdQueue() {
        tasks = new Vector<>();
        waiting = false;
        // Окремий потік постійно забирає команди з черги та виконує їх.
        new Thread(new Worker()).start();
    }

    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            // Пробуджуємо потік, якщо він очікує на нові задачі.
            notifyAll();
        }
    }

    @Override
    public void put(Command r) {
        tasks.add(r);
        if (waiting) {
            synchronized (this) {
                // Повідомляємо worker-потоку, що в черзі з'явилася команда.
                notifyAll();
            }
        }
    }

    @Override
    public Command take() {
        if (tasks.isEmpty()) {
            synchronized (this) {
                waiting = true;
                try {
                    // Чекаємо, доки до черги не буде додано нову команду.
                    wait();
                } catch (InterruptedException ie) {
                    waiting = false;
                }
            }
        }
        return tasks.remove(0);
    }

    private class Worker implements Runnable {
        @Override
        public void run() {
            while (!shutdown) {
                Command r = take();
                if (r != null) {
                    // Конкретна логіка виконання знаходиться всередині самої команди.
                    r.execute();
                }
            }
        }
    }
}
