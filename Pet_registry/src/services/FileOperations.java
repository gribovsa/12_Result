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

    //Получить количество записей реестра
    Integer getNumberRecord() throws FileNotFoundException;

    //Чтение навыков из файла
    void loadFromSkillFile(Integer numFindAnimal) throws IOException, ClassNotFoundException;

    //Запись навыков в файл
    void saveToSkillFile(String animalID, String skillName);
}

