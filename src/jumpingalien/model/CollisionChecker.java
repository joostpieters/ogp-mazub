package jumpingalien.model;

import java.util.LinkedList;

/**
 * Created by covert on 16/07/15.
 */
public class CollisionChecker implements Runnable
{
    private boolean isRunning = true;
    private World worldCaller;

    public CollisionChecker(World world){
        worldCaller = world;
    }

    public synchronized boolean running()
    {
        return this.isRunning;
    }

    public synchronized void stop()
    {
        this.isRunning = false;
    }

    private void sleep(long duration)
    {
        try
        {
            Thread.sleep(duration);
        }
        catch(InterruptedException ignored) {}
    }

    @Override
    public void run()
    {
        LinkedList<InteractiveObject[]> collOverlap = new LinkedList<>();
        while(this.running())
        {

            worldCaller.getStream().parallel().forEach(interObj -> {
                worldCaller.getStream().forEach(interComp -> {
                    if (interComp != interObj){
                        if (fncIsOverlap(interComp,interObj)){
                            collOverlap.add(new InteractiveObject[]{interComp, interObj});
                        }
                    }
                });
            });
            collOverlap.stream().forEach(object -> object[0].isOverlapping(object[0]));
            this.sleep(10);
        }
    }
    private boolean fncIsOverlap(InteractiveObject obA, InteractiveObject obB){
        int iAX = obA.getSize()[0];
        int iAY = obA.getSize()[1];
        int iBX = obB.getSize()[0];
        int iBY = obB.getSize()[1];

        if (obA.getLocation()[0] + iAX - 1 < obB.getLocation()[0]){
            return false;
        }
        if (obB.getLocation()[0] + iBX - 1 < obA.getLocation()[0]){
            return false;
        }
        if (obA.getLocation()[1] + iAY - 1 < obB.getLocation()[1]){
            return false;
        }
        if (obB.getLocation()[1] + iBY - 1 < obA.getLocation()[1]){
            return false;
        }
        return true;
    }
}
