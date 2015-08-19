package jumpingalien.model;

import jumpingalien.util.Sprite;

public class Worm extends ActiveObject
{
	public Worm(int x, int y, Sprite[] sprites)
	{
		super(x, y, sprites, 20, true, 0.5, 0.2, 0, -1);
	}

	@Override
	public void startDuck()
	{
		//Do nothing
	}

	@Override
	public void endDuck()
	{
		//Do nothing
	}

	public void isOverlapping(ActiveObject interObj)
	{
		if (interObj instanceof Worm){
			processHealth(interObj.getHealth());
			getwCaller().objectDies(interObj);
			if (getHorDirection() == enHorState.left){
				startMoveLeft();
			} else {
				startMoveRight();
			}
		}
	}


	public void advanceTime(double dt)
	{
		if (getHealth() >= 100) getwCaller().objectDies(this);
		super.advanceTime(dt);
	}

	public void processEnv(double dt, int iEnvType)
	{
		if (iEnvType == 3 || iEnvType == 2){
			getwCaller().objectDies(this);
		}
	}
}
