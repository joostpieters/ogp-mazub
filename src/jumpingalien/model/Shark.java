package jumpingalien.model;

import jumpingalien.util.Sprite;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Random;

public class Shark extends ActiveObject {
    private final Random random = new Random();

    public Shark(int x, int y, Sprite[] sprites){
        super(x,y,sprites,100);
    }


    public void isOverlapping(ActiveObject interObj) {
        //throw new NotImplementedException();
        //TODO
    }


    public void advanceTime(double dt) {
        /*if (getTimeSinceMovementChange() >= 2 + random.nextDouble() * 2) {
            startMove(getDirection() == Direction.Left ? Direction.Right : Direction.Left);

            if (isTopInWater()) {
                setYAcceleration(random.nextDouble() * 0.4 - 0.2);
            }
        }*/
        int moveMultipl;
        if (2 + random.nextDouble() * 2 <= dtLastMove){
            dtLastMove = 0;
            if (eHorState == enHorState.right){
                moveMultipl = 1;
            } else {
                moveMultipl = -1;
            }

        } else {
            dtLastMove += dt;
        }

    }


    public void processEnv(double dt,int iEnvType) {

    }
}
