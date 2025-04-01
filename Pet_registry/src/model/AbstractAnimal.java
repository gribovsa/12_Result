package model;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AbstractAnimal {


    //Поля класса
    private String nickName;
    private Character gender;
    private LocalDate dateOfBirth;
    private String classAnimal;
    private String speciesAnimal;
    private String breedAnimal;
    private String animalType;

    private String animalId;
    private String skillName;


//Геттеры

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

    public String getId() {
        return animalId;
    }

    public String getSkillName() {
        return skillName;
    }



    //Методы проверки введённых данных

    //Основной метод проверки данных
    public void checkData(String[] data) throws IOException {
        try {

            this.nickName = data[0];
            this.gender = checkGender(data[1]);
            this.dateOfBirth = checkDateOfBirth(data[2]);
            this.classAnimal = data[3];
            this.speciesAnimal = data[4];
            this.breedAnimal = data[5];
            this.animalType = data[6];

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

            if (!((gender.equals("м")) || (gender.equals("ж")))) {
                throw new IllegalArgumentException("Аргумент 'пол' должен принимать значение 'м' или 'ж'");
            } else {
                genderChar = gender.toLowerCase().charAt(0);
                return genderChar;
            }
        }
    }


    //Метод проверки даты
    public static LocalDate checkDateOfBirth(String dateOfBirth)  {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateOfBirth, formatter);
        } catch (DateTimeParseException e){ //ловлю ошибку парсинга
            throw new IllegalArgumentException("Введите дату в формате yyyy-MM-dd Ошибка: " + e.getMessage());
        }
    }

    //Метод для проверки числа
    public static String checkNumber(String number) {
        try {
            return String.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Аргумент должен быть числом");
        }
    }

    //Метод ля проверки навыков (пока что проверяю только id  животного, чтобы введённое зн-е было число)
    public void checkSkill(String[]data){
     try {
         this.animalId = checkNumber(data[0]);
         this.skillName = data[1];
     } catch (NumberFormatException e) {
         System.out.println("Ошибка преобразования String в int : " + e.getMessage());
     } catch (IllegalArgumentException e) {
         System.out.println("Ошибка аргумента: " + e.getMessage());
     } catch (NullPointerException e){
         System.out.println("Ошибка аргумента, один из аргументов пуст: " + e.getMessage());
     }
    }

}
