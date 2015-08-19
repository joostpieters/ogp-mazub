package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Basic;

/**
 * A class for representing the tiles used in TileMaps
 */
public class Tile
{
	//class invar
	private final int iPixelX;
	private final int iPixelY;
	private final int iNbX;
	private final int iNbY;
	private int iGeoFeature;

	/**
	 *
	 * @param pixelX The location of the tile on the x-axis
	 * @param pixelY The location of the tile on the y-axis
	 * @param x The index of the tile in the first dimention of the TileMap tiles array
	 * @param y The index of the tile in the second dimention of the TileMap tiles array
	 */
	public Tile(int pixelX, int pixelY, int x, int y)
	{
		iPixelX = pixelX;
		iPixelY = pixelY;
		iNbX = x;
		iNbY = y;
	}
	@Basic
	public int[] getLocation()
	{
		return new int[]{iPixelX, iPixelY};
	}
	@Basic
	public int[] getArrayLocation()
	{
		return new int[]{iNbX, iNbY};
	}
	@Basic
	public int getGeoFeature()
	{
		return iGeoFeature;
	}
	@Basic
	public void setGeoFeature(int GeoType)
	{
		iGeoFeature = GeoType;
	}
}
