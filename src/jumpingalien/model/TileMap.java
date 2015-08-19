package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Basic;

import java.util.LinkedList;

/**
 * A class for managing Tiles
 */
public class TileMap
{
	//collection of tiles
	private final Tile[][] tileMap;
	private final int iTileSize;
	private final int iTargetTileX;
	private final int iTargetTileY;

	/**
	 * The constructor of a TileMap
	 *
	 * @param nbTileX The number of tiles in the width of the TileMap
	 * @param nbTileY The number of tiles in the Height of the TileMap
	 * @param tileSize The size of Tiles to be created
	 * @param targetTileX The array location in the first dimention of the tile array of the winning tile
	 * @param targetTileY The array location in the second dimention of the tile array of the winning tile
	 *
	 * @post The tilemap is initialised with its new tiles
	 * |tilemap[tileLocationX][tileLocationY] = new Tile(tileLocationX,tileLocationY,pixelYLocation,pixelXLocation)
	 * @post The winning tile is set to the given value
	 * |iTargetTileX = targetTileX
	 *  iTargetTiley = targetTiley
	 */
	TileMap(int nbTileX, int nbTileY, int tileSize, int targetTileX, int targetTileY)
	{
		tileMap = new Tile[nbTileX][nbTileY];
		for (int i = 0; i < nbTileX; i++)
		{
			for (int j = 0; j < nbTileY; j++)
			{
				tileMap[i][j] = new Tile(i * tileSize, j * tileSize, i, j);
			}
		}

		iTileSize = tileSize;
		iTargetTileX = targetTileX;
		iTargetTileY = targetTileY;

	}
	@Basic
	public int getTileSize()
	{
		return iTileSize;
	}
	@Basic
	private int[] getMaxTilePixel()
	{
		return new int[]{tileMap.length * getTileSize() - getTileSize(), tileMap[0].length * getTileSize() - getTileSize()};
	}

	@Basic
	public int[] getWorldSizeInPixel()
	{
		int[] iaSize = new int[2];
		iaSize[0] = iTileSize * tileMap.length;
		iaSize[1] = iTileSize * tileMap[0].length;
		return iaSize;
	}

	@Basic
	Tile getWinningTile() throws ArrayIndexOutOfBoundsException
	{
		return tileMap[iTargetTileX][iTargetTileY];
	}

	@Basic
	public void setGeoFeature(int tileX, int tileY, int tileType) throws ArrayIndexOutOfBoundsException
	{
		tileMap[tileX][tileY].setGeoFeature(tileType);
	}

	@Basic
	public Tile getTileInArrPoss(int tileX, int tileY) throws ArrayIndexOutOfBoundsException
	{
		return tileMap[tileX][tileY];
	}

	@Basic
	public Tile getTileinPixels(int pixelX, int pixelY) throws ArrayIndexOutOfBoundsException
	{
		roundToTile(pixelX);
		roundToTile(pixelY);
		return getTileInArrPoss((pixelX / iTileSize), (pixelY / iTileSize));
	}

	/**
	 * Rounds down to the nearest tile
	 * @param tileCoor The coordinate on eighter the x or y-axis
	 *
	 * @return The x or y coordinate of the nearest tile lower than the tileCoor
	 */
	private int roundToTile(int tileCoor)
	{
		tileCoor = tileCoor < 0 ? 0 : tileCoor;
		return (int) (Math.floor((tileCoor) / getTileSize()) * getTileSize());
	}

	/**
	 * Gets all tile in the area of the given ActiveObject
	 * @param obj The ActiveObject of in the area you want the tiles from
	 *
	 * @return A list of tiles in the area of the ActiveObject
	 */
	public LinkedList<Tile> getTilePositionInTiles(ActiveObject obj)
	{
		return getTilePositionInTiles(obj.getLocation()[0], obj.getLocation()[1]
				, obj.getLocation()[0] + obj.getCurrentSprite().getWidth()
				, obj.getLocation()[1] + obj.getCurrentSprite().getHeight());
	}

	/**
	 * Gets all tile in an area
	 * @param pixelLeft The left pixel in the area
	 * @param pixelBottom The bottom pixel in the area
	 * @param pixelRight The right pixel in the area
	 * @param pixelTop The top pixel in the area
	 *
	 * @return A list of tiles in the given area
	 */
	private LinkedList<Tile> getTilePositionInTiles(int pixelLeft, int pixelBottom, int pixelRight, int pixelTop)
	{
		//int grooteArray = ((pixelRight - pixelLeft) / getTileSize() + 2) * ((pixelTop - pixelBottom) / getTileSize() + 2);
		LinkedList<Tile> tiles = new LinkedList<>();
		pixelBottom = roundToTile(pixelBottom);
		pixelLeft = roundToTile(pixelLeft);
		pixelRight = roundToTile(pixelRight);
		pixelTop = roundToTile(pixelTop);
		for (int y = pixelBottom; y <= pixelTop; y += getTileSize())
		{
			for (int x = pixelLeft; x <= pixelRight; x += getTileSize())
			{
				if (x <= getMaxTilePixel()[0] && y <= getMaxTilePixel()[1])
				{
					tiles.add(getTileinPixels(x, y));
				}
			}
		}

		return tiles;
	}

	/**
	 * Gets all tile in an area
	 * @param pixelLeft The left pixel in the area
	 * @param pixelBottom The bottom pixel in the area
	 * @param pixelRight The right pixel in the area
	 * @param pixelTop The top pixel in the area
	 *
	 * @return An array of array locations of the tiles in the given area
	 */
	public int[][] getTilePositionInArray(int pixelLeft, int pixelBottom, int pixelRight, int pixelTop)
	{
		LinkedList<Tile> tileColl = getTilePositionInTiles(pixelLeft, pixelBottom, pixelRight, pixelTop);
		int[][] tileArr = new int[tileColl.size()][2];
		for (int i = 0; i < tileArr.length; i++)
		{
			tileArr[i] = tileColl.pop().getArrayLocation();
		}
		return tileArr;
	}

	@Basic
	public int getGeologicalFeature(int pixelX, int pixelY)
	{
		return getTileinPixels(pixelX, pixelY).getGeoFeature();
	}
}
