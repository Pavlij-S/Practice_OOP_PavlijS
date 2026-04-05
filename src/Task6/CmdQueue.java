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
        new Thread(new Worker()).start();
    }

    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }

    @Override
    public void put(Command r) {
        tasks.add(r);
        if (waiting) {
            synchronized (this) {
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
                    r.execute();
                }
            }
        }
    }
}
