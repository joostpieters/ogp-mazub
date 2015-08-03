package jumpingalien.model;

/**
 * Created by covert on 02/08/15.
 */
public class Tile {
    //class invar
    private int iPixelX,iPixelY,iNbX,iNbY,iGeoFeature;

    public Tile(int pixelX,int pixelY,int x,int y){
        iPixelX = pixelX;iPixelY = pixelY;iNbX = x;iNbY = y;
    }

    public int[] getLocation(){
        return new int[]{iPixelX,iPixelY};
    }
    public int[] getArrayLocation(){
        return new int[]{iNbX,iNbY};
    }
    public void setGeoFeature(int GeoType){
        //TODO check
        iGeoFeature = GeoType;
    }


    public int getGeoFeature(){
        return iGeoFeature;
    }
}
