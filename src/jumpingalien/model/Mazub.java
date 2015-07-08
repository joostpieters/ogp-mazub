package jumpingalien.model;

import jumpingalien.util.Sprite;

/**
 * Created by covert on 08/07/15.
 */
public class Mazub extends InteractiveObject {
    //classe invarianten
    public Mazub(int pixelLeftX, int pixelBottomY, Sprite[] sprites){
        super(pixelLeftX, pixelBottomY,sprites);
    }

    public void advanceTime(double dt){
        int[] iaLocation = this.getLocation();
        double[] daVel = this.getVelocity();
        double[] daAccel = this.getAcceleration();
        //calc new vel
        daVel[0]= daVel[0] + daAccel[0];
        daVel[1]= daVel[1] + daAccel[1];
        //calc new loc
        iaLocation[0] = (int) (iaLocation[0] + daVel[0]);
        iaLocation[1] = (int) (iaLocation[1] + daVel[1]);

    }
}
