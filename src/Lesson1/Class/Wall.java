package Lesson1.Class;

import Lesson1.Interface.Action;
import Lesson1.Interface.Let;

public class Wall implements Let {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public Wall() {
        this.height = 0;
    }


    public void doIt(Action action) {
        if (action.getIsRady()) {
            action.jump();
            if (action.getMaxHeight() < this.height) {
                System.out.printf("%s не смог преодалеть препятствие - стена с высотой %s %n", action.getName(),this.height);
                action.setRady(false);
                return;
            }
            System.out.printf("%s преодалел препятствие - стена с высотой %s %n", action.getName(),this.height);

        }
    }
}
