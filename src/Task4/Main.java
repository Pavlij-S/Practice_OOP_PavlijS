package Task4;

import Task3.View;

import java.io.IOException;

public class Main extends Task3.Main {

    public Main(View view) {
        super(view);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}