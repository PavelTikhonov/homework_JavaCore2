package homework.lesson2.EnumProject;

public enum  DayOfWeek {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

    public static void getWorkingHours(Enum dayNumber){
        if(dayNumber.ordinal() < Saturday.ordinal())
        {
            System.out.println("Текущий день - " + dayNumber);
            System.out.println("Количество рабочих часов до конца недели = " + (40 - dayNumber.ordinal() * 8));
        } else {
            System.out.println("Выходной день - " + dayNumber);
        }
    }
}
