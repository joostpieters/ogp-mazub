package jumpingalien.model;

/**
 * Created by covert on 04/08/15.
 */
public interface IntegratedObject {

    public void isOverlapping(ActiveObject interObj);

    public void advanceTime(double dt);

    public void processEnv(int iEnvType);

}
