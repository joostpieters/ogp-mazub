package jumpingalien.model;

import jumpingalien.util.Sprite;

public class Plant extends ActiveObject {

    public Plant (int x, int y, Sprite[] sprites){
        super(x,y,sprites,100);
    }


    public void isOverlapping(ActiveObject interObj) {
        //Do nothing
    }


    public void advanceTime(double dt) {

    }


    public void processEnv(double dt,int iEnvType) {

    }

}
