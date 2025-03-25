package view;

import java.util.Scanner;

public class ConsoleView {
    public static final int SIZE_LINE = 80;
    public static final String ROW_FORMAT = "%-6d%-16s%-20s%-20d%-20s";
    public static final String COLUMN_HEADER_FORMAT = "%-6s%-16s%-20s%-20s%-20s";



    public String[] inputDate() {
        System.out.println("Введите данные в виде 6 аргументов:");
        System.out.println("Фамилия Имя Отчество датарождения номертелефона пол");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        scanner.close();

        try {
            if (data.isEmpty()){
                throw new IllegalArgumentException("Вы ничего не ввели!");
            }
            String[] dataArray = data.split(" ");

            if (dataArray.length != 6) {
                throw new IllegalArgumentException("Неверное количество введённых данных, должно быть 6 аргументов!");
            }
            return dataArray;
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка на этапе ввода данных: " + e.getMessage());
            return null;
        }
    }



    public void showPetRegistry(){
        clearConsole();
        printLineWithSymbol("=", 80);
        printCaption("Питомник животных (Демо версия)", " ");
        printLineWithSymbol("=", 80);
        printRegistryHeader();
        printLineWithSymbol("-", 80);
        System.out.println("здесь будет механизм чтения из файла");
    }


    //для создания красоты

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
        String header = String.format(COLUMN_HEADER_FORMAT, "№", "Имя", "Дата рождения", "Возраст(в месяцах)",
                "Род животного");
        System.out.println(header);
    }
}
