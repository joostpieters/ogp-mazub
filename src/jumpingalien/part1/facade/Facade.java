package jumpingalien.part1.facade;

import jumpingalien.model.Mazub;
import jumpingalien.util.Sprite;

public class Facade implements IFacade
{
	/**
	 * Create an instance of Mazub.
	 *
	 * @param pixelLeftX   The x-location of Mazub's bottom left pixel.
	 * @param pixelBottomY The y-location of Mazub's bottom left pixel.
	 * @param sprites      The array of sprite images for Mazub.
	 * @return
	 */
	@Override
	public Mazub createMazub(int pixelLeftX, int pixelBottomY, Sprite[] sprites)
	{
		return new Mazub(pixelLeftX, pixelBottomY, sprites);
	}

	/**
	 * Return the current location of the given alien.
	 *
	 * @param alien The alien of which to get the location.
	 * @return an array, consisting of 2 integers {x, y}, that represents the
	 * coordinates of the given alien's bottom left pixel in the world.
	 */
	@Override
	public int[] getLocation(Mazub alien)
	{
		return alien.getLocation();
	}

	/**
	 * Return the current velocity (in m/s) of the given alien.
	 *
	 * @param alien The alien of which to get the velocity.
	 * @return an array, consisting of 2 doubles {vx, vy}, that represents the
	 * horizontal and vertical components of the given alien's current
	 * velocity, in units of m/s.
	 */
	@Override
	public double[] getVelocity(Mazub alien)
	{
		return alien.getVelocity();
	}

	/**
	 * Return the current acceleration (in m/s^2) of the given alien.
	 *
	 * @param alien The alien of which to get the acceleration.
	 * @return an array, consisting of 2 doubles {ax, ay}, that represents the
	 * horizontal and vertical components of the given alien's current
	 * acceleration, in units of m/s^2.
	 */
	@Override
	public double[] getAcceleration(Mazub alien)
	{
		return alien.getAcceleration();
	}

	/**
	 * Return the current size of the given alien.
	 *
	 * @param alien The alien of which to get the size.
	 * @return An array, consisting of 2 integers {w, h}, that represents the
	 * current width and height of the given alien, in number of pixels.
	 */
	@Override
	public int[] getSize(Mazub alien)
	{
		return alien.getSize();
	}

	/**
	 * Return the current sprite image for the given alien.
	 *
	 * @param alien The alien for which to get the current sprite image.
	 * @return The current sprite image for the given alien, determined by its
	 * state as defined in the assignment.
	 */
	@Override
	public Sprite getCurrentSprite(Mazub alien)
	{
		return alien.getCurrentSprite();
	}

	/**
	 * Make the given alien jump.
	 *
	 * @param alien The alien that has to start jumping.
	 */
	@Override
	public void startJump(Mazub alien)
	{
		alien.startJump();
	}

	/**
	 * End the given alien's jump.
	 *
	 * @param alien The alien that has to stop jumping.
	 */
	@Override
	public void endJump(Mazub alien)
	{
		alien.endJump();
	}

	/**
	 * Make the given alien move left.
	 *
	 * @param alien The alien that has to start moving left.
	 */
	@Override
	public void startMoveLeft(Mazub alien)
	{
		alien.startMoveLeft();
	}

	/**
	 * End the given alien's left move.
	 *
	 * @param alien The alien that has to stop moving left.
	 */
	@Override
	public void endMoveLeft(Mazub alien)
	{
		alien.endHorMove();
	}

	/**
	 * Make the given alien move right.
	 *
	 * @param alien The alien that has to start moving right.
	 */
	@Override
	public void startMoveRight(Mazub alien)
	{
		alien.startMoveRight();
	}

	/**
	 * End the given alien's right move.
	 *
	 * @param alien The alien that has to stop moving right.
	 */
	@Override
	public void endMoveRight(Mazub alien)
	{
		alien.endMoveRight();
	}

	/**
	 * Make the given alien duck.
	 *
	 * @param alien The alien that has to start ducking.
	 */
	@Override
	public void startDuck(Mazub alien)
	{
		alien.startDuck();
	}

	/**
	 * End the given alien's ducking.
	 *
	 * @param alien The alien that has to stop ducking.
	 */
	@Override
	public void endDuck(Mazub alien)
	{
		alien.endDuck();
	}

	/**
	 * Advance the state of the given alien by the given time period.
	 *
	 * @param alien The alien whose time has to be advanced.
	 * @param dt    The time interval (in seconds) by which to advance the given
	 */
	@Override
	public void advanceTime(Mazub alien, double dt)
	{
		alien.advanceTime(dt);
	}
}
