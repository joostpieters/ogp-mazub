package jumpingalien.model;

import jumpingalien.util.Sprite;

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
}
