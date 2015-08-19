package jumpingalien.model;

import jumpingalien.util.Sprite;

/**
 * A class representing Mazub's counterpart
 */
public class Buzam extends Mazub
{
	public Buzam(int pixelLeftX, int pixelBottomY, Sprite[] sprites)
	{
		super(pixelLeftX, pixelBottomY, sprites);
	}

	public Buzam(int pixelLeftX, int pixelBottomY, Sprite[] sprites, Program program)
	{
		super(pixelLeftX, pixelBottomY, sprites, program);
	}

	/**
	 * Handels changes to Buzam when overlapping with an other ActiveObject
	 * @param interObj
	 */
	@Override
	public void isOverlapping(ActiveObject interObj)
	{
		assert(getwCaller().getCollection(Mazub.class).size() == 2);
		if (interObj instanceof Mazub || interObj instanceof Shark){
			processHealth(-50);
			becomsImune();
		}
	}
}
