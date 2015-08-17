package jumpingalien.model;

import jumpingalien.util.Sprite;

public class Mazub extends ActiveObject
{
	//classe invarianten
	private double dInAir = 0;
	private boolean bInAir;
	private double dInMagma = 0;
	private boolean bInMagma;
	//sprite counter
	private int iSpriteCounter;
	private enHorState eLastHorState = enHorState.stand;

	public Mazub(int pixelLeftX, int pixelBottomY, Sprite[] sprites)
	{
		this(pixelLeftX, pixelBottomY, sprites, null);
	}

	Mazub(int pixelLeftX, int pixelBottomY, Sprite[] sprites, Program program)
	{
		super(pixelLeftX, pixelBottomY, sprites, 50, true, 1, 0.9,
				8, 3, program);
	}

	@Override
	public void isOverlapping(ActiveObject interObj)
	{
		if (interObj instanceof Plant)
		{
			if (getHealth() < 500)
			{
				FncProcessHealth(100, false);
				getwCaller().FncRemoveFromColl(interObj);
			}
			return;
		}
		if (interObj instanceof Shark)
		{
			FncProcessHealth(-50, isImune());
			bImune = true;
		}
	}

	public void startDuck()
	{
		eVerState = enVertState.duck;
	}

	public void endDuck()
	{
		eVerState = enVertState.stand;
	}

	private void processImune(double dt)
	{
		if (bImune)
		{
			dLastImune += dt;
			if (dLastImune > 0.6)
			{
				System.out.println(dLastImune);
				dLastImune = 0;
				bImune = false;
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

	public void processEnv(double dt, int iEnvType)
	{
		//water
		if (iEnvType == 2)
		{
			bInAir = true;
			dInAir += dt;
			if (dInAir <= 0.2)
			{
				dInAir -= 0.2;
				FncProcessHealth(-6, false);
			}
		}
		//magma
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
		{ //TODO check
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
