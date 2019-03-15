package homework.lesson2.EnumProject;

/*
Требуется реализовать enum DayOfWeek, который будет представлять дни недели.
        С его помощью необходимо решить задачу определения кол-ва рабочих часов до конца недели
        по заднному текущему дню.
        Возвращает кол-во оставшихся рабочих часов до конца
        недели по заданному текущему дню. Считается, что
        текущий день ещё не начался, и рабочие часы за него
        должны учитываться.

public class DayOfWeekMain {

    public static void main(final String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
    }
*/

public class Main {
    public static void main(String[] args){
        DayOfWeek.getWorkingHours(DayOfWeek.Monday);
        DayOfWeek.getWorkingHours(DayOfWeek.Tuesday);
        DayOfWeek.getWorkingHours(DayOfWeek.Wednesday);
        DayOfWeek.getWorkingHours(DayOfWeek.Thursday);
        DayOfWeek.getWorkingHours(DayOfWeek.Friday);
        DayOfWeek.getWorkingHours(DayOfWeek.Saturday);
        DayOfWeek.getWorkingHours(DayOfWeek.Sunday);
    }
}
