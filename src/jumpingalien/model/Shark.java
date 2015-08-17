package jumpingalien.model;

import jumpingalien.util.Sprite;

import java.util.Random;

public class Shark extends ActiveObject
{
	//class invar
	private final Random random = new Random();
	private double dMovePeriod = random.nextDouble() * 2 + 2;
	private double dMoveTimer = 0;
	private int iMoveMutilpr = 1;
	private int jumpTimer = 0;
	private double dInAir = 0;
	private boolean bInAir;
	private double dInMagma = 0;
	private boolean bInMagma;

	public Shark(int x, int y, Sprite[] sprites)
	{
		this(x, y, sprites, null);
	}

	public Shark(int x, int y, Sprite[] sprites, Program program)
	{
		super(x, y, sprites, 100, true, 0, 1.5, 2, 4, program);
	}


	public void startDuck()
	{

	}

	public void endDuck()
	{

	}

	public void isOverlapping(ActiveObject interObj)
	{
		//throw new NotImplementedException();
		//TODO
	}


	public void advanceTime(double dt)
	{
		bInAir = false;
		bInMagma = false;
		//horizontal movement
		if (dMovePeriod < dMoveTimer)
		{
			iMoveMutilpr *= -1;
			dMoveTimer = 0;
			dMovePeriod = random.nextDouble() * 3 + 1;
			setAccelerationX(1.5 * iMoveMutilpr);
			jumpTimer++;
		} else
		{
			dMoveTimer += dt;
			if (jumpTimer > 3)
			{
				jumpTimer = 0;
				setVelocityY(2);
			}
		}

		super.advanceTime(dt);
		if (!bInAir) dInAir = 0;
		if (!bInMagma) dInMagma = 0;
	}


	public void processEnv(double dt, int iEnvType)
	{
		//lucht
		if (iEnvType == 0)
		{
			bInAir = true;
			dInAir += dt;
			if (dInAir <= 0.2)
			{
				dInAir -= 0.2;
				FncProcessHealth(-6, false);
			}
		}
		//lava
		if (iEnvType == 3)
		{
			bInMagma = true;
			dInMagma += dt;
			if (dInMagma <= 0.2)
			{
				dInMagma -= 0.2;
				FncProcessHealth(-50, false);
			}
		}
	}
}
