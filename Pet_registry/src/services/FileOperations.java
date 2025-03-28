package services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public interface FileOperations {

    //Создал интерфейс, который содержит в себе метод для работы с файлами

    //Чтение реестра из файла
    void saveToFile(Integer animalID, String nickName, Character gender, LocalDate dateOfBirth,
                    String classAnimal, String speciesAnimal, String breedAnimal, String animalType) throws IOException;

    //Запись реестра в файл
    void loadFromFile() throws IOException, ClassNotFoundException;

    //Получить количество записей
    Integer getNumberRecord() throws FileNotFoundException;
}
