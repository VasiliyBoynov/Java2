package Lesson1.Test;

import Lesson1.Class.*;
import Lesson1.Interface.Action;
import Lesson1.Interface.Let;

public class Main {
    public static void main(String[] args) {
        Action[] persons = createPerson();
        Let[] lets = createLet(4);

        for (Action person : persons) {
            if (lets.length>0) {
                for (Let let : lets) {
                    let.doIt(person);
                }
                System.out.println("------------");
            }
        }





    }
    public static Action[] createPerson(){
        String[] names = {"Иван", "Мария", "Ибрагим", "Коктебель", "Зара", "Пойсейдон"};
        Action[] persons =new Action[names.length];
        int numDist;
        int numHeight;
        int num;
        for (int i = 0; i < names.length; i++) {
            numDist = (int) (1+3 * Math.random());
            numHeight = (int) (1+3 * Math.random());
            num = (int) (3 * Math.random());
            if (num==0) {persons[i] = new Human(names[i],numDist,numHeight);}
            else if (num==1) {persons[i] = new Cat(names[i],numDist,numHeight);}
            else if (num==2) {persons[i] = new Robot(names[i],numDist,numHeight);}
        }
        return persons;
    }

    public static Let[] createLet(int count){
        if (count==0) return null;
        count = Math.abs(count);
        Let[] lets =new Let[count];
        int numDist;
        int numHeight;
        int num;
        for (int i = 0; i < count; i++) {
            numDist = (int) (3 * Math.random());
            numHeight = (int) (3 * Math.random());
            num = (int) (2 * Math.random());
            if (num==0) {lets[i] = new Wall(numHeight);}
            else if (num==1) {lets[i] = new Treadmill(numDist);}
        }
        return lets;
    }
}
