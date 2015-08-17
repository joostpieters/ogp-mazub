package jumpingalien.model;

public class Tile
{
	//class invar
	private final int iPixelX;
	private final int iPixelY;
	private final int iNbX;
	private final int iNbY;
	private int iGeoFeature;

	public Tile(int pixelX, int pixelY, int x, int y)
	{
		iPixelX = pixelX;
		iPixelY = pixelY;
		iNbX = x;
		iNbY = y;
	}

	public int[] getLocation()
	{
		return new int[]{iPixelX, iPixelY};
	}

	public int[] getArrayLocation()
	{
		return new int[]{iNbX, iNbY};
	}

	public int getGeoFeature()
	{
		return iGeoFeature;
	}

	public void setGeoFeature(int GeoType)
	{
		iGeoFeature = GeoType;
	}
}
