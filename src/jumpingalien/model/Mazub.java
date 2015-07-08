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
        //calc new vel
        setVelocityX(getVelocity()[0] + getAcceleration()[0] *dt);
        setVelocityY(getVelocity()[1] + getAcceleration()[1] *dt);
        //calc new loc
        if (getVelocity()[0]*dt < 1)
            System.out.println(getRawLocation()[1]);
        setLocationX(correctLocationX(getRawLocation()[0] + (getVelocity()[0]*dt)*100));
        setLocationY(correctLocationY(getRawLocation()[1] + (getVelocity()[1]*dt)*100));


    }
}
