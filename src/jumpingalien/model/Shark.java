package jumpingalien.model;

import jumpingalien.util.Sprite;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Shark extends InteractiveObject{
    public Shark(int x, int y, Sprite[] sprites){
        super(x,y,sprites,100);
    }

    @Override
    public void isOverlapping(InteractiveObject interObj) {
        throw new NotImplementedException();
    }

    @Override
    public void advanceTime(double dt) {

    }
}
