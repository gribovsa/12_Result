package view;


import java.util.Scanner;


public class ConsoleView {
    public static final int SIZE_LINE = 120;
    public static final String COLUMN_HEADER_FORMAT = "%-6s%-12s%-8s%-18s%-15s%-15s%-15s%-15s";
    public static final String GREEN_COLOR = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";


    public Integer mainMenu() {
        printColorLine("Доступные действия:", GREEN_COLOR);
        System.out.println("1 - [Добавить животное], 2 - [Показать навыки животного], 3 - [Добавить навык животному], 0 - [Выход]");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        // scanner.close();
        if (data.equals("1")) {
            return 1;
        } else {
            if (data.equals("2")) {
                return 2;
            } else {
                if (data.equals("3")) {
                    return 3;
                } else {
                    if (data.equals("0")) {
                        return 0;
                    }
                    return 100;
                }
            }
        }
    }


    public String[] inputDate() {
        System.out.println("Введите данные в виде 7 аргументов, разделённых запятой (можно запятой и пробелом):");
        System.out.println("Кличка, Пол, Дата Рождения, Класс, Вид, Порода, Тип животного");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        // scanner.close();

        try {
            if (data.isEmpty()) {
                throw new IllegalArgumentException("Вы ничего не ввели!");
            }
            String[] dataArray = data.split(",");
            for (int i = 0; i < dataArray.length; i++) { //очищу элементы от возможных пробелов в начале и конце строки
                dataArray[i] = dataArray[i].trim();
            }
            if (dataArray.length != 7) {
                throw new IllegalArgumentException("Неверное количество введённых данных, должно быть 7 аргументов!");
            }
            return dataArray;
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка на этапе ввода данных: " + e.getMessage());
            return null;
        }
    }

    public String[] inputSkill() {
        System.out.println("Введите индекс животного, двоеточие, и перечислите через запятую навыки");
        System.out.println("N: навык1, навык2, навык3.....");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        // scanner.close();

        try {
            if (data.isEmpty()) {
                throw new IllegalArgumentException("Вы ничего не ввели!");
            }
            String[] dataArray = data.split(":");
            for (int i = 0; i < dataArray.length; i++) { //очищу элементы от возможных пробелов в начале и конце строки
                dataArray[i] = dataArray[i].trim();
            }
            if (dataArray.length != 2) {
                throw new IllegalArgumentException("Вы неверно ввели данные");
            }
            return dataArray;
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка на этапе ввода данных: " + e.getMessage());
            return null;
        }
    }

    public Integer viewSkillMenu() {
        printColorLine("Доступные действия:", GREEN_COLOR);
        System.out.println("1 - [Вернуться в главное меню], Любой символ - [Выйти]]");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        // scanner.close();
        try{
            if(Integer.parseInt(data) == 1){
                return Integer.parseInt(data);
            }else {
                return 0;
            }
        }catch (NumberFormatException e) {
            //System.out.println("Вы ввели недопустимое значение: " + e.getMessage());
            return 0;
        }
    }

    //метод возвращает номер животного, для которого осуществить поиск навыков
    public Integer getNumFindAnimal() {
        try {
            System.out.println("Введите индекс животного, для которого показать навыки");
            Scanner scanner = new Scanner(System.in);
            String data = scanner.nextLine();
            //scanner.close();
            return Integer.parseInt(data);
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели недопустимое значение: " + e.getMessage());
            return null;
        }

    }
    //методы используемые для формления
    private void printColorLine (String row, String displayColor){
        System.out.printf("%s%s%s\n", displayColor, row, ANSI_RESET);
    }
}