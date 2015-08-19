package jumpingalien.model;

import jumpingalien.util.Sprite;

public class Plant extends ActiveObject
{
	double dtTimer;
	public Plant(int x, int y, Sprite[] sprites)
	{
		this(x, y, sprites, null);
	}

	public Plant(int x, int y, Sprite[] sprites, Program program)
	{
		super(x, y, sprites, 100, false, 0.5, 0, 0, 0.5, null);
	}

	/**
	 * Does nothing
	 */
	public void startDuck()
	{
		//Do nothing
	}

	/**
	 * Does nothing
	 */
	public void endDuck()
	{
		//Do nothing
	}

	/**
	 * Does nothing
	 */
	public void isOverlapping(ActiveObject interObj)
	{
		//Do nothing
	}


	public void advanceTime(double dt)
	{
		if (!hasProgram()){
			if (dtTimer > 0.5){
				dtTimer = 0;
				if (getHorDirection() == enHorState.left){
					startMoveRight();
				} else {
					startMoveLeft();
				}
			}

		}
		super.advanceTime(dt);
	}

	/**
	 * Does nothing
	 */
	public void processEnv(double dt, int iEnvType)
	{
		//Do nothing
	}

}
