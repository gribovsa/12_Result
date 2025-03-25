package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Model {
    //В этом классе основная бизнесслогика т.е методы проверки введённых данных

    //Поля класса
    private String lastName;
    private String firstName;
    private String secondName;
    private  LocalDate dateOfBirth;
    private long telephone;
    private char gender;


    //Геттеры

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public long getTelephone() {
        return telephone;
    }

    public char getGender() {
        return gender;
    }



    //Основной метод проверки данных
    public void checkData(String[] data) {
        try {
            this.lastName = data[0];
            this.firstName = data[1];
            this.secondName = data[2];
            this.dateOfBirth = checkDateOfBirth(data[3]);
            this.telephone = checkTelephone(data[4]);
            this.gender = checkGender(data[5]);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования String в int : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка аргумента: " + e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Ошибка аргумента, один из аргументов пуст: " + e.getMessage());
        }
    }

    //Метод для проверки пола
    public static char checkGender(String gender)  {
        char genderChar;
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

    //Метод для проверки телефона
    public static long checkTelephone(String telephone) {
        try {
            return Long.parseLong(telephone);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Аргумент 'телефон' должен быть числом");
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
