package jumpingalien.model;

import jumpingalien.util.Sprite;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Slime extends InteractiveObject{
    public Slime (int x, int y, Sprite[] sprites,School school){
        super(x,y,sprites,100);
        //TODO school
    }

    @Override
    public void isOverlapping(InteractiveObject interObj) {
        throw new NotImplementedException();
    }

    @Override
    public void advanceTime(double dt) {
        throw new NotImplementedException();
    }
}

