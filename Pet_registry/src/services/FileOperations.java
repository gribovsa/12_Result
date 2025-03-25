package services;

import java.io.IOException;
import java.time.LocalDate;

public interface FileOperations {

    //Создал интерфейс, который содержит в себе метод для работы с файлами

    void saveToFile(String lastName, String firstName, String secondName, LocalDate dateOfBirth,
                    long telephone, char gender) throws IOException;

}
