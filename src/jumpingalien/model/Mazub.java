package jumpingalien.model;

import jumpingalien.util.Sprite;

/**
 * Created by covert on 08/07/15.
 */
public class Mazub extends InteractiveObject {
    //classe invarianten
    private enHorState eLastHorState;
    private double dtLastMove;
    public Mazub(int pixelLeftX, int pixelBottomY, Sprite[] sprites){
        super(pixelLeftX, pixelBottomY, sprites);
        eLastHorState = enHorState.stand;
        dtLastMove = 0;
    }

    public void advanceTime(double dt){
        //time en last move management
        if (geteHorState() == eLastHorState)
            dtLastMove += dt;
        else {
            dtLastMove = 0;
            eLastHorState = geteHorState();
        }
        //calc new vel
        setVelocityX(getVelocity()[0] + getAcceleration()[0] * dt);
        setVelocityY(getVelocity()[1] + getAcceleration()[1] * dt);
        //calc new loc
        setLocationX(correctLocationX(getRawLocation()[0] + (getVelocity()[0] * dt) * 100));
        setLocationY(correctLocationY(getRawLocation()[1] + (getVelocity()[1] * dt) * 100));
        //sprite
        setSprite(correctSprite());
    }
    @Override
    protected int correctSprite(){
        int iCounter = 0;
        //if ducking ++
        if (geteVerState() == enVertState.duck)
            iCounter++;
        //was going left
        if (dtLastMove < 1 && eLastHorState == enHorState.right)
            iCounter +=2;
        //was going right
        if (dtLastMove < 1 && eLastHorState == enHorState.left)
            iCounter +=3;
        //is jumping
        if (geteVerState() == enVertState.jump && geteHorState() != enHorState.stand)
            iCounter +=2;
        /*if (geteHorState() != enHorState.stand)
            iCounter +=2;
*/
        if (geteVerState() == enVertState.duck){
            if (geteHorState() != enHorState.stand)
                iCounter +=3;
        }
        System.out.println(iCounter);
        //return result
        return iCounter;
    }
}
