package view;

import services.FileOperations;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleView {
    public static final int SIZE_LINE = 120;
    public static final String COLUMN_HEADER_FORMAT = "%-6s%-12s%-8s%-18s%-15s%-15s%-15s%-15s";




    public String[] inputDate() {
        System.out.println("Введите данные в виде 8 аргументов, разделённых пробелом:");
        System.out.println("№     Кличка      Пол     Дата Рождения     Класс          Вид            Порода         Тип животного");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        scanner.close();

        try {
            if (data.isEmpty()){
                throw new IllegalArgumentException("Вы ничего не ввели!");
            }
            String[] dataArray = data.split(" ");

            if (dataArray.length != 8) {
                throw new IllegalArgumentException("Неверное количество введённых данных, должно быть 8 аргументов!");
            }
            return dataArray;
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка на этапе ввода данных: " + e.getMessage());
            return null;
        }
    }

}
