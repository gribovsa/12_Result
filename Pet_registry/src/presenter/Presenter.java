package presenter;

import model.Model;

import services.FileOperations;
import view.ConsoleView;

import java.io.IOException;

public class Presenter {
    private final Model model;
    private final FileOperations fileOperations; //ссылка на интерфейс
    private final ConsoleView view;

    public Presenter(Model model, FileOperations fileOperations, ConsoleView view) {
        this.model = model;
        this.fileOperations = fileOperations;
        this.view = view;
    }

    //Точка входа
    public void run() throws IOException {
        view.showPetRegistry();
        model.checkData(view.inputDate());
        fileOperations.saveToFile(model.getLastName(), model.getFirstName(), model.getSecondName(), model.getDateOfBirth(), model.getTelephone(), model.getGender());
    }
}
