package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;
import jumpingalien.model.programs.Environment;
import jumpingalien.util.Sprite;

import java.util.LinkedList;

/**
 * The supper-class for all interoperable game objects
 *
 * @invar The absolute velocity on the x-axis is always smaller or equal to the maxium velocity on said x-axis
 * |Math.abs(this.getVelocity()[0]) <= dMaxVelocity
 * @invar The number of hitpoints is always between 1 and 500, if the hitpoints become lower than 1 it dies
 * | getHealth() > 1 else wcaller.objecDies(this)
 * getHealth() <= 500
 */
public abstract class ActiveObject implements IntegratedObject
{

	//sprite var
	private final Sprite[] aSprite;
	//env procedure
	private final boolean bCanFall;
	private final double dInitialVelocity;
	private final double dMaxVelocity;
	private final double dInitialJump;
	private final double dInitialAcceleration;
	enVertState eVerState = enVertState.stand;
	enHorState eHorState = enHorState.stand;
	double dtLastMove;
	double dLastImune;
	boolean bHasDied = false;
	//hitpoints
	private boolean bImune = false;
	//caller
	private World wCaller;
	//possible programs
	private Program controllingProgram;
	//locatie var
	private double dPixelLeftX;
	private double dPixelBottomY;
	//velocity var
	private double dVelocityX;
	private double dVelocityY;
	//acceleration var
	private double dAccelerationX;
	private double dAccelerationY;
	private int iCurrentSprite;
	private int iHitpoints;
	private Environment environment;
	/**
	 * Constructor of an ActiveObject
	 *
	 * @param pixelLeftX          The location of the ActiveObject on the x-axis
	 * @param pixelBottomY        The location of the ActiveObject on the y-axis
	 * @param sprites             The Array of sprites that wil be used by the ActiveObject
	 * @param hitpoints           The initial amout of hitpoints of the ActiveObject
	 * @param canFall             The variable that indicates if the ActiveObject can fall
	 * @param initialAcceleration The horizontal acceleration to be set when moving
	 * @param initialJump         The jump velocity to be set when jumping
	 * @param initialVelocity     The horizontal velocity to be set when starting a move
	 * @param maxVelocity         The maximum horizontal velocity the ActiveObject can achieve
	 * @post Sets the x-axis location to the given value
	 * | setLocationX(pixelLeftX)
	 * @post Sets the y-axis location to the given value
	 * | setLocationX(pixelBottomY)
	 * @post Sets the sprite array to the given array
	 * | aSprite = sprites
	 * @post Sets the number of hitpoints to the given amount
	 * | iHitpoints = hitpoints
	 * @post Sets the fall flag to the given value |
	 * dCanFall = canFall
	 * @post Sets the maximum velocity to the given value if given
	 * | if (maxVelocity == -1){
	 * dMaxVelocity == Double.MAX_VALUE
	 * } else {
	 * dMaxVelocity = maxVelocity
	 * }
	 */
	public ActiveObject(int pixelLeftX, int pixelBottomY, Sprite[] sprites, int hitpoints, boolean canFall
			, double initialVelocity, double initialAcceleration, double initialJump, double maxVelocity)
	{
		dPixelLeftX = pixelLeftX;
		dPixelBottomY = pixelBottomY;
		aSprite = sprites;
		iHitpoints = hitpoints;
		bCanFall = canFall;
		dMaxVelocity = (maxVelocity == -1) ? Double.MAX_VALUE : maxVelocity;
		dInitialVelocity = initialVelocity;
		dInitialAcceleration = initialAcceleration;
		dInitialJump = initialJump;
	}
	public ActiveObject(int pixelLeftX, int pixelBottomY, Sprite[] sprites, int hitpoints, boolean canFall,
			double initialVelocity, double initialAcceleration, double initialJump, double maxVelocity,
			Program program)
	{
		this(pixelLeftX, pixelBottomY, sprites, hitpoints, canFall, initialVelocity, initialAcceleration, initialJump, maxVelocity);
		if (program == null) return;
		controllingProgram = program;
		environment = new Environment(this, program);
	}

	@Basic
	protected boolean hasProgram()
	{
		return (controllingProgram != null);
	}

	@Basic
	public boolean isAlive()
	{
		return !bHasDied;
	}

	@Basic
	public void dies()
	{
		bHasDied = true;
	}

	/**
	 * Corrects the location when a collision ocurs between two ActiveObject
	 *
	 * @param collidingObj The ActiveObject that is colliding with this one
	 */
	protected void correctCollision(ActiveObject collidingObj)
	{
		setVelocity(new double[]{0, 0});
	}

	@Basic
	public enHorState getHorDirection()
	{
		return eHorState;
	}

	@Basic
	public enVertState getVerDirection()
	{
		return eVerState;
	}

	@Basic
	public int getHealth()
	{
		return iHitpoints;
	}

	/**
	 * The assosiation between the ActiveObject and the World wil be set
	 *
	 * @param world The world from where the ActiveObject wil be controlled
	 */
	public void wCaller(World world)
	{
		assert (wCaller != null);
		wCaller = world;
	}

	@Basic
	public World getwCaller()
	{
		return wCaller;
	}

	@Basic
	public int[] getLocation() throws ClassCastException
	{
		int[] iaLocation = new int[2];
		try
		{
			iaLocation[0] = (int) dPixelLeftX;
			iaLocation[1] = (int) dPixelBottomY;
		} catch (ClassCastException ex)
		{
			ex.printStackTrace();
		}
		return iaLocation;
	}

	@Basic
	private void setLocation(double[] iaLocation)
	{
		setLocationX(iaLocation[0]);
		setLocationY(iaLocation[1]);
	}

	@Basic
	public double[] getRawLocation()
	{
		double[] iaLocation = new double[2];
		iaLocation[0] = dPixelLeftX;
		iaLocation[1] = dPixelBottomY;
		return iaLocation;
	}

	private double correctLocationX(double x)
	{
		try
		{
			if (x < 0)
				wCaller.objectDies(this);
			if (x > wCaller.getWorldSizeInPixel()[0])
				wCaller.objectDies(this);
		} catch (Exception ex)
		{
			System.out.print("error in correction, correcting nothing");
		}
		return x;
	}

	private double correctLocationY(double y)
	{
		try
		{
			if (y < 0)
				wCaller.objectDies(this);
			if (y > wCaller.getWorldSizeInPixel()[1])
				wCaller.objectDies(this);
		} catch (Exception ex)
		{
			System.out.print("error in correction, correcting nothing");
		}
		return y;
	}

	@Basic
	private void setLocationX(double x)
	{
		if (x < 0 || x > wCaller.getWorldSizeInPixel()[0]) throw new IllegalArgumentException("Object needs to die");
		dPixelLeftX = x;
	}

	@Basic
	private void setLocationY(double y)
	{
		if (y < 0 || y > wCaller.getWorldSizeInPixel()[1]) throw new IllegalArgumentException("Object needs to die");
		dPixelBottomY = y;
	}

	private double correctVelocityX(double x)
	{
		double max = (eVerState == enVertState.duck) ? 1 : dMaxVelocity;
		x = (x < max) ? x : max;
		x = (x > -max) ? x : -max;
		return x;
	}

	@Basic
	public double[] getVelocity()
	{
		double[] daVelocity = new double[2];
		daVelocity[0] = dVelocityX;
		daVelocity[1] = dVelocityY;
		return daVelocity;
	}

	@Basic
	private void setVelocity(double[] daVelocity)
	{
		if (daVelocity.length != 2) throw new IllegalArgumentException("double array needs only an x & y value");
		setVelocityX(daVelocity[0]);
		setVelocityY(daVelocity[1]);
	}

	@Basic
	private void setVelocityX(double x)
	{
		if (Math.abs(x) > dMaxVelocity)
			throw new IllegalArgumentException("x velocity may not be more than the max velocity");
		dVelocityX = x;
	}

	@Basic
	protected void setVelocityY(double y)
	{
		dVelocityY = y;
	}

	@Basic
	public double[] getAcceleration()
	{
		double[] daAcceleration = new double[2];
		daAcceleration[0] = dAccelerationX;
		daAcceleration[1] = dAccelerationY;
		return daAcceleration;
	}

	@Basic
	private void setAcceleration(double[] daAccel) throws IllegalArgumentException
	{
		if (daAccel.length != 2) throw new IllegalArgumentException("double array needs only an x & y value");
		setAccelerationX(daAccel[0]);
		setAccelerationY(daAccel[1]);
	}

	@Basic
	protected void setAccelerationX(double x)
	{
		dAccelerationX = x;
	}

	@Basic
	private void setAccelerationY(double y)
	{
		dAccelerationY = y;
	}

	@Basic
	public int[] getSize() throws ArrayIndexOutOfBoundsException
	{
		int[] iaSize = new int[2];
		try
		{
			iaSize[0] = aSprite[iCurrentSprite].getWidth();
			iaSize[1] = aSprite[iCurrentSprite].getHeight();
		} catch (ArrayIndexOutOfBoundsException ex)
		{
			ex.printStackTrace();
		}
		return iaSize;
	}

	@Basic
	public Sprite getCurrentSprite()
	{
		return aSprite[iCurrentSprite];
	}

	protected int correctSprite()
	{
		if (getVelocity()[0] < 0)
		{
			return 0;
		} else
		{
			return 1;
		}
	}

	@Basic
	private void setSprite(int iCurrentSprite)
	{
		this.iCurrentSprite = iCurrentSprite;
	}

	/**
	 * Operates the iHitpoints variable and "kills" the ActiveObject if necessary
	 *
	 * @param change The mount that needs to be added or subtracted from the hitpoints
	 * @post The amount of hitpoint wil be calculated and if this reaches below 0
	 * the ActiveObject wil die | if (iHitpoints + change > iMaxHitpoints) {
	 * iHitpoints = MaxHitpoints
	 * } else if (iHitpoints + change < 0){
	 * getwCaller().objecDies(this)
	 * } else {
	 * iHitpoints = iHitpoints + change
	 * }
	 */
	protected synchronized void processHealth(int change)
	{
		if (change < 0)
		{
			if (isImune()) return;
		}
		if (iHitpoints + change < 1)
		{
			iHitpoints = 0;
			getwCaller().objectDies(this);
		} else if (iHitpoints + change > 500) iHitpoints = 500;
		else iHitpoints += change;
	}

	/**
	 * checks if the ActiveObject is in air,water of magma and gives that info to processEnv function
	 *
	 * @param dt the amount of time since last checkin
	 * @effect | if wCaller.getTilePositionInTiles(this).stream.anyMatch(AIR(0) || WATER(2) || MAGMA(3))
	 * proccessEnv(dt,AIR||WATER||MAGMA)
	 */
	private void checkEnv(double dt)
	{
		LinkedList<Tile> iaSurrTiles = wCaller.getTilePositionInTiles(this);
		if (iaSurrTiles.parallelStream().anyMatch(obj -> obj.getGeoFeature() == 0))
		{
			processEnv(dt, 0);
		}
		if (iaSurrTiles.parallelStream().anyMatch(obj -> obj.getGeoFeature() == 2))
		{
			processEnv(dt, 2);
		}
		if (iaSurrTiles.parallelStream().anyMatch(obj -> obj.getGeoFeature() == 3))
		{
			processEnv(dt, 3);
		}
	}

	private void calulateAndSetTraject(double dt)
	{
		//calc new vel
		setVelocityX(correctVelocityX(getVelocity()[0] + getAcceleration()[0] * dt));
		setVelocityY(getVelocity()[1] + getAcceleration()[1] * dt);
		//calc new loc
		double newLocationX = correctLocationX(getRawLocation()[0] + (getVelocity()[0] * dt) * 100);
		double newLocationY = correctLocationY(getRawLocation()[1] + (getVelocity()[1] * dt) * 100);

		setLocation(isValidLocation(newLocationX, newLocationY));
	}

	private double[] isValidLocation(double locationX, double locationY)
	{
		//linksonder, linksboven,rechtsonder,rechtsboven
		double[] daPos = new double[]{locationX, locationY};
		//boven
		boolean linksboven = checkForWall(locationX + 2, locationY + 1);
		boolean rechtsboven = checkForWall(locationX + getSize()[0] - 2, locationY + getSize()[1] - 1);
		if (bCanFall)
		{
			setAccelerationY(-10);
		} else
		{
			setAccelerationY(0);
		}
		if (linksboven || rechtsboven)
		{
			setVelocityY(0);
			daPos[1] = getRawLocation()[1];
		}
		//onder
		boolean linksonder = checkForWall(locationX + 1, locationY - 2);
		boolean rechtsonder = checkForWall(locationX + getSize()[0] - 1, locationY - 2);
		if (linksonder || rechtsonder)
		{
			if (getVelocity()[1] <= 0)
			{
				setVelocityY(0);
				daPos[1] = getRawLocation()[1];
			}
		}
		//links
		boolean linksbenedenlinks = checkForWall(locationX - 1, locationY + 2);
		boolean linksbovenlinks = checkForWall(locationX - 1, locationY + getSize()[1] - 2);
		if (linksbenedenlinks || linksbovenlinks)
		{
			if (getVelocity()[0] < 0)
			{
				setAccelerationX(0);
				setVelocityX(0);
				daPos[0] = getRawLocation()[0];
			}

		}
		//rechts
		boolean rechtsbenedenrechts = checkForWall(locationX + getSize()[0] + 1, locationY + 2);
		boolean rechtsbovenrechts = checkForWall(locationX + getSize()[0] + 1, locationY + getSize()[1] - 2);
		if (rechtsbenedenrechts || rechtsbovenrechts)
		{
			if (getVelocity()[0] > 0)
			{
				setAccelerationX(0);
				setVelocityX(0);
				daPos[0] = getRawLocation()[0];
			}

		}

		return daPos;
	}

	@Basic
	private boolean checkForWall(double locationx, double locationy)
	{
		return checkForWall((int) locationx, (int) locationy);
	}

	@Basic
	private boolean checkForWall(int locationX, int locationY)
	{
		return wCaller.getTileinPixels(locationX, locationY).getGeoFeature() == 1;
	}

	@Basic
	public boolean isImune()
	{
		return bImune;
	}

	@Deprecated
	@Basic
	private void setImune(boolean imune)
	{
		bImune = imune;
	}

	@Basic
	public void becomsImune()
	{
		bImune = true;
	}

	@Basic
	public void isNoLongerImune()
	{
		bImune = false;
	}

	public void advanceTime(double dt)
	{
		if (controllingProgram != null)
		{
			controllingProgram.doStep(environment);
		}
		double counter = 0;
		double newDt;
		while (counter < dt)
		{
			newDt = Math.min(0.01 / (Math.abs(getVelocity()[0]) + Math.abs(getAcceleration()[0]) * dt), 0.01 / (Math.abs(getVelocity()[1]) + Math.abs(getAcceleration()[1]) * dt));
			if (newDt + counter > dt)
				newDt = dt - counter;
			counter += newDt;
			calulateAndSetTraject(newDt);
		}
		//check surrounding
		//sprite
		setSprite(correctSprite());
		//checkenv
		checkEnv(dt);
	}

	/**
	 * Starts the jump of the ActiveObject
	 *
	 * @throws IllegalStateException | if the ActiveObject is already jumping it throws an IllegalStateException
	 * @post The ActiveObject's state is set to jump
	 * | eVerState = enVerState.jump
	 * @effect The vertical velocity is set to the inital jumping velocity
	 * | setVelocityY(dInitalJump)
	 * @effect The Vertical velocity is set to the normall falling speed
	 * | setAccelerationY(-10)
	 */
	public void startJump()
	{
		if (eVerState == enVertState.jump) throw new IllegalStateException("the object is already jumping");
		eVerState = enVertState.jump;
		setVelocityY(dInitialJump);
		setAccelerationY(-10);
	}

	/**
	 * Ends the jump of the active object
	 *
	 * @throws IllegalStateException | if the ActiveObject is already jumping it throws an IllegalStateException
	 * @post The ActiveObject's state is set to stand
	 * | eVerState = enVertState.stand
	 * @effect if the ActiveObject is not already falling it's vertical velocity wil be set to 0
	 * | if (getVelocity[0] < 0) {
	 * setVelocityY(0)
	 * }
	 */
	@Immutable
	public void endJump()
	{
		if (eVerState == enVertState.stand) throw new IllegalStateException("the object is already standing");
		eVerState = enVertState.stand;
		if (getVelocity()[1] < 0) setVelocityY(0);
	}

	/**
	 * Start the movement to the left of the ActiveObject
	 *
	 * @Post The ActiveObject's stat is set to left
	 * | eHorState = enHorState.left
	 * @effect The horizontal velocity is set to the oposite of the initial velocity
	 * | setVelocityX(-dInitialVelocity)
	 * @effect The horizontal Acceleratoin is set to the oposite of the initial acceleration
	 * | setAcceleratoin(-dInitialAcceleratoin
	 */
	public void startMoveLeft()
	{
		eHorState = enHorState.left;
		setVelocityX(-dInitialVelocity);
		setAccelerationX(-dInitialAcceleration);
	}

	/**
	 * Start the movement to the right of the ActiveObject
	 *
	 * @Post The ActiveObject's stat is set to right
	 * | eHorState = enHorState.right
	 * @effect The horizontal velocity is set to the initial velocity
	 * | setVelocityX(dInitialVelocity)
	 * @effect The horizontal Acceleratoin is set to initial acceleration
	 * | setAcceleratoin(dInitialAcceleratoin
	 */
	public void startMoveRight()
	{
		eHorState = enHorState.right;
		setVelocityX(dInitialVelocity);
		setAccelerationX(dInitialAcceleration);
	}

	/**
	 * End the horizontal movement
	 *
	 * @post The ActiveObject's stat is set to stand
	 * | eHorState = enHorState.stand
	 * @effect Sets the horizontal velocity to 0
	 * | setVelocityX(0)
	 * @effect Sets the horizontal acceleration to 0
	 * | setAccelerationX(0)
	 */
	@Immutable
	public void endHorMove()
	{
		eHorState = enHorState.stand;
		setVelocityX(0);
		setAccelerationX(0);
	}

	public enum enVertState
	{
		jump, stand, duck
	}

	public enum enHorState
	{
		left, stand, right
	}
}
