import model.Model;
import presenter.Presenter;
import services.FileOperationsImpl;
import view.ConsoleView;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        Model data = new Model();
        FileOperationsImpl fileOperationsImpl = new FileOperationsImpl(); //экземпляр класса, в котором переопределен метод интерфейса FileOperations
        ConsoleView consoleView = new ConsoleView();

        Presenter presenter = new Presenter(data, fileOperationsImpl, consoleView);

        presenter.run();

    }
}