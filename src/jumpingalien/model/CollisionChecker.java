package jumpingalien.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
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
        LinkedList<ActiveObject[]> collOverlap = new LinkedList<>();
        while(this.running())
        {
            try {
                ArrayList<ActiveObject> interColl = (ArrayList<ActiveObject>) worldCaller.getCollection(ActiveObject.class);
                interColl.stream().forEach(interObj -> interColl.stream().forEach(interComp -> {
                    if (interComp != interObj) {
                        if (fncIsOverlap(interComp, interObj)) {
                            collOverlap.add(new ActiveObject[]{interComp, interObj});
                        }
                    }
                }));
            }
            catch (NotImplementedException ex) {
                System.out.println("not implemented exception in collision checker");
            }
            finally {
                collOverlap.stream().forEach(object -> object[0].isOverlapping(object[1]));
                collOverlap.clear();
                sleep(10);
            }
        }
    }
    private static boolean fncIsOverlap(ActiveObject obA, ActiveObject obB){
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
