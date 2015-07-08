package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Basic;
import jumpingalien.util.Sprite;

/**
 * Created by covert on 08/07/15.
 */
public class InteractiveObject {
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
        //state var
        private enum enVertState{
            jump,stand,duck
        };
        private enum enHorState{
            left,stand,right
        };
        private enVertState eVerState;
        private enHorState eHorState;

    public InteractiveObject(int pixelLeftX, int pixelBottomY, Sprite[] sprites){
        dPixelLeftX = pixelLeftX; dPixelBottomY = pixelBottomY; aSprite = sprites;
        eVerState = enVertState.stand; eHorState = enHorState.stand;
    }
    @Basic
    public int[] getLocation(){
        int[] iaLocation = new int[2];
        iaLocation[0] = (int) dPixelLeftX;
        iaLocation[1] = (int) dPixelBottomY;
        return iaLocation;
    }
    private void setAlwaysCorrectLocation(int[]iaLocation){
        //TODO
    }

    private void setLocation(int[] iaLocation){
        setLocationX(iaLocation[0]);
        setLocationY(iaLocation[1]);
    }

    private void setLocationX(int x){
        //world check TODO
        if (x < 0) throw new IllegalArgumentException("x is too small");
        dPixelLeftX = x;
        return;
    }
    private void setLocationY(int y){
        //world check TODO
        if(y < 0) throw new IllegalArgumentException("y is too small");
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
    private void setVelocityX(double x){
        //TODO test def
        dVelocityX = x;
    }
    private void setVelocityY(double y){
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

    private void setAcceleration(double[] daAccel){
        if(daAccel.length != 2) throw new IllegalArgumentException("double array needs only an x & y value");
        //TODO test
        setAccelerationX(daAccel[0]);
        setAccelerationY(daAccel[1]);
    }
    private void setAccelerationX(double x){
        //TODO test def
        dAccelerationX = x;
    }
    private void setAccelerationY(double y){
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

    public void startJump(){
        eVerState = enVertState.jump;
        //recalculate sprite //TODO
        setVelocityY(8);
        setAccelerationY(-10);
    }
    public void endJump(){
        eVerState = enVertState.stand;
        //recalculate sprite //TODO
        if(getVelocity()[1] > 0)setVelocityY(0);
    }

    public void startMoveLeft(){
        eHorState = enHorState.left;
        //recalculate sprite //TODO
        setVelocityX(-1);
        setAccelerationX(-0.9);
    }
    public void endMoveLeft(){
        eHorState = enHorState.stand;
        setVelocityX(0);
        setAccelerationX(0);
        //recalculate sprite //TODO
    }

    public void startMoveRight(){
        eHorState = enHorState.left;
        //recalculate sprite //TODO
        setVelocityX(1);
        setAccelerationX(0.9);
    }

    public void endMoveRight(){
        eHorState = enHorState.stand;
        setVelocityX(0);
        setAccelerationX(0);
        //recalculate sprite //TODO
    }

    public void startDuck(){
        //recalculate sprite
        eVerState = enVertState.duck;
    }
}
