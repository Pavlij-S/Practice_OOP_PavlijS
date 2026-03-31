package Task4;

import java.util.Formatter;
import Task2.Item2d;
import Task3.ViewResult;

public class ViewTable extends ViewResult{
    private static final int DEFAULT_WIDTH = 20;
    private int width;
    public ViewTable(){
        width = DEFAULT_WIDTH;
    }
    public ViewTable(int width, int n){
        super(n);
        this.width = width;
    }
    public int setWidth(){
        return width;
    }
    private void outLineLn(){
        System.out.println("--------------------");
    }
    private void outHeader(){
        System.out.printf("%-10s | %-10s\n", "x", "y");
    }

    private void outBody(){
        for(Item2d item : getItems()){
            System.out.printf("%-10d | %-10d%n", item.getNumber(), item.getResult());
        }
    }
    public  final void setWidth (int width){
        this.width = width;
        viewInit();
    }
    public final void init(int width, double stepX){
        this.width = width;
        init(stepX);
    }

    @Override
    public void init(double stepX){
        getItems().clear();
        for (int i = 0; i < 5; i++) {
            int number = (int)(i * stepX);
            super.init(number); // виклик базового init(int n)
        }
    }
    @Override
    public void ViewHeader(){
        outHeader();
        outLineLn();
    }
    @Override
    public void viewBody(){
        outBody();
    }
    @Override
    public void viewFooter(){
        outLineLn();
    }
}
