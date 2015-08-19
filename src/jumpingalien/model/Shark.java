package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Basic;
import jumpingalien.util.Sprite;

import java.util.Random;

/**
 * a class representing a shark in the game worl
 */
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

	/**
	 * Constructor of a Shark extends an ActiveObject
	 *
	 * @param x       The location of the ActiveObject on the x-axis
	 * @param y       The location of the ActiveObject on the y-axis
	 * @param sprites The Array of sprites that wil be used by the ActiveObject
	 * @effect Sets the x-axis location to the given value
	 * | setLocationX(pixelLeftX)
	 * @effect Sets the y-axis location to the given value
	 * | setLocationX(pixelBottomY)
	 * @effect Sets the sprite array to the given array
	 * | aSprite = sprites
	 * @effect Sets the number of hitpoints to 20
	 * | iHitpoints = 20
	 * @effect Sets the fall flag to true |
	 * dCanFall = true
	 * @effect Sets the maximum velocity to infinite
	 * | maxVelocity = double.MAX_Value
	 */
	public Shark(int x, int y, Sprite[] sprites)
	{
		this(x, y, sprites, null);
	}

	public Shark(int x, int y, Sprite[] sprites, Program program)
	{
		super(x, y, sprites, 100, true, 0, 1.5, 2, 4, program);
	}

	@Basic
	public void startDuck()
	{
		//Do nothing
	}

	@Basic
	public void endDuck()
	{
		//Do nothing
	}

	/**
	 * does nothing
	 *
	 * @param interObj
	 */
	public void isOverlapping(ActiveObject interObj)
	{
	}


	public void advanceTime(double dt)
	{
		bInAir = false;
		bInMagma = false;
		//horizontal movement
		if (hasProgram())
		{
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
		}
		super.advanceTime(dt);
		if (!bInAir) dInAir = 0;
		if (!bInMagma) dInMagma = 0;
	}


	/**
	 * Processes environment
	 *
	 * @param dt       The duration that the Worm in in the given EnvType
	 * @param iEnvType The type of tile the Worm was in for dt time
	 * @effect If the shark is in air(0) or magma(3) the shark recieves damage
	 * |if iEnvType == 2
	 * if dInAir >= 0.2
	 * shark.subtractHealth(6)
	 * |if iEnvType == 3
	 * if dInMagma >= 0.2
	 * shark.subtractHealth(50)
	 */
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
				processHealth(-6);
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
				processHealth(-50);
			}
		}
	}
}
