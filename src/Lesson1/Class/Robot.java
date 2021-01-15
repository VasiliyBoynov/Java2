package Lesson1.Class;

import Lesson1.Interface.Action;

public class Robot implements Action {

    private String name;
    private boolean isRady = true ;
    private final int maxDist;
    private final int maxHeight;
    public final String nameClass = "Робот";

    public Robot(String name, int maxDist, int maxHeight) {
        this.name = name;
        this.maxDist = maxDist;
        this.maxHeight = maxHeight;
    }

    public Robot(String name) {
        this.name = name;
        this.maxDist = 3;
        this.maxHeight = 1;
    }

    public void setRady(boolean isRady) {
        this.isRady = isRady;
    }

    public boolean getIsRady() {
        return isRady;
    }

    public int getMaxDist() {
        return maxDist;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.printf("%s %s бежит!%n",this.nameClass,this.name);
    }

    @Override
    public void jump() { System.out.printf("%s %s прыгает!%n",this.nameClass,this.name); }


}
