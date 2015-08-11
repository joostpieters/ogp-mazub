package jumpingalien.model;

import jumpingalien.util.Sprite;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Random;

public class Shark extends ActiveObject {
    //class invar
    private final Random random = new Random();
    double dMovePeriod = random.nextDouble() * 2 + 2;
    double dMoveTimer = 0;
    int iMoveMutilpr = 1;
    int jumpTimer = 0;
    double dInAir = 0;
    boolean bInAir;
    double dInMagma = 0;
    boolean bInMagma;

    public Shark(int x, int y, Sprite[] sprites){
        super(x,y,sprites,100,true);
    }


    public void isOverlapping(ActiveObject interObj) {
        //throw new NotImplementedException();
        //TODO
    }


    public void advanceTime(double dt) {
        bInAir = false; bInMagma = false;
        //horizontal movement
        if (dMovePeriod < dMoveTimer){
            iMoveMutilpr *= -1;
            dMoveTimer = 0;dMovePeriod = random.nextDouble() * 3 + 1;
            setAccelerationX(1.5 * iMoveMutilpr);
            jumpTimer++;
        } else {
            dMoveTimer += dt;
            if (jumpTimer > 3) {
                jumpTimer = 0;
                setVelocityY(2);
            }
        }

        super.advanceTime(dt);
        if(!bInAir) dInAir = 0;
        if(!bInMagma) dInMagma = 0;
    }


    public void processEnv(double dt,int iEnvType) {
        //lucht
        if (iEnvType == 0){
            bInAir = true;
            dInAir += dt;
            if (dInAir <= 0.2){
                dInAir -= 0.2;
                FncProcessHealth(-6,false);
            }
        }
        //lava
        if (iEnvType == 3){
            bInMagma = true;
            dInMagma += dt;
            if (dInMagma <= 0.2){
                dInMagma -= 0.2;
                FncProcessHealth(-50,false);
            }
        }
    }
}
