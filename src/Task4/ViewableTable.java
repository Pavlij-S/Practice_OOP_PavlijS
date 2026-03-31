package Task4;

import Task3.ViewableResult;
import Task3.View;

public class ViewableTable extends ViewableResult{
    @Override
    public View getView(){
        return new ViewTable();
    }
}
