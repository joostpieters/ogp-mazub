package jumpingalien.model;

import jumpingalien.util.Sprite;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by covert on 13/07/15.
 */
public class Slime extends InteractiveObject{
    public Slime (int x, int y, Sprite[] sprites,School school){
        super(x,y,sprites);
        //TODO school
    }

    @Override
    public void isOverlapping(InteractiveObject interObj) {
        throw new NotImplementedException();
    }
}

