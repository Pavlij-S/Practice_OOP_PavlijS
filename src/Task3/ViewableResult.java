package Task3;

public class ViewableResult implements Viewable {
    /** Створює об'єкт представлення типу {@linkplain ViewResult}. */
    @Override
    public View getView() {
        return new ViewResult();
    }
}
