package jumpingalien.model;

import jumpingalien.util.Sprite;

public class Plant extends ActiveObject
{

	public Plant(int x, int y, Sprite[] sprites)
	{
		this(x, y, sprites, null);
	}

	public Plant(int x, int y, Sprite[] sprites, Program program)
	{
		super(x, y, sprites, 100, false, 0.5, 0, 0, 0.5, null);
	}


	public void startDuck()
	{
	}

	public void endDuck()
	{

	}

	public void isOverlapping(ActiveObject interObj)
	{
		//Do nothing
	}


	public void advanceTime(double dt)
	{
		//TODO
		super.advanceTime(dt);
	}


	public void processEnv(double dt, int iEnvType)
	{

	}

}
