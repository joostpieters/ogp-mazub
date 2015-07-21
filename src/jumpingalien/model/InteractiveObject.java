package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Basic;
import jumpingalien.util.Sprite;

import java.util.LinkedList;

/**
 * Created by covert on 08/07/15.
 */
public abstract class InteractiveObject {
    //classe invarianten
        //locatie var
        private double dPixelLeftX;
        private double dPixelBottomY;
        //velocity var
        private double dVelocityX;
        private double dVelocityY;
        //acceleration var
        private double dAccelerationX;
        private double dAccelerationY;
        //sprite var
        private Sprite[] aSprite;
        private int iCurrentSprite;
        //hitpoints
        private int iHitpoints = 100;
        //caller
        protected World wCaller;

    protected int correctSprite(){
        return 0; //todo
    }

    public int getHealth(){
        return iHitpoints;
    }

    public void setWorld(World world){
        wCaller = world;
    }

    public InteractiveObject(int pixelLeftX, int pixelBottomY, Sprite[] sprites,int hitpoints){
        dPixelLeftX = pixelLeftX; dPixelBottomY = pixelBottomY; aSprite = sprites;iHitpoints = hitpoints;
    }
    @Basic
    public int[] getLocation(){
        int[] iaLocation = new int[2];
        iaLocation[0] = (int) dPixelLeftX;
        iaLocation[1] = (int) dPixelBottomY;
        return iaLocation;
    }
    public double[] getRawLocation(){
        double[] iaLocation = new double[2];
        iaLocation[0] = dPixelLeftX;
        iaLocation[1] = dPixelBottomY;
        return iaLocation;
    }
    protected static double correctLocationX(double x){
        if (x < 0)
            x = 0;
        if(x > 1024)
            x = 1024;
        return x;
    }
    protected static double correctLocationY(double y){
        if (y < 0)
            y = 0;
        if(y > 778)
           y = 778;
        return y;
    }

    private void setLocation(double[] iaLocation){
        setLocationX(iaLocation[0]);
        setLocationY(iaLocation[1]);
    }

    protected void setLocationX(double x){
        //world check TODO
        if (x < 0) throw new IllegalArgumentException("x is too small");
        dPixelLeftX = x;
    }
    protected void setLocationY(double y){
        //world check TODO
        if(y < 0) throw new IllegalArgumentException("y is too small");
        dPixelBottomY = y;
    }
    @Basic
    public double[] getVelocity(){
        double[] daVelocity = new double[2];
        daVelocity[0]=dVelocityX;
        daVelocity[1]=dVelocityY;
        return daVelocity;
    }
    public void setVelocity(double[] daVelocity){
        if(daVelocity.length != 2) throw new IllegalArgumentException("double array needs only an x & y value");
        //TODO test
        setVelocityX(daVelocity[0]);
        setVelocityY(daVelocity[1]);
    }
    protected void setVelocityX(double x){
        //TODO test def
        dVelocityX = x;
    }
    protected void setVelocityY(double y){
        //TODO test def
        dVelocityY = y;
    }

    @Basic
    public double[] getAcceleration(){
        double[] daAcceleration = new double[2];
        daAcceleration[0] = dAccelerationX;
        daAcceleration[1] = dAccelerationY;
        return daAcceleration;
    }

    protected void setAcceleration(double[] daAccel){
        if(daAccel.length != 2) throw new IllegalArgumentException("double array needs only an x & y value");
        //TODO test
        setAccelerationX(daAccel[0]);
        setAccelerationY(daAccel[1]);
    }
    protected void setAccelerationX(double x){
        //TODO test def
        dAccelerationX = x;
    }
    protected void setAccelerationY(double y){
        //TODO test def
        dAccelerationY = y;
    }
    @Basic
    public int[] getSize(){
        int[] iaSize = new int[2];
        iaSize[0] = aSprite[iCurrentSprite].getWidth();
        iaSize[1] = aSprite[iCurrentSprite].getHeight();
        return iaSize;
    }
    @Basic
    public Sprite getCurrentSprite(){
        return aSprite[iCurrentSprite];
    }

    public abstract void isOverlapping(InteractiveObject interObj);

    public abstract void advanceTime(double dt);

    protected void FncProccesHealth(int change){
        if (iHitpoints + change < 1) wCaller.FncRemoveFromColl(this);
        else if (iHitpoints + change < 500) iHitpoints = 500;
        else iHitpoints += change;
    }

    protected void setSprite(int iCurrentSprite){
        this.iCurrentSprite = iCurrentSprite;
    }
}
