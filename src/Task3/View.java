package Task3;

import java.io.IOException;

public interface View {
    /**
     * Відображає заголовок результатів.
     */
    public void viewHeader();

    /**
     * Відображає основну частину даних.
     */
    public void viewBody();

    /**
     * Відображає завершальну частину виводу.
     */
    public void viewFooter();

    /**
     * Відображає весь результат повністю.
     */
    public void viewShow();

    /**
     * Виконує початкове заповнення даних.
     */
    public void viewInit();

    /**
     * Зберігає дані для подальшого відновлення.
     */
    public void viewSave() throws IOException;

    /**
     * Відновлює раніше збережені дані.
     */
    public void viewRestore() throws Exception;

    /** Показує результат у консольному інтерфейсі. */
    void show();

    /** Оновлює дані новими значеннями. */
    void setValue(int randomNumber);

    /** Зберігає поточний стан. */
    void save() throws IOException;

    /** Відновлює поточний стан із файлу. */
    void restore() throws Exception;
}
