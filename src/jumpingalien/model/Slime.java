package jumpingalien.model;

import jumpingalien.util.Sprite;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Slime extends ActiveObject {
    public Slime (int x, int y, Sprite[] sprites,School school){
        super(x,y,sprites,100,false);
        //TODO school
    }

    public void isOverlapping(ActiveObject interObj) {
        //throw new NotImplementedException();
        return;
    }
    public void advanceTime(double dt) {
        //throw new NotImplementedException();
        return;
    }
    public void processEnv(double dt,int iEnvType) {
        return;
    }
}

