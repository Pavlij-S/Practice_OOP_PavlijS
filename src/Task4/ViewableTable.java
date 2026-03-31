package Task4;

import Task3.ViewableResult;
import Task3.View;

/**
 * Фабрика для створення табличного представлення результатів.
 */
public class ViewableTable extends ViewableResult {
    /** Повертає новий об'єкт табличного відображення. */
    @Override
    public View getView() {
        return new ViewTable();
    }
}
