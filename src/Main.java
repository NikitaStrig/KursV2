import appearsln.*;
import java.time.*;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Appearsln WeaklyTask = new WeaklyTask(true);
        Appearsln YearlyTask = new YearlyTask(true);
        Appearsln OneTimeTack = new OneTimeTack(true);
        Appearsln DailyTasc = new DailyTasc(true);
        Appearsln MonthlyTack = new MonthlyTack(true);
        Map<Integer, Task> taskMap = new HashMap<>();
        ArrayList<Task> deleteTaskHistory = new ArrayList<>();
        Date currentDate = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());
        LocalDate ldt1 = ldt.toLocalDate();
        taskMap.put(Task.ide, new Task("sdsd", LocalDateTime.of(2023, 01, 20, 05, 00, 00),Type.PERSONAL, "sdsdsdd", WeaklyTask));
        taskMap.put(Task.ide, new Task("sdDDsd", LocalDateTime.of(2022, 03, 23, 05, 00, 00),Type.WORK ,"sdsdsdd",YearlyTask ));
        taskMap.put(Task.ide, new Task("sdFFFsd", LocalDateTime.of(2022, 04, 20, 05, 00, 00),Type.PERSONAL,"sdsdsdd", OneTimeTack));
        taskMap.put(Task.ide, new Task("sdFFFsdddd", LocalDateTime.of(2022, 03, 23, 05, 00, 00),Type.WORK,"sdsdsdd", DailyTasc));

        addTask(taskMap, OneTimeTack,ldt1);
        Collection<Task> values = taskMap.values();
        ArrayList<Task> listOfValues = new ArrayList<>(values);
        for (int i = 0; i < listOfValues.size(); i++) {
            System.out.println(listOfValues.get(i));
        }
       // ByAllByDate(listOfValues,dateScan());
       //  deleteTaskHistory(taskMap,deleteTaskHistory);
        // restoreTaskHistory(taskMap,deleteTaskHistory);
        // AperTimeTack(OneTimeTack, MonthlyTack, WeaklyTask, YearlyTask, DailyTasc,listOfValues);

    }


    public static void addTask(Map map, Appearsln appearsln,LocalDate ltd1 ) {
        map.put(Task.ide, new Task(titleScan(), addDateTime(ltd1),workPersTiket(), disSkan(), appearsln));
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
      // Type rte = Type.WORK;
        Scanner scan = new Scanner(System.in);
        System.out.print("Кукую задачу вы хотите создать L - Личная  Р - рабочая");
        String str = scan.nextLine();
        if (str.equals("P")){
            return Type.PERSONAL;}
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
        NoByAllByDate(listOfValues,date);
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

    public static void DailyTasc(Appearsln DailyTasc, ArrayList<Task> listOfValues ) {
        for (int i = 0; i < listOfValues.size(); i++) {
            if (DailyTasc == listOfValues.get(i).getAppearsln() ){
                LocalDateTime dateList = listOfValues.get(i).getDateTime().plusDays(1);
                System.out.println("Следующий повтор задачи "+ listOfValues.get(i).getTitle() + " " + dateList);

            }
        }
    }

    public static void MonthlyTack(Appearsln MonthlyTack, ArrayList<Task> listOfValues ) {
        for (int i = 0; i < listOfValues.size(); i++) {
            if (MonthlyTack == listOfValues.get(i).getAppearsln() ){
                LocalDateTime dateList = listOfValues.get(i).getDateTime().plusMonths(1);
                System.out.println("Следующий повтор задачи "+ listOfValues.get(i).getTitle() + " " + dateList);

            }
        }
    }
    public static void WeaklyTask(Appearsln WeaklyTask, ArrayList<Task> listOfValues ) {
        for (int i = 0; i < listOfValues.size(); i++) {
            if (WeaklyTask == listOfValues.get(i).getAppearsln() ){
                LocalDateTime dateList = listOfValues.get(i).getDateTime().plusWeeks(1);
                System.out.println("Следующий повтор задачи "+ listOfValues.get(i).getTitle() + " " + dateList);

            }
        }
    }
    public static void YearlyTask(Appearsln YearlyTask, ArrayList<Task> listOfValues ) {
        for (int i = 0; i < listOfValues.size(); i++) {
            if (YearlyTask == listOfValues.get(i).getAppearsln() ){
                LocalDateTime dateList = listOfValues.get(i).getDateTime().plusYears(1);
                System.out.println("Следующий повтор задачи " + listOfValues.get(i).getTitle() + " " + dateList);

            }
        }
    }
    public static void OneTimeTack(Appearsln OneTimeTack, ArrayList<Task> listOfValues ) {
        for (int i = 0; i < listOfValues.size(); i++) {
            if (OneTimeTack == listOfValues.get(i).getAppearsln() ){
                System.out.println("Данная задача не повторяетчся " + listOfValues.get(i).getTitle() + " " + listOfValues.get(i).getDateTime());

            }
        }
    }
    public static void AperTimeTack(Appearsln OneTimeTack,
                                    Appearsln MonthlyTack,
                                    Appearsln WeaklyTask,
                                    Appearsln YearlyTask,
                                    Appearsln DailyTasc,
                                    ArrayList<Task> listOfValues) {
        DailyTasc(DailyTasc, listOfValues);
        MonthlyTack(MonthlyTack, listOfValues);
        WeaklyTask(WeaklyTask, listOfValues);
        YearlyTask(YearlyTask, listOfValues);
        OneTimeTack(OneTimeTack,  listOfValues);
    }




    public static void deleteTaskHistory(Map<Integer, Task> taskMap,ArrayList<Task> historyDelete) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ID задачи для удаления");
        int id = Integer.parseInt(scan.nextLine());
        try {
            delExp(taskMap,id);
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
        } catch (Exp e) {
            System.out.println("Задачи с таким ID не существует, повторите попытку");
            int id1 = Integer.parseInt(scan.nextLine());
            System.out.println("Удалена и перенесена в архив задача с ID " + taskMap.get(id1).getId());
            historyDelete.add(taskMap.get(id1));
            taskMap.remove(id1);
            for (int i = 0; i < historyDelete.size(); i++) {
                taskPrint(historyDelete);
            }
            System.out.println("------------------");
            for (Map.Entry<Integer, Task> task : taskMap.entrySet()) {
                System.out.println(task.getKey() + " " + task.getValue());
            }
        }


    }

    public static void delExp(Map<Integer, Task> taskMap, int test ) throws Exp {
        for (Map.Entry<Integer, Task> task : taskMap.entrySet())  {
            if (task.getKey() != test)
                throw new Exp();
        }
    }
    public static void restoreTaskHistory(Map<Integer, Task> taskMap,ArrayList<Task> historyDelete) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ID задачи для востановления");
        int id = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < historyDelete.size(); i++) {
            taskMap.put(historyDelete.get(i).getId(),historyDelete.get(i));
            System.out.println("Востановлена задача задача с ID ");
            taskPrint(historyDelete);
        }
        for (Map.Entry<Integer, Task> task : taskMap.entrySet()) {
            System.out.println(task.getKey() + " " + task.getValue());
        }
    }
public static void taskPrint(ArrayList<Task> listOfValues){
    Consumer<Task> taskConsumer = task -> System.out.println(task.getId() +" " + task.getTitle()
    + " " + task.getDateTime() + " " + task.getDeccription());
    for (Task task : listOfValues)
        taskConsumer.accept(task);
}

}

