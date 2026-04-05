package Task6;

import Task3.View;
import Task3.ViewableResult;
import Task4.ViewableTable;
import Task5.ChangeConsoleCommand;
import Task5.GenerateConsoleCommand;
import Task5.Menu;
import Task5.ViewConsoleCommand;
import Task6.ExecuteCC;

public class Main {
    private View view = new ViewableResult().getView();
    private Menu menu = new Menu();
    public void run(){
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteCC(view));
        menu.execute();
    }
    public static void main(String[] args){
        Main main = new Main();
        main.run();
    }
}