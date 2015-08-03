package jumpingalien.model;

import jumpingalien.util.Sprite;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Mazub extends ActiveObject {
    //classe invarianten
    private boolean bImune;
    //sprite counter
    private int iSpriteCounter;
    private enHorState eLastHorState;
    private double dtLastMove;
    public Mazub(int pixelLeftX, int pixelBottomY, Sprite[] sprites){
        super(pixelLeftX, pixelBottomY, sprites,250);
        eVerState = enVertState.stand; eHorState = enHorState.stand;
        eLastHorState = enHorState.stand;
        dtLastMove = 0;
    }

    @Override
    public void isOverlapping(ActiveObject interObj) {
        if (interObj instanceof Plant) {
            if (getHealth() < 500) {
                FncProccesHealth(100);
                wCaller.FncRemoveFromColl(interObj);
            }
            return;
        }
        if (interObj instanceof Shark) throw new NotImplementedException();
        if (interObj instanceof Slime) throw new NotImplementedException();
    }

    //state var
    protected enum enVertState{
        jump,stand,duck
    };
    protected enum enHorState{
        left,stand,right
    };

    private enVertState eVerState;
    private enHorState eHorState;



    public void startJump(){
        eVerState = enVertState.jump;
        //recalculate sprite //TODO
        setVelocityY(8);
        setAccelerationY(-10);
    }
    public void endJump(){
        eVerState = enVertState.stand;
        //recalculate sprite //TODO
        if(getVelocity()[1] < 0)setVelocityY(0);
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
        eHorState = enHorState.right;
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
    public void endDuck(){
        //recalculate sprite
        eVerState = enVertState.stand;
    }

    public void advanceTime(double dt){
        //time en last move management
        if (eHorState== eLastHorState)
            dtLastMove += dt;
        else {
            dtLastMove = 0;
            eLastHorState = eHorState;
        }
        //sprite counter
        if (iSpriteCounter < 10){
            iSpriteCounter++;
        } else {
            iSpriteCounter = 0;
        }
        //calc new vel
        setVelocityX(getVelocity()[0] + getAcceleration()[0] * dt);
        setVelocityY(getVelocity()[1] + getAcceleration()[1] * dt);
        //calc new loc
        setLocationX(correctLocationX(getRawLocation()[0] + (getVelocity()[0] * dt) * 100));
        setLocationY(correctLocationY(getRawLocation()[1] + (getVelocity()[1] * dt) * 100));
        //check surrounding
        //sprite
        setSprite(correctSprite());
        //checkenv
        checkEnv();

    }

    @Override
    public void processEnv(int iEnvType) {
        //TODO
    }

    @Override
    protected int correctSprite(){
        int iCounter = 0;
        //
        //possible bij left en right going plus 2 en 3 //TODO
        //
        //if ducking ++
        if (eVerState == enVertState.duck)
            iCounter++;
        //was going left
        if (dtLastMove < 1 && eLastHorState == enHorState.right)
            iCounter +=2;
        //was going right
        if (dtLastMove < 1 && eLastHorState == enHorState.left)
            iCounter +=3;
        //is jumping
        if (eVerState == enVertState.jump && eHorState != enHorState.stand)
            iCounter +=2;
        /*if (geteHorState() != enHorState.stand)
            iCounter +=2;
*/
        if (eVerState == enVertState.duck){
            if (eHorState != enHorState.stand)
                iCounter +=3;
        }
        //al loopend
        if (eHorState == enHorState.stand){
            iSpriteCounter = 0;
        }
        if (getVelocity()[1] == 0 ) { //TODO check
            if (eHorState == enHorState.left) {
                iCounter = 19 + iSpriteCounter;
            }
            if (eHorState == enHorState.right){
                iCounter = 8 + iSpriteCounter;
            }
        }

        //return result
        return iCounter;
    }

    public boolean isImune(){
        return bImune;
    }
}
