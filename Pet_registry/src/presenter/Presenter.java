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
    public void run() throws IOException, ClassNotFoundException {
        fileOperations.loadFromFile();
        System.out.println("Всего записей: " + fileOperations.getNumberRecord());
        Integer ID = fileOperations.getNumberRecord() +1;
        model.checkData(view.inputDate());
        fileOperations.saveToFile(ID, model.getNickName(), model.getGender(), model.getDateOfBirth(),
                model.getClassAnimal(), model.getSpeciesAnimal(), model.getBreedAnimal(), model.getAnimalType());
    }
}
