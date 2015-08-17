package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Basic;
import jumpingalien.model.programs.Environment;
import jumpingalien.util.Sprite;

import java.util.LinkedList;

public abstract class ActiveObject implements IntegratedObject
{
	//sprite var
	private final Sprite[] aSprite;
	//env procedure
	private final boolean bCanFall;
	enVertState eVerState = enVertState.stand;
	enHorState eHorState = enHorState.stand;
	double dtLastMove;
	//delta var
	protected double dLastLeftX;
	protected double dLastBottomY;
	//hitpoints
	boolean bImune = false;
	double dLastImune;
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
	private final double dInitialVelocity;
	private final double dMaxVelocity;
	private final double dInitialJump;
	//acceleration var
	private double dAccelerationX;
	private double dAccelerationY;
	private final double dInitialAcceleration;
	private int iCurrentSprite;
	private int iHitpoints;
	private Environment environment;
	public ActiveObject(int pixelLeftX, int pixelBottomY, Sprite[] sprites, int hitpoints, boolean canFall
			, double initialVelocity, double initialAcceleration, double initialJump, double maxVelocity)
	{
		dPixelLeftX = pixelLeftX;
		dPixelBottomY = pixelBottomY;
		aSprite = sprites;
		iHitpoints = hitpoints;
		bCanFall = canFall;
		dMaxVelocity = maxVelocity;
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

	int correctSprite()
	{
		if (getVelocity()[0] < 0)
		{
			return 0;
		} else
		{
			return 1;
		}
	}

	protected void correctCollision(ActiveObject collidingObj)
	{
		//TODO
	}

	private int getDirection(ActiveObject interObj)
	{
		if (interObj.getLocation()[1] + interObj.getCurrentSprite().getHeight() * 0.9 <= getLocation()[1])
		{
			return 1;

		}
		return -1;
	}//TODO

	@Deprecated
	public boolean isJumping()
	{
		return (enVertState.jump == eVerState);
	}

	@Deprecated
	public boolean isDucking()
	{
		return (enVertState.duck == eVerState);
	}

	public enHorState geteHorState()
	{
		return eHorState;
	}

	public enVertState geteVerState()
	{
		return eVerState;
	}

	public int getHealth()
	{
		return iHitpoints;
	}

	public void wCaller(World world)
	{
		wCaller = world;
	}

	public World getwCaller()
	{
		return wCaller;
	}

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

	private void setLocation(double[] iaLocation)
	{
		setLocationX(iaLocation[0]);
		setLocationY(iaLocation[1]);
	}

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

	private void setLocationX(double x)
	{
		//world check TODO
		assert x >= 0;
		//if (x < 0) throw new IllegalArgumentException("Object needs to die");
		dPixelLeftX = x;
	}

	private void setLocationY(double y)
	{
		//world check TODO
		assert y >= 0;
		//if(y < 0) throw new IllegalArgumentException("Object needs to die");
		dPixelBottomY = y;
	}

	@Basic
	public double[] getVelocity()
	{
		double[] daVelocity = new double[2];
		daVelocity[0] = dVelocityX;
		daVelocity[1] = dVelocityY;
		return daVelocity;
	}

	public void setVelocity(double[] daVelocity)
	{
		if (daVelocity.length != 2) throw new IllegalArgumentException("double array needs only an x & y value");
		//TODO test
		setVelocityX(daVelocity[0]);
		setVelocityY(daVelocity[1]);
	}

	private void setVelocityX(double x)
	{
		//TODO test def
		dVelocityX = x;
	}

	void setVelocityY(double y)
	{
		//TODO test def
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

	protected void setAcceleration(double[] daAccel) throws IllegalArgumentException
	{
		if (daAccel.length != 2) throw new IllegalArgumentException("double array needs only an x & y value");
		//TODO test
		setAccelerationX(daAccel[0]);
		setAccelerationY(daAccel[1]);
	}

	void setAccelerationX(double x)
	{
		//TODO test def
		dAccelerationX = x;
	}

	private void setAccelerationY(double y)
	{
		//TODO test def
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
	private void setSprite(int iCurrentSprite)
	{
		this.iCurrentSprite = iCurrentSprite;
	}

	public Sprite getCurrentSprite()
	{
		return aSprite[iCurrentSprite];
	}

	synchronized void FncProcessHealth(int change, boolean isImune)
	{
		if (change < 0)
		{
			if (isImune()) return;
		}
		if (iHitpoints + change < 1) wCaller.objectDies(this);
		else if (iHitpoints + change > 500) iHitpoints = 500;
		else iHitpoints += change;
	}

	private void checkEnv(double dt)
	{
		//int pixelLeft, int pixelBottom, int pixelRight, int pixelTop
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
		setVelocityX(getVelocity()[0] + getAcceleration()[0] * dt);
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

	private boolean checkForWall(double locationx, double locationy)
	{
		return checkForWall((int) locationx, (int) locationy);
	}

	private boolean checkForWall(int locationX, int locationY)
	{
		return wCaller.getTileinPixels(locationX, locationY).getGeoFeature() == 1;
	}

	public boolean isImune()
	{
		return bImune;
	}

	private void setImune(boolean imune)
	{
		bImune = imune;
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

	public void startJump()
	{
		eVerState = enVertState.jump;
		setVelocityY(dInitialJump);
		setAccelerationY(-10);
	}

	public void endJump()
	{
		eVerState = enVertState.stand;
		if (getVelocity()[1] < 0) setVelocityY(0);
	}

	public void startMoveLeft()
	{
		eHorState = enHorState.left;
		setVelocityX(-dInitialVelocity);
		setAccelerationX(-dInitialAcceleration);
	}

	@Deprecated
	public void endMoveLeft()
	{
		endHorMove();
	}

	public void startMoveRight()
	{
		eHorState = enHorState.right;
		setVelocityX(dInitialVelocity);
		setAccelerationX(dInitialAcceleration);
	}

	@Deprecated
	public void endMoveRight()
	{
		endHorMove();
	}

	public void endHorMove()
	{
		eHorState = enHorState.stand;
		setVelocityX(0);
		setAccelerationX(0);
	}

	//classe invarianten
	//state var
	protected enum enVertState
	{
		jump, stand, duck
	}

	protected enum enHorState
	{
		left, stand, right
	}
}
