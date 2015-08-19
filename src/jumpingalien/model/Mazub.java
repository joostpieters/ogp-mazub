package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Basic;
import jumpingalien.util.Sprite;

/**
 * a class representing Mazub in the game world
 */
public class Mazub extends ActiveObject
{
	//classe invarianten
	private double dInWater = 0;
	private boolean bInWater;
	private double dInMagma = 0;
	private boolean bInMagma;
	//sprite counter
	private int iSpriteCounter;
	private enHorState eLastHorState = enHorState.stand;

	/**
	 * Constructor of a Mazub extends an ActiveObject
	 *
	 * @param pixelLeftX   The location of the ActiveObject on the x-axis
	 * @param pixelBottomY The location of the ActiveObject on the y-axis
	 * @param sprites      The Array of sprites that wil be used by the ActiveObject
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
	public Mazub(int pixelLeftX, int pixelBottomY, Sprite[] sprites)
	{
		this(pixelLeftX, pixelBottomY, sprites, null);
	}

	Mazub(int pixelLeftX, int pixelBottomY, Sprite[] sprites, Program program)
	{
		super(pixelLeftX, pixelBottomY, sprites, 100, true, 1, 0.9,
				8, 3, program);
	}

	/**
	 * pocesses overlapping between mazub and other ActiveObject
	 *
	 * @param interObj The ActiveObject mazub is colliding with
	 * @effect if interObject is a plant then mazub absorbs it
	 * | if interObj instance of plant
	 * mazub.addHealth(100)
	 * plant.dies
	 * @effect if interObject is a potion then mazub absorbs it
	 * | if interObj instance of potion
	 * mazub.addHealth(potion.getHealth)
	 * potion.dies
	 * @effect if interObject is a Shark then mazub takes 50 damage and becoms imune
	 * | if interObj instance of Shark
	 * mazub.subtractHealth(50)
	 * mazub.becomsImune()
	 */
	@Override
	public void isOverlapping(ActiveObject interObj)
	{
		if (interObj instanceof Plant)
		{
			if (getHealth() < 500)
			{
				processHealth(100);
				getwCaller().objectDies(interObj);
			}
			return;
		}
		if (interObj instanceof Potion)
		{
			processHealth(interObj.getHealth());
			getwCaller().objectDies(interObj);
		}

		if (interObj instanceof Shark)
		{
			processHealth(-50);
			becomsImune();
		}
	}

	@Basic
	public void startDuck()
	{
		eVerState = enVertState.duck;
	}

	@Basic
	public void endDuck()
	{
		eVerState = enVertState.stand;
	}

	/**
	 * processes imune to become no longer imune after 0.6 seconds
	 *
	 * @param dt The amout of time since the last check in
	 * @effect afthter 0.6 seconds of being imune mazubs nolonger becoms imune
	 * | if (dLastImune > 0.6)
	 * isNoLongerImune()
	 */
	private void processImune(double dt)
	{
		if (isImune())
		{
			dLastImune += dt;
			if (dLastImune > 0.6)
			{
				System.out.println(dLastImune);
				dLastImune = 0;
				isNoLongerImune();
			}
		}
	}

	public void advanceTime(double dt)
	{
		super.advanceTime(dt);
		//imune
		processImune(dt);
		if (eHorState == eLastHorState)
			dtLastMove += dt;
		else
		{
			dtLastMove = 0;
			eLastHorState = eHorState;
		}
		//sprite counter
		if (iSpriteCounter < 10)
		{
			iSpriteCounter++;
		} else
		{
			iSpriteCounter = 0;
		}
		//checkBoundry

	}

	/**
	 * Processes environment
	 *
	 * @param dt       The duration that the Worm in in the given EnvType
	 * @param iEnvType The type of tile the Worm was in for dt time
	 * @effect If mazub is in water(2) or magma(3) the mazub recieves damage
	 * |if iEnvType == 2
	 * if dInWater >= 0.2
	 * mazub.subtractHealth(6)
	 * |if iEnvType == 3
	 * if dInLava >= 0.2
	 * mazub.subtractHealth(50)
	 */
	public void processEnv(double dt, int iEnvType)
	{
		//water
		if (iEnvType == 2)
		{
			bInWater = true;
			dInWater += dt;
			if (dInWater >= 0.2)
			{
				dInWater -= 0.2;
				processHealth(-6);
			}
		}
		//magma
		if (iEnvType == 3)
		{
			bInMagma = true;
			dInMagma += dt;
			if (dInMagma >= 0.2)
			{
				dInMagma -= 0.2;
				processHealth(-50);
			}
		}
	}

	@Override
	protected int correctSprite()
	{
		int iCounter = 0;
		//if ducking ++
		if (eVerState == enVertState.duck)
			iCounter++;
		//was going left
		if (dtLastMove < 1 && eLastHorState == enHorState.right)
			iCounter += 2;
		//was going right
		if (dtLastMove < 1 && eLastHorState == enHorState.left)
			iCounter += 3;
		//is jumping
		if (eVerState == enVertState.jump && eHorState != enHorState.stand)
			iCounter += 2;
		/*if (geteHorState() != enHorState.stand)
            iCounter +=2;
*/
		if (eVerState == enVertState.duck)
		{
			if (eHorState != enHorState.stand)
				iCounter += 3;
		}
		//al loopend
		if (eHorState == enHorState.stand)
		{
			iSpriteCounter = 0;
		}
		if (getVelocity()[1] == 0)
		{
			if (eHorState == enHorState.left)
			{
				iCounter = 19 + iSpriteCounter;
			}
			if (eHorState == enHorState.right)
			{
				iCounter = 8 + iSpriteCounter;
			}
		}

		//return result
		return iCounter;
	}
}