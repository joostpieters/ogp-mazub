package jumpingalien.model;

public class Tile
{
	//class invar
	private int iPixelX, iPixelY, iNbX, iNbY, iGeoFeature;

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
