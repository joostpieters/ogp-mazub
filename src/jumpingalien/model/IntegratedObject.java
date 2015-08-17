package jumpingalien.model;

/**
 * Created by covert on 04/08/15.
 */
public interface IntegratedObject
{

	void startJump();

	void endJump();

	void startMoveLeft();

	void endMoveLeft();

	void startMoveRight();

	void endMoveRight();

	void startDuck();

	void endDuck();

	void isOverlapping(ActiveObject interObj);

	void advanceTime(double dt);

	void processEnv(double dt, int iEnvType);

}
