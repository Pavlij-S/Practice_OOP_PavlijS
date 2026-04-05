package Task6;

import Task5.Command;

public interface Queue {
    void put(Command cmd);
    Command take();
}
