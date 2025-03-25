package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class FileOperationsImpl implements FileOperations {

    @Override
    public void saveToFile(String lastName, String firstName, String secondName,
                           LocalDate dateOfBirth, long telephone, char gender) throws IOException {

        //Формирование имени файла
        String fileName = lastName + ".txt";

        //Формируем строку для записи
        String line = String.format("%s %s %s %s %d %c",lastName, firstName, secondName, dateOfBirth, telephone, gender);

        //Операция записи строки в файл

        Charset code = StandardCharsets.UTF_16;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, code, true))){
            writer.write(line);
            writer.newLine();
            System.out.println("Выполнена запись в файл, кодировка: " + code);
        }
    }
}
