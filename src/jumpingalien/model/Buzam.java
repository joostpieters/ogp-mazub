package jumpingalien.model;

import jumpingalien.model.programs.Program;
import jumpingalien.util.Sprite;

/**
 * Created by covert on 13/08/15.
 */
public class Buzam extends Mazub {
    public Buzam(int pixelLeftX, int pixelBottomY, Sprite[] sprites) {
        super(pixelLeftX, pixelBottomY, sprites);
    }

    public Buzam(int pixelLeftX, int pixelBottomY, Sprite[] sprites,Program program) {
        super(pixelLeftX, pixelBottomY, sprites,program);
    }


    @Override
    public void advanceTime(double dt){

    }
}
