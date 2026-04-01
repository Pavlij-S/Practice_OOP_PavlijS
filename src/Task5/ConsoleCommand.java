package Task5;

/**
 * Інтерфейс консольної команди, яка має символьну клавішу виклику.
 */
public interface ConsoleCommand extends Command {
    /** Повертає символ, який активує команду в меню. */
    public char getKey();
}
