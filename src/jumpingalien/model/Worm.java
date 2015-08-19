package jumpingalien.model;

import jumpingalien.util.Sprite;

/**
 * A class representing a Worm in the game world
 */
public class Worm extends ActiveObject
{
	/**
	 * Constructor of a Worm extends an ActiveObject
	 *
	 * @param x The location of the ActiveObject on the x-axis
	 * @param y The location of the ActiveObject on the y-axis
	 * @param sprites The Array of sprites that wil be used by the ActiveObject
	 *
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

	/**
	 * Handels changes to Worm when overlapping with an other ActiveObject
	 * @param interObj The ActiveObject which the Worm is collided with
	 *
	 * @effect when the worm overlaps with another worm the other worm dies and its health get added to the caller
	 * 			the caller also changes direction
	 * |if (interObj instanceof Worm)
	 * 	this.addHealth(interObj.getHealth)
	 * 	interObj.dies()
	 * 	this.direction.reverse
	 */
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

	/**
	 * Processes environment
	 * @param dt The duration that the Worm in in the given EnvType
	 * @param iEnvType The type of tile the Worm was in for dt time
	 *
	 * @effect If the worm is in water(2) or magma(3) the worm dies
	 * |if iEnvType == 2 || iEnvType == 3
	 *  this.dies
	 */
	public void processEnv(double dt, int iEnvType)
	{
		if (iEnvType == 3 || iEnvType == 2){
			getwCaller().objectDies(this);
		}
	}
}
