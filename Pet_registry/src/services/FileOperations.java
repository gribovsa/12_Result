package services;

import java.io.IOException;
import java.time.LocalDate;

public interface FileOperations {

    //Создал интерфейс, который содержит в себе метод для работы с файлами

    void saveToFile(Integer animalID, String nickName, Character gender, LocalDate dateOfBirth,
                    String classAnimal, String speciesAnimal, String breedAnimal, String animalType) throws IOException;

    void loadFromFile() throws IOException, ClassNotFoundException;
}
