package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * A class representing the game world
 */
public class World extends TileMap
{
	private final Thread collisionThread;
	private final CollisionChecker collisionRunnable;
	//collection
	private final LinkedList<ActiveObject> colInterActive = new LinkedList<>();
	//omgevings var
	private final int iVisibleWindowWidth;
	private final int iVisibleWindowHeight;
	private enGameState eGameState;
	//player
	private Mazub player;

	/**
	 * Contructor of a World
	 *
	 * @param tileSize The size of the Game Tiles
	 * @param nbTilesX The number of tiles on the x-axis
	 * @param nbTilesY The number of tiles on the y-axis
	 * @param visibleWindowWidth The width of the visible window
	 * @param visibleWindowHeight The Height of the visible window
	 * @param targetTileX The tile number of the winning tile on the x-axis
	 * @param targetTileY The tile number of the winning tile on the y-axis
	 *
	 * @post Sets the iTileSize to the given value
	 * | iTileSize = tileSize
	 * @effect Initialises the given number of tiles in the tile array
	 * |tileArray = new Tile[nbTilesX][nbTilesY]
	 * @post The visible windows size is set to the given value
	 * |iVisibleWindowHeigt = visibleWindowHeight
	 * |iVisibleWindowWidth = visibleWindowWidth
	 * @post
	 */
	//todo collision
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
	@Basic
	public void startGame()
	{
		eGameState = enGameState.started;
	}
	@Basic
	public void setMazub(Mazub alien)
	{
		if (player != null) throw new IllegalStateException("player already set");
		player = alien;
		addObject(alien);
	}

	/**
	 * Checks if the game has ended or not
	 *
	 * @return The value indicating if the game has ended or not
	 */
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

	@Basic
	public boolean didPlayerWin()
	{
		return (eGameState == enGameState.won);
	}

	/**
	 * Calculates a rectangle representing the visible window
	 *
	 * @return An integer array being the left,bottom,right and top pixel of said window
	 * | if (InRangeOfGameWorld(middelOfPlayer - iVisibleWindowWidth / 2)) {
	 * 	left = middelOfPlayer + iVisibleWindowWidth / 2
	 *  } else {
	 *     left = 0
	 *     right = iVisibleWindowWidth
	 * }
	 *
	 */
	//TODO
	public int[] getVisibleWindow()
	{
		//left, bottom, right, top
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

	@Basic
	public void addObject(ActiveObject obj)
	{
		obj.wCaller(this);
		getColInterActive().add(obj);
	}

	@Basic
	public synchronized Collection<?> getCollection(Class obj)
	{
		ArrayList<ActiveObject> tempCol = new ArrayList<>();
		getColInterActive().stream().filter(obj::isInstance).forEach(tempCol::add);
		return tempCol;
	}

	@Basic
	private void FncRemoveFromColl(ActiveObject obj)
	{
		getColInterActive().remove(obj);
	}

	@Basic
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
