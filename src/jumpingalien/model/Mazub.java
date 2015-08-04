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
        if (interObj instanceof Shark){

        }
        if (interObj instanceof Slime){

        }
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
        setVelocityY(8);
        setAccelerationY(-10);
    }
    public void endJump(){
        eVerState = enVertState.stand;
        if(getVelocity()[1] < 0)setVelocityY(0);
    }

    public void startMoveLeft(){
        eHorState = enHorState.left;
        setVelocityX(-1);
        setAccelerationX(-0.9);
    }
    public void endMoveLeft(){
        eHorState = enHorState.stand;
        setVelocityX(0);
        setAccelerationX(0);
    }

    public void startMoveRight(){
        eHorState = enHorState.right;
        setVelocityX(1);
        setAccelerationX(0.9);
    }

    public void endMoveRight(){
        eHorState = enHorState.stand;
        setVelocityX(0);
        setAccelerationX(0);
    }

    public void startDuck(){
        eVerState = enVertState.duck;
    }
    public void endDuck(){
        eVerState = enVertState.stand;
    }

    public void advanceTime(double dt){
        //time en last move management
        dLastLeftX = getRawLocation()[0];dLastBottomY = getRawLocation()[1];
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
        //move
        double counter = 0;
        double newDt;
        while (counter < dt){
            newDt = Math.min(0.01/(Math.abs(getVelocity()[0])+Math.abs(getAcceleration()[0])*dt),0.01/(Math.abs(getVelocity()[1])+Math.abs(getAcceleration()[1])*dt));
            if (newDt + counter > dt)
                newDt = dt - counter;
            counter += newDt;
            calulateAndSetTraject(newDt);
        }
        //check surrounding
        //sprite
        setSprite(correctSprite());
        //checkenv
        checkEnv();
        //checkBoundry

    }

    @Override
    public void processEnv(int iEnvType) {

    }

    @Override
    protected int correctSprite(){
        int iCounter = 0;
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
