package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Basic;
import jumpingalien.util.Sprite;

public class Potion extends ActiveObject
{
	/**
	 * Constructor of a Plant
	 *
	 * @param pixelLeftX          The location of the ActiveObject on the x-axis
	 * @param pixelBottomY        The location of the ActiveObject on the y-axis
	 * @param sprites             The Array of sprites that wil be used by the ActiveObject
	 * @param type				  The boolean indicating if the potions is poisoned or not
	 *
	 * @post Sets the type information to the given value
	 * | harmfull = type;
	 * @effect Sets the x-axis location to the given value
	 * | setLocationX(pixelLeftX)
	 * @effect Sets the y-axis location to the given value
	 * | setLocationX(pixelBottomY)
	 * @effect Sets the sprite array to the given array
	 * | aSprite = sprites
	 * @effect Sets the number of hitpoints to the given amount
	 * | iHitpoints = hitpoints
	 * @effect Sets the fall flag to the given value |
	 * dCanFall = canFall
	 * @effect Sets the maximum velocity to the given value if given
	 * | if (maxVelocity == -1){
	 * dMaxVelocity == Double.MAX_VALUE
	 * } else {
	 * dMaxVelocity = maxVelocity
	 * }
	 */
	private boolean harmfull;
	private double dtTimer;
	private enHorState enHorState = ActiveObject.enHorState.left;
	public Potion(int pixelLeftX, int pixelBottomY, Sprite[] sprites,int hitpoints,Program program)
	{
		super(pixelLeftX, pixelBottomY, sprites, hitpoints , false, 0.25, 0, 0, -1,program);
	}

	@Basic
	public boolean isHarmfull()
	{
		return harmfull;
	}

	@Override
	@Basic
	public void startDuck()
	{
		//Do nothing
	}

	@Override
	@Basic
	public void endDuck()
	{
		//Do nothing
	}

	@Override
	@Basic
	public void isOverlapping(ActiveObject interObj)
	{
		//Do nothing
	}

	@Override
	public void processEnv(double dt, int iEnvType)
	{
		//Do nothing
	}

	@Override
	public void advanceTime(double dt){
		if (dtTimer > 1){
			dtTimer = 0;
			if (eHorState == ActiveObject.enHorState.left){
				startMoveRight();
			} else {
				startMoveLeft();
			}
		} else {
			dtTimer += dt;
		}
	}
}
