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
            dMoveTimer = 0;dMovePeriod = random.nextDouble() * 2 + 2;
            setAccelerationX(1.5 * iMoveMutilpr);
        } else {
            dMoveTimer += dt;
        }
        if (wCaller.getTilePositionInTiles(this).stream().anyMatch(obj -> obj.getGeoFeature() == 2)){
            setVelocityY(2 * Math.sin((dMoveTimer / (dMovePeriod/2)) * Math.PI));
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
                FncProcessHealth(-6);
            }
        }
        //lava
        if (iEnvType == 3){
            bInMagma = true;
            dInMagma += dt;
            if (dInMagma <= 0.2){
                dInMagma -= 0.2;
                FncProcessHealth(-50);
            }
        }
    }
}
