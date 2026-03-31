package Task3;

import Task4.ViewTable;

public class ViewableResult implements Viewable {
    /** Створює об'єкт представлення типу {@linkplain ViewResult}. */
    @Override
    public View getView() {
        return new ViewTable();
    }
}
