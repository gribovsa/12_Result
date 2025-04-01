package presenter;


import model.AbstractAnimal;

import services.FileOperations;
import view.ConsoleView;

import java.io.IOException;



public class Presenter {
    private final AbstractAnimal model;
    private final FileOperations fileOperations; //ссылка на интерфейс
    private final ConsoleView view;

    public Presenter(AbstractAnimal model, FileOperations fileOperations, ConsoleView view) {
        this.model = model;
        this.fileOperations = fileOperations;
        this.view = view;
    }

    //Точка входа
    public void run() throws IOException, ClassNotFoundException {
        while (true) {
            fileOperations.loadFromFile();
            System.out.println("Всего записей: " + fileOperations.getNumberRecord());
            switch (view.mainMenu()) {
                case (1):
                    //1 - [Добавить животное]
                    Integer ID = fileOperations.getNumberRecord() + 1;
                    model.checkData(view.inputDate());
                    fileOperations.saveToFile(ID, model.getNickName(), model.getGender(), model.getDateOfBirth(),
                            model.getClassAnimal(), model.getSpeciesAnimal(), model.getBreedAnimal(), model.getAnimalType());
                    break;
                case (2):
                    //2 - [Показать навыки животного]
                    fileOperations.loadFromSkillFile(view.getNumFindAnimal());
                    if (view.viewSkillMenu() == 1){
                        System.out.println("Перехожу в главное меню");
                        run();
                    } else {
                        System.out.println("До свидания!");
                        return;
                    }
                    return;
                case (3):
                    //3 - [Добавить навык животному]
                    System.out.println("Будет добавлен навык животному");
                    model.checkSkill(view.inputSkill());
                    fileOperations.saveToSkillFile(model.getId(), model.getSkillName());
                    break;
                case (0):
                    //0 - [Выход]
                    System.out.println("До свидания!");
                    return;
                case (100):
                    //0 - [Ввели недопустимое значение]
                    System.out.println("Ввели недопустимое значение");
                    fileOperations.loadFromFile();
                    System.out.println("Всего записей: " + fileOperations.getNumberRecord());
                    break;
            }
        }
    }
}
