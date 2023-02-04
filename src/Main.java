import appearsln.Appearsln;
import appearsln.OneTimeTack;
import appearsln.WeaklyTask;
import appearsln.YearlyTask;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Appearsln WeaklyTask = new WeaklyTask(true);
        Appearsln YearlyTask = new YearlyTask(true);
        Appearsln OneTimeTack = new OneTimeTack(true);
        Map<Integer, Task> taskMap = new HashMap<>();
        LocalDateTime time = LocalDateTime.of(2022, 03, 23, 05, 00, 00);
        taskMap.put(Task.ide, new Task("sdsd", LocalDateTime.of(2023, 01, 20, 05, 00, 00), "sdsdsdd", WeaklyTask));
        taskMap.put(Task.ide, new Task("sdDDsd", LocalDateTime.of(2022, 03, 23, 05, 00, 00), "sdsdsdd", YearlyTask));
        taskMap.put(Task.ide, new Task("sdFFFsd", LocalDateTime.of(2022, 04, 20, 05, 00, 00), "sdsdsdd", OneTimeTack));
        taskMap.put(Task.ide, new Task("sdFFFsdddd", LocalDateTime.of(2022, 03, 23, 05, 00, 00), "sdsdsdd", OneTimeTack));
        // addTask(taskMap, WeaklyTask);
        // проверка
        //time(taskMap);
        ByAllByDate(taskMap, time);


    }


    public static void addTask(Map map, Appearsln appearsln) {
        map.put(Task.ide, new Task(titleScan(), addDateTime(), disSkan(), appearsln));
    }

    public static LocalDateTime addDateTime() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите дату и время в формате [yyyy-MM-dd HH:mm] ");
        String str = scan.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime formatDateTime = LocalDateTime.parse(str, formatter);
        return formatDateTime;
    }

    public static String titleScan() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название задачи");
        String str = scan.nextLine();
        return str;
    }

    public static String disSkan() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите описагие задачи");
        String str = scan.nextLine();
        return str;
    }

    public static void ByAllByDate(Map<Integer, Task> taskMap, LocalDateTime l) {
        for (Map.Entry<Integer, Task> task : taskMap.entrySet()) {
            System.out.println("Заплонировано на " + task.getValue().getDateTime() + " задача/задачи"
                    + task.getKey() + " " + task.getValue());
        }
    }


    public static LocalDateTime ldt() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите дату для задач [yyyy-MM-dd] ");
        String str = scan.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime formatDateTime = LocalDateTime.parse(str, formatter);
        return formatDateTime;
    }

    //public static LocalDateTime time(Map<Integer, Task> taskMap) {
    //      LocalDateTime ltd = LocalDateTime.now();

    //  for (Map.Entry<Integer, Task> task : taskMap.entrySet()) {
    //     ltd = task.getValue().getDateTime();
    //    System.out.println(ltd);
    //  } return ltd;
    // }
    // }
}





