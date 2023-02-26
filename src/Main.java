import appearsln.*;
import java.time.*;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Task> taskMap = new ConcurrentHashMap<>(100);
        ArrayList<Task> deleteTaskHistory = new ArrayList<>();
        Date currentDate = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());
        LocalDate ldt1 = ldt.toLocalDate();
        taskMap.put(Task.getIde(), new Task("W", LocalDateTime.of(2023, 03, 21, 05, 00, 00), Type.PERSONAL, "sdsdsdd", Appearsln.WeaklyTask));
        taskMap.put(Task.getIde(), new Task("Y2", LocalDateTime.of(2023, 03, 22, 05, 00, 00), Type.PERSONAL, "sdsdsdd", Appearsln.YearlyTask));
        taskMap.put(Task.getIde(), new Task("W2", LocalDateTime.of(2023, 03, 23, 05, 00, 00), Type.PERSONAL, "sdsdsdd", Appearsln.WeaklyTask));
        taskMap.put(Task.getIde(), new Task("D1", LocalDateTime.of(2023, 03, 24, 05, 00, 00), Type.WORK, "sdsdsdd", Appearsln.DailyTasc));
        taskMap.put(Task.getIde(), new Task("O", LocalDateTime.of(2023, 03, 01, 05, 00, 00), Type.PERSONAL, "sdsdsdd",Appearsln. OneTimeTack));
        taskMap.put(Task.getIde(), new Task("D2", LocalDateTime.of(2023, 03, 25, 05, 00, 00), Type.PERSONAL, "sdsdsdd", Appearsln.DailyTasc));
        taskMap.put(Task.getIde(), new Task("M", LocalDateTime.of(2023, 03, 24, 05, 00, 00), Type.PERSONAL, "sdsdsdd", Appearsln.MonthlyTack));
        taskMap.put(Task.getIde(), new Task("Y", LocalDateTime.of(2023, 03, 20, 05, 00, 00), Type.PERSONAL, "sdsdsdd", Appearsln.YearlyTask));
        taskMap.put(Task.getIde(), new Task("D3", LocalDateTime.of(2023, 03, 25, 05, 00, 00), Type.PERSONAL, "sdsdsdd", Appearsln.DailyTasc));
        addTask(taskMap, ldt1);
        gener(taskMap);
        Collection<Task> values = taskMap.values();
        ArrayList<Task> listOfValues = new ArrayList<>(values);
         ByAllByDate(listOfValues,dateScan());
         //deleteTaskHistory(taskMap,deleteTaskHistory);
        // restoreTaskHistory(taskMap,deleteTaskHistory);
       // AperTimeTack(listOfValues);

    }





     public static void addTask(Map map, LocalDate ltd1) {
        map.put(Task.getIde(), new Task(titleScan(), addDateTime(ltd1), workPersTiket(), disSkan(), appAper()));
    }

    public static Appearsln appAper(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Задачу с какой повторяемостью вы хотите создать: " + "\n" +  "1 - ежедневый повтор. " +"\n"+
                "2 - повтор раз в неделю" +"\n"+
                "3 - повтор раз в месяц " +"\n"+
                "4 - повтор один раз в год." +"\n"+
                " Если ни чего не выбрать зада не будет повторятся");
        String str = scan.nextLine();
        if (str.equals("1")) {
            return Appearsln.DailyTasc;
        }
        if (str.equals("2")) {
            return Appearsln.WeaklyTask;
        }
        if (str.equals("3")) {
            return Appearsln.MonthlyTack;
        }
        if (str.equals("4")) {
            return Appearsln.YearlyTask;
        }
        return Appearsln.OneTimeTack;
    }


    public static LocalDateTime addDateTime(LocalDate ltd1) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите дату и время в формате [yyyy-MM-dd HH:mm] ");
        String str = scan.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime formatDateTime = LocalDateTime.parse(str, formatter);
        LocalDate formatDateTime1 = formatDateTime.toLocalDate();
        try {
            addDateTimeС(formatDateTime1, ltd1);
        } catch (Exp e) {
            System.out.println("Не верно, Введите повторно коректно дату");
            String str1 = scan.nextLine();
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime formatDateTimeC = LocalDateTime.parse(str1, formatter1);
            return formatDateTimeC;
        }
        return formatDateTime;
    }

    public static Type workPersTiket() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Какую задачу вы хотите создать, по умолчанию создается личная задача, для создания рабочей задаче введите  Р ");
        String str = scan.nextLine();
        if (str.equals("P")) {
            return Type.PERSONAL;
        }
        return Type.WORK;
    }

    public static void addDateTimeС(LocalDate ltd1, LocalDate ltd2) throws Exp {
        if (ltd1.isBefore(ltd2)) {
            throw new Exp();

        }
    }

    public static String titleScan() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название задачи");
        String str = scan.nextLine();
        return str;
    }

    public static String disSkan() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите описание задачи");
        String str = scan.nextLine();
        return str;
    }


    public static void ByAllByDate(ArrayList<Task> listOfValues, LocalDate date) {
        for (int i = 0; i < listOfValues.size(); i++) {
            LocalDate dateList = listOfValues.get(i).getDateTime().toLocalDate();
            if (dateList.isEqual(date)) {
                System.out.println(listOfValues.get(i).getDateTime() + " " + listOfValues.get(i).getTitle());
            }

        }
        NoByAllByDate(listOfValues, date);
    }

    public static void NoByAllByDate(ArrayList<Task> listOfValues, LocalDate date) {
        for (int i = 0; i < listOfValues.size(); i++) {
            LocalDate dateList = listOfValues.get(i).getDateTime().toLocalDate();
            if (!dateList.isEqual(date)) {
            }
        }
    }

    public static LocalDate dateScan() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите дату для поиска задач [yyyy-MM-dd] ");
        String str = scan.nextLine();
        LocalDate formatDateTime = LocalDate.parse(str);
        return formatDateTime;
    }

    public static void gererikTaskD(Map<Integer, Task> taskMap) {
            for (Map.Entry<Integer, Task> task : taskMap.entrySet()) {
                if (task.getValue().getAppearsln() == Appearsln.DailyTasc) {
                    taskMap.put(Task.getIde(), new Task(task.getValue().getTitle(), task.getValue().getDateTime().plusDays(1),
                            task.getValue().getType(), task.getValue().getDeccription(), task.getValue().getAppearsln()));
                }
            }
        }




    public static void gererikTaskW(Map<Integer, Task> taskMap) {
            for (Map.Entry<Integer, Task> task : taskMap.entrySet()) {
                if (task.getValue().getAppearsln() == Appearsln.WeaklyTask) {
                    taskMap.put(Task.getIde(), new Task(task.getValue().getTitle(), task.getValue().getDateTime().plusWeeks(1),
                            task.getValue().getType(), task.getValue().getDeccription(), task.getValue().getAppearsln()));


                }

        }
                }
    public static void gererikTaskM(Map<Integer, Task> taskMap) {
        for (Map.Entry<Integer, Task> task : taskMap.entrySet()) {
            if (task.getValue().getAppearsln() == Appearsln.MonthlyTack) {
                taskMap.put(Task.getIde(), new Task(task.getValue().getTitle(), task.getValue().getDateTime().plusMonths(1),
                        task.getValue().getType(), task.getValue().getDeccription(), task.getValue().getAppearsln()));


            }
        }
    }
    public static void gererikTaskY(Map<Integer, Task> taskMap) {
        for (Map.Entry<Integer, Task> task : taskMap.entrySet()) {
            if (task.getValue().getAppearsln() == Appearsln.YearlyTask) {
                taskMap.put(Task.getIde(), new Task(task.getValue().getTitle(), task.getValue().getDateTime().plusYears(1),
                        task.getValue().getType(), task.getValue().getDeccription(), task.getValue().getAppearsln()));


            }
        }
    }
                public static void gener(Map<Integer, Task> taskMap) {
                        gererikTaskD(taskMap);
                        gererikTaskW(taskMap);
                        gererikTaskM(taskMap);
                        gererikTaskY(taskMap);
                    }

    public static void DailyTasc(Appearsln DailyTasc, ArrayList<Task> listOfValues) {
        for (int i = 0; i < listOfValues.size(); i++) {
            if (DailyTasc == listOfValues.get(i).getAppearsln()) {
                LocalDateTime dateList = listOfValues.get(i).getDateTime().plusDays(1);
                System.out.println("Следующий повтор задачи " + listOfValues.get(i).getTitle() + " " + dateList);

            }
        }
    }

    public static void MonthlyTack(Appearsln MonthlyTack, ArrayList<Task> listOfValues) {
        for (int i = 0; i < listOfValues.size(); i++) {
            if (MonthlyTack == listOfValues.get(i).getAppearsln()) {
                LocalDateTime dateList = listOfValues.get(i).getDateTime().plusMonths(1);
                System.out.println("Следующий повтор задачи " + listOfValues.get(i).getTitle() + " " + dateList);

            }
        }
    }

    public static void WeaklyTask(Appearsln WeaklyTask, ArrayList<Task> listOfValues) {
        for (int i = 0; i < listOfValues.size(); i++) {
            if (WeaklyTask == listOfValues.get(i).getAppearsln()) {
                LocalDateTime dateList = listOfValues.get(i).getDateTime().plusWeeks(1);
                System.out.println("Следующий повтор задачи " + listOfValues.get(i).getTitle() + " " + dateList);

            }
        }
    }

    public static void YearlyTask(Appearsln YearlyTask, ArrayList<Task> listOfValues) {
        for (int i = 0; i < listOfValues.size(); i++) {
            if (YearlyTask == listOfValues.get(i).getAppearsln()) {
                LocalDateTime dateList = listOfValues.get(i).getDateTime().plusYears(1);
                System.out.println("Следующий повтор задачи " + listOfValues.get(i).getTitle() + " " + dateList);

            }
        }
    }

    public static void OneTimeTack(Appearsln OneTimeTack, ArrayList<Task> listOfValues) {
        for (int i = 0; i < listOfValues.size(); i++) {
            if (OneTimeTack == listOfValues.get(i).getAppearsln()) {
                System.out.println("Данная задача не повторяетчся " + listOfValues.get(i).getTitle() + " " + listOfValues.get(i).getDateTime());

            }
        }
    }

    public static void AperTimeTack(ArrayList<Task> listOfValues){
        for (int i = 0; i < listOfValues.size(); i++) {
            if (Appearsln.OneTimeTack == listOfValues.get(i).getAppearsln()){
                System.out.println("Данная задача не повторяетчся " + listOfValues.get(i).getTitle() + " " + listOfValues.get(i).getDateTime());
            }
            if (Appearsln.YearlyTask == listOfValues.get(i).getAppearsln()) {
                LocalDateTime dateList = listOfValues.get(i).getDateTime().plusYears(1);
                System.out.println("Следующий повтор задачи " + listOfValues.get(i).getTitle() + " " + dateList);
            }
            if (Appearsln.WeaklyTask == listOfValues.get(i).getAppearsln()) {
                LocalDateTime dateList = listOfValues.get(i).getDateTime().plusWeeks(1);
                System.out.println("Следующий повтор задачи " + listOfValues.get(i).getTitle() + " " + dateList);
            }
            if (Appearsln.MonthlyTack == listOfValues.get(i).getAppearsln()) {
                LocalDateTime dateList = listOfValues.get(i).getDateTime().plusMonths(1);
                System.out.println("Следующий повтор задачи " + listOfValues.get(i).getTitle() + " " + dateList);
            }
                if (Appearsln.DailyTasc == listOfValues.get(i).getAppearsln()) {
                    LocalDateTime dateList = listOfValues.get(i).getDateTime().plusDays(1);
                    System.out.println("Следующий повтор задачи " + listOfValues.get(i).getTitle() + " " + dateList);
                }
        }
    }


    public static void deleteTaskHistory(Map<Integer, Task> taskMap, ArrayList<Task> historyDelete) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ID задачи для удаления");
        int id = Integer.parseInt(scan.nextLine());
            System.out.println("Удалена и перенесена в архив задача с ID " + taskMap.get(id).getId());
            historyDelete.add(taskMap.get(id));
            taskMap.remove(id);
            for (int i = 0; i < historyDelete.size(); i++) {
                taskPrint(historyDelete);
            }
            System.out.println("------------------");
            for (Map.Entry<Integer, Task> task : taskMap.entrySet()) {
                System.out.println(task.getKey() + " " + task.getValue());
        }


    }

    public static void delExp(Map<Integer, Task> taskMap, int test) throws Exp {
        Collection<Task> values = taskMap.values();
        ArrayList<Task> listOfValues = new ArrayList<>(values);
        for (int i = 0; i < listOfValues.size(); i++) {
            if (test != listOfValues.get(i).getId()){
                throw new Exp();
            }
        }
    }

    public static void restoreTaskHistory(Map<Integer, Task> taskMap, ArrayList<Task> historyDelete) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ID задачи для востановления");
        int id = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < historyDelete.size(); i++) {
            taskMap.put(historyDelete.get(id).getId(), historyDelete.get(i));
            System.out.println("Востановлена задача задача с ID ");
            taskPrint(historyDelete);
        }
        for (Map.Entry<Integer, Task> task : taskMap.entrySet()) {
            System.out.println(task.getKey() + " " + task.getValue());
        }
    }

    public static void taskPrint(ArrayList<Task> listOfValues) {
        Consumer<Task> taskConsumer = task -> System.out.println(task.getId() + " " + task.getTitle()
                + " " + task.getDateTime() + " " + task.getDeccription());
        for (Task task : listOfValues)
            taskConsumer.accept(task);
    }




}

