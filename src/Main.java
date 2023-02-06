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
        int delete = 2;
        Appearsln WeaklyTask = new WeaklyTask(true);
        Appearsln YearlyTask = new YearlyTask(true);
        Appearsln OneTimeTack = new OneTimeTack(true);
        Map<Integer, Task> taskMap = new HashMap<>();
        LocalDate date = LocalDate.of(2022, 4, 23);
        taskMap.put(Task.ide, new Task("sdsd", LocalDateTime.of(2023, 01, 20, 05, 00, 00), "sdsdsdd", WeaklyTask));
        taskMap.put(Task.ide, new Task("sdDDsd", LocalDateTime.of(2022, 03, 23, 05, 00, 00), "sdsdsdd", YearlyTask));
        taskMap.put(Task.ide, new Task("sdFFFsd", LocalDateTime.of(2022, 04, 20, 05, 00, 00), "sdsdsdd", OneTimeTack));
        taskMap.put(Task.ide, new Task("sdFFFsdddd", LocalDateTime.of(2022, 03, 23, 05, 00, 00), "sdsdsdd", OneTimeTack));
        // ++ addTask(taskMap, WeaklyTask);
        Collection<Task> values = taskMap.values();
        ArrayList<Task> listvalues = new ArrayList<>(values);
        ByAllByDate(listvalues,date);
        //++ deleteTask(taskMap, delete);



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

    public static void ByAllByDate(ArrayList<Task> listvalues, LocalDate date) {
        for (int i = 0; i< listvalues.size(); i++){
            LocalDate dateList = listvalues.get(i).getDateTime().toLocalDate();
            if (dateList.isEqual(date)){
                System.out.println(listvalues.get(i).getDateTime());
            }
        }
        NoByAllByDate(listvalues,date);
    }
public static void NoByAllByDate(ArrayList<Task> listvalues, LocalDate date){
    for (int i = 0; i< listvalues.size(); i++){
        LocalDate dateList = listvalues.get(i).getDateTime().toLocalDate();
        if (!dateList.isEqual(date)){
        }
    } System.out.println("no");
}



    public static void deleteTask(Map<Integer, Task> taskMap, int i) {
        System.out.println("delete task " + taskMap.get(i));
        taskMap.remove(i);
        for (Map.Entry<Integer, Task> task : taskMap.entrySet()) {
            System.out.println(task.getKey() + " " + task.getValue());
        }


    }
}



    //public static LocalDateTime time(Map<Integer, Task> taskMap) {
    //      LocalDateTime ltd = LocalDateTime.now();

    //  for (Map.Entry<Integer, Task> task : taskMap.entrySet()) {
    //     ltd = task.getValue().getDateTime();
    //    System.out.println(ltd);
    //  } return ltd;
    // }
    // }



 //   LocalDateTime now = LocalDateTime.now(); // 2018-01-21T09:11:48.486298
 //   LocalDateTime minusNanos = now.plusNanos(780_000_000); // 2018-01-21T09:11:49.266298
 //   LocalDateTime minusSeconds = now.plusSeconds(59); // 2018-01-21T09:12:47.486298
 //   LocalDateTime minusMinutes = now.plusMinutes(5); // 2018-01-21T09:16:48.486298
 //   LocalDateTime minusHours = now.plusHours(3); // 2018-01-21T12:11:48.486298
 //   LocalDateTime minusDays = now.plusDays(7); // 2018-01-28T09:11:48.486298
 //   LocalDateTime minusWeeks = now.plusWeeks(3); // 2018-02-11T09:11:48.486298
 //   LocalDateTime minusMonths = now.plusMonths(5); // 2018-06-21T09:11:48.486298
 //   LocalDateTime minusYears = now.plusYears(2); // 2020-01-21T09:11:48.486298
 //   LocalDateTime minusPeriod = now.plus(Period.ofWeeks(2)); // 2018-02-04T09:11:48.486298
 //   LocalDateTime minusDecades = now.plus(1, ChronoUnit.DECADES); // 2028-01-21T09:11:48.486298







