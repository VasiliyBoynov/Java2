package Lesson1.Class;

import Lesson1.Interface.Action;
import Lesson1.Interface.Let;

public class Treadmill implements Let{
    private final int dist;

    public Treadmill(int dist) {
        this.dist = dist;
    }

    public Treadmill() {
        this.dist = 1;
    }

    public void doIt(Action action) {
        if (action.getIsRady()) {
            action.run();
            if (action.getMaxDist() < this.dist) {
                System.out.printf("%s не смог преодалеть препятствие - беговая дорожка с длиной %s км %n", action.getName(),this.dist);
                action.setRady(false);
                return;
            }
            System.out.printf("%s преодалел препятствие - беговая дорожка с длиной %s км %n", action.getName(),this.dist);

        }
    }
}
