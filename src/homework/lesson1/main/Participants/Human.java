package homework.lesson1.main.Participants;

import homework.lesson1.main.Marathon.Competitor;

public class Human implements Competitor {
    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean active;

    @Override
    public boolean isOnDistance() {
        return active;
    }

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxJumpHeight = 30;
        this.maxSwimDistance = 200;
        this.active = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " хорошо справился с кроссом");
        } else {
            System.out.println(name + " не справился с кроссом");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " удачно перепрыгнул через стену");
        } else {
            System.out.println(name + " не смог перепрыгнуть стену");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwimDistance) {
            System.out.println(name + " отлично проплыл");
        } else {
            System.out.println(name + " не смог проплыть");
            active = false;
        }
    }

    @Override
    public void info() {
        if(active) {
            System.out.println(name  + " преодолел полосу препятствий");
        } else {
            System.out.println(name  + " не преодолел полосу препятствий");
        }
    }

    @Override
    public void infoAboutCompetitors() {
        System.out.println(name + ": " + "макс. дистанция кросса - " + maxRunDistance + ", " +
                "макс. высота прыжка - " + maxJumpHeight + ", " + "макс. дистанция заплыва - " + maxSwimDistance);
    }
}