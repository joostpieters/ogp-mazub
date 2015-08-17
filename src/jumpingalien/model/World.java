package jumpingalien.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class World extends TileMap
{
	//classe invar
	Thread collisionThread;
	CollisionChecker collisionRunnable;
	//collection
	private LinkedList<ActiveObject> colInterActive = new LinkedList<>();
	//omgevings var
	private int iVisibleWindowWidth, iVisibleWindowHeight;
	private enGameState eGameState;
	//player
	private Mazub player;

	public World(int tileSize, int nbTilesX, int nbTilesY, int visibleWindowWidth, int visibleWindowHeight, int targetTileX, int targetTileY)
	{
		super(nbTilesX, nbTilesY, tileSize, targetTileX, targetTileY);
		iVisibleWindowHeight = visibleWindowHeight;
		iVisibleWindowWidth = visibleWindowWidth;
		collisionRunnable = new CollisionChecker(this);
		this.collisionThread = new Thread(collisionRunnable);
		collisionThread.start();

	}

	private synchronized LinkedList<ActiveObject> getColInterActive()
	{
		return colInterActive;
	}

	public void startGame()
	{
		eGameState = enGameState.started;
	}

	public void setMazub(Mazub alien)
	{
		if (player != null) throw new IllegalStateException("player already set");
		player = alien;
		addObject(alien);
	}

	public boolean isGameOver()
	{
		//TODO check hoe moet uitgewerktworden
		switch (eGameState)
		{
			case started:
				return false;
			case won:
				return true;
			case lost:
				return true;
			default:
				throw new IllegalStateException("unexpected gamestate");
		}
	}

	public boolean didPlayerWin()
	{
		return (eGameState == enGameState.won);
	}

	//left, bottom, right, top
	public int[] getVisibleWindow() throws IllegalStateException
	{
		int[] iaWindow = new int[4];
		int iMidX = player.getLocation()[0] + player.getSize()[0] / 2;
		int iMidY = player.getLocation()[1] + player.getSize()[1] / 2;
		iaWindow[0] = iMidX - iVisibleWindowWidth / 2;
		if (iaWindow[0] < 0)
		{
			iaWindow[2] = iVisibleWindowWidth;
			iaWindow[0] = 0;
		}

		iaWindow[1] = iMidY - iVisibleWindowHeight / 2;
		if (iaWindow[1] < 0)
		{
			iaWindow[3] = iVisibleWindowHeight;
			iaWindow[1] = 0;
		}

		iaWindow[2] = (iaWindow[2] == iVisibleWindowWidth) ? iVisibleWindowWidth : iMidX + iVisibleWindowWidth / 2;
		if (iaWindow[2] > getWorldSizeInPixel()[0])
		{
			iaWindow[0] = getWorldSizeInPixel()[0] - iVisibleWindowWidth;
			iaWindow[2] = getWorldSizeInPixel()[0];
		}

		iaWindow[3] = (iaWindow[3] == iVisibleWindowHeight) ? iVisibleWindowHeight : iMidY + iVisibleWindowHeight / 2;
		if (iaWindow[3] > getWorldSizeInPixel()[1])
		{
			iaWindow[1] = getWorldSizeInPixel()[1] - iVisibleWindowHeight;
			iaWindow[3] = getWorldSizeInPixel()[1];
		}
		return iaWindow;
	}

	public void addObject(ActiveObject obj)
	{
		obj.wCaller(this);
		getColInterActive().add(obj);
	}

	public synchronized Collection<?> getCollection(Class obj)
	{
		ArrayList<ActiveObject> tempCol = new ArrayList<>();
		getColInterActive().stream().filter(obj::isInstance).forEach(tempCol::add);
		return tempCol;
	}

	public void FncRemoveFromColl(ActiveObject obj)
	{
		getColInterActive().remove(obj);
	}

	public void objectDies(ActiveObject obj)
	{
		if (obj == player)
		{
			eGameState = enGameState.lost;
		}
		FncRemoveFromColl(obj);
	}

	public void advanceTime(double dt)
	{
		try
		{
			if (getTilePositionInTiles(player).stream().anyMatch(obj -> obj == getWinningTile()))
				eGameState = enGameState.won;
		} catch (ArrayIndexOutOfBoundsException ex)
		{
			System.out.print("no valid winning tile");
		}
		//player.advanceTime(dt);
		getColInterActive().stream().forEach(obj -> obj.advanceTime(dt));
	}

	protected void finialize()
	{
		//todo collisionRunnable.stop();
		collisionRunnable.stop();
	}

	//game state vars
	private enum enGameState
	{
		started, won, lost
	}

}
