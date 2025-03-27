package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Model {
    //В этом классе основная бизнес логика т.е методы проверки введённых данных

    //Поля класса
    private Integer animalId;
    private String nickName;
    private Character gender;
    private  LocalDate dateOfBirth;
    private String classAnimal;
    private String speciesAnimal;
    private String breedAnimal;
    private String animalType;


    //Геттеры

    public Integer getAnimalId() {
        return animalId;
    }

    public String getNickName() {
        return nickName;
    }

    public Character getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getClassAnimal() {
        return classAnimal;
    }

    public String getSpeciesAnimal() {
        return speciesAnimal;
    }

    public String getBreedAnimal() {
        return breedAnimal;
    }

    public String getAnimalType() {
        return animalType;
    }



    //Основной метод проверки данных
    public void checkData(String[] data) {
        try {
            this.animalId = Integer.valueOf(data[0]);
            this.nickName = data[1];
            this.gender = checkGender(data[2]);
            this.dateOfBirth = checkDateOfBirth(data[3]);


        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования String в int : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка аргумента: " + e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Ошибка аргумента, один из аргументов пуст: " + e.getMessage());
        }
    }

    //Метод для проверки пола
    public static Character checkGender(String gender)  {
        Character genderChar;
        if (gender.length() != 1) {
            throw new IllegalArgumentException("Аргумент 'пол' содержит более одного символа");
        } else {

            if (!((gender.equals("f")) || (gender.equals("m")))) {
                throw new IllegalArgumentException("Аргумент 'пол' должен принимать значение 'f' или 'm'");
            } else {
                genderChar = gender.toLowerCase().charAt(0);
                return genderChar;
            }
        }
    }


    //Метод проверки даты (подсмотрел в эталонном решении)
    public static LocalDate checkDateOfBirth(String dateOfBirth)  {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return LocalDate.parse(dateOfBirth, formatter);
        } catch (DateTimeParseException e){ //ловлю ошибку парсинга
            throw new IllegalArgumentException("Введите дату в формате dd.MM.yyyy Ошибка: " + e.getMessage());
        }
    }
}
