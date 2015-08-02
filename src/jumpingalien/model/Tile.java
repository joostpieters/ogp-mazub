package jumpingalien.model;

/**
 * Created by covert on 02/08/15.
 */
public class Tile {
    //class invar
    private int iX,iY,iGeoFeature;
    private TileMap tileCaller;

    public Tile(TileMap caller,int iPixelX,int iPixelY,int iX,int iY){
        tileCaller = caller;
    }

    public int[] getLocation(){
        return new int[]{iX,iY};
    }

    public void setGeoFeature(int GeoType){
        //TODO check
        iGeoFeature = GeoType;
    }

    public int getGeoFeature(){
        return iGeoFeature;
    }
}
