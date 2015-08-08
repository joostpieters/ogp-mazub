package jumpingalien.model;

import jumpingalien.util.Sprite;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Random;

public class Shark extends ActiveObject {
    private final Random random = new Random();

    public Shark(int x, int y, Sprite[] sprites){
        super(x,y,sprites,100,true,true);
    }


    public void isOverlapping(ActiveObject interObj) {
        //throw new NotImplementedException();
        //TODO
    }


    public void advanceTime(double dt) {
        int moveMultipl;
        double dRandom = random.nextDouble();
        if (2 + random.nextDouble() * 2 <= dtLastMove){
            dtLastMove = 0;
            //horizontal
            if (eHorState == enHorState.right){
                eHorState = enHorState.left;
                moveMultipl = -1;
            } else {
                eHorState = enHorState.right;
                moveMultipl = 1;
            }
            setAccelerationX(moveMultipl * 1.5);
            //vertical
            if (wCaller.getTilePositionInTiles(this).parallelStream().allMatch(obj -> obj.getGeoFeature() != 0)){
                setAccelerationY(0.4 * random.nextDouble() - 0.2);
            }
        } else {
            dtLastMove += dt;
        }
        super.advanceTime(dt);
    }


    public void processEnv(double dt,int iEnvType) {

    }
}
