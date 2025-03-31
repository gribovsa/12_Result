package services;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class FileOperationsImpl implements FileOperations {


    public static final int SIZE_LINE = 120;
    public static final String COLUMN_HEADER_FORMAT = "%-6s%-12s%-8s%-18s%-18s%-15s%-20s%-15s";
    public static final String COLUMN_SKILL_HEADER_FORMAT = "%-6s%-12s";
    public static final String REGISTRY_FILE_NAME = "Pet_registry.txt";
    public static final String SKILL_FILE_NAME = "Pet_skill.txt";


    @Override
    public void saveToFile(Integer animalID, String nickName, Character gender, LocalDate dateOfBirth,
                           String classAnimal, String speciesAnimal, String breedAnimal, String animalType) {

        //Формируем строку для записи
        String line = String.format("%d,%s,%c,%s,%s,%s,%s,%s", animalID, nickName, gender, dateOfBirth,
                classAnimal, speciesAnimal, breedAnimal, animalType);

        //Операция записи строки в файл
        Charset code = StandardCharsets.UTF_8;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REGISTRY_FILE_NAME, code, true))) {
            System.out.println("Будет записана вот такая строка");
            System.out.println(line);
            writer.write(line);
            writer.newLine();
            System.out.println("Выполнена запись в файл, кодировка: " + code);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(REGISTRY_FILE_NAME))) {
            //оформление
            clearConsole();
            printLineWithSymbol("=", 120);
            printCaption("Реестр домашних животных", " ");
            printLineWithSymbol("=", 120);
            printRegistryHeader();
            printLineWithSymbol("-", 120);

            String line;
            while ((line = reader.readLine()) != null) { //если строка не пустая
                String[] arr = line.split(",");
                System.out.println(String.format(COLUMN_HEADER_FORMAT, arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]));
            }
            //оформление
            printLineWithSymbol("-", 120);
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public Integer getNumberRecord() {
        try (BufferedReader reader = new BufferedReader(new FileReader(REGISTRY_FILE_NAME))) {
            String line;
            String[] arr = new String[8];
            Integer last_number = 0;
            while ((line = reader.readLine()) != null) { //если строка не пустая
                arr = line.split(",");
            }
            last_number = Integer.parseInt(arr[0]);
            return last_number;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void loadFromSkillFile(Integer numFindAnimal) throws IOException, ClassNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(SKILL_FILE_NAME))) {
            //оформление
            clearConsole();
            printLineWithSymbol("=", 120);
            printCaption("Навыки животного", " ");
            printLineWithSymbol("=", 120);
            printSkillHeader();
            printLineWithSymbol("-", 120);

            String line;
            while ((line = reader.readLine()) != null) { //если строка не пустая
                String[] arr = line.split(":");

                if (numFindAnimal == Integer.parseInt(arr[0])){
                    System.out.println(String.format(COLUMN_SKILL_HEADER_FORMAT, arr[0], arr[1]));
                }
            }
            //оформление
            printLineWithSymbol("-", 120);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveToSkillFile(String animalID, String skillName) {
        //Формируем строку для записи
        String line = String.format("%s:%s", animalID, skillName);

        //Операция записи строки в файл
        Charset code = StandardCharsets.UTF_8;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SKILL_FILE_NAME, code, true))) {
            System.out.println("Будет записана вот такая строка");
            System.out.println(line);
            writer.write(line);
            writer.newLine();
            System.out.println("Выполнена запись в файл, кодировка: " + code);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //вспомогательные методы для красивого оформления
    private void clearConsole() {
        System.out.print("\033[H\033[J");
    }

    private void printLineWithSymbol(String symbol, int sizeLine) {
        System.out.println(symbol.repeat(sizeLine));
    }

    private void printCaption(String caption, String padSymb) {
        int spaceSize = (SIZE_LINE - caption.length()) / 2;
        String captionLine = padSymb.repeat(spaceSize) + caption + padSymb.repeat(spaceSize);
        System.out.println(captionLine);
    }

    private void printRegistryHeader() {
        String header = String.format(COLUMN_HEADER_FORMAT, "№", "Кличка", "Пол", "Дата Рождения", "Класс",
                "Вид", "Порода", "Тип животного");
        System.out.println(header);
    }

    private void printSkillHeader() {
        String header = String.format(COLUMN_SKILL_HEADER_FORMAT, "№", "Навыки животного");
        System.out.println(header);
    }
}
