package homework.lesson1.main.Marathon;

public class Course {
    Obstacle[] course = new Obstacle[4];

    public Course(Obstacle... obstacles){
        for (int i = 0; i < 4; i++){
            this.course[i] = obstacles[i];
        }
    }

    public void doIt(Competitor...competitors){
        System.out.println("Протокол прохождения полосы препятствий участниками:");
        for (Competitor c: competitors)
            for (Obstacle o: course){
                o.doIt(c);
        }
    }
}
