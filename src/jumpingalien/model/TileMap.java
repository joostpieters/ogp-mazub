package jumpingalien.model;

import java.security.InvalidParameterException;
import java.util.LinkedList;
public class TileMap {
    //collection of tiles
    private final Tile[][] tileMap;
    private final int iTileSize;
    private final int iTargetTileX;
    private final int iTargetTileY;
    public TileMap(int nbTileX, int nbTileY, int tileSize, int targetTileX, int targetTileY){
        tileMap = new Tile[nbTileX][nbTileY];
        for (int i = 0; i < nbTileX;i++){
            for (int j = 0; j < nbTileY;j++){
                tileMap[i][j] = new Tile(i*tileSize,j*tileSize,i,j);
            }
        }

        iTileSize = tileSize;iTargetTileX = targetTileX; iTargetTileY = targetTileY;

    }

    public int getTileSize(){
        return iTileSize;
    }

    public int[] getMaxTilePixel(){
        return new int[]{tileMap.length * getTileSize() - getTileSize(), tileMap[0].length * getTileSize() - getTileSize()};
    }
    public int[] getWorldSizeInPixel(){
        int[] iaSize = new int[2];
        iaSize[0] = iTileSize * tileMap.length;
        iaSize[1] = iTileSize * tileMap[0].length;
        return iaSize;
    }

    public Tile getWinningTile(){
        return tileMap[iTargetTileX][iTargetTileY];
    }

    public void setGeoFeature(int tileX, int tileY, int tileType){
        tileMap[tileX][tileY].setGeoFeature(tileType);
    }
    public Tile getTileInArrPoss(int tileX,int tileY) throws ArrayIndexOutOfBoundsException{
        return tileMap[tileX][tileY];
    }

    public Tile getTileinPixels(int pixelX, int pixelY) throws ArrayIndexOutOfBoundsException{
        roundToTile(pixelX);roundToTile(pixelY);
        return getTileInArrPoss((pixelX / iTileSize),(pixelY / iTileSize));
    }

    private int roundToTile(int tileCoor){
        tileCoor = tileCoor < 0 ? 0 : tileCoor;
        return (int) (Math.floor((tileCoor) / getTileSize()) * getTileSize());
    }

    public LinkedList<Tile> getTilePositionInTiles(int pixelLeft, int pixelBottom, int pixelRight, int pixelTop) {
        //int grooteArray = ((pixelRight - pixelLeft) / getTileSize() + 2) * ((pixelTop - pixelBottom) / getTileSize() + 2);
        LinkedList<Tile> tiles = new LinkedList<>();
        pixelBottom = roundToTile(pixelBottom);
        pixelLeft = roundToTile(pixelLeft);
        pixelRight = roundToTile(pixelRight);
        pixelTop = roundToTile(pixelTop);
        for (int y = pixelBottom; y <= pixelTop ; y += getTileSize()) {
            for (int x = pixelLeft; x <= pixelRight ; x += getTileSize()) {
                if (x <= getMaxTilePixel()[0] && y <= getMaxTilePixel()[1]) {
                    tiles.add(getTileinPixels(x, y));
                }
            }
        }

        return tiles;
        }
    public int[][] getTilePositionInArray(int pixelLeft, int pixelBottom, int pixelRight, int pixelTop){
        LinkedList<Tile> tileColl = getTilePositionInTiles(pixelLeft, pixelBottom, pixelRight, pixelTop);
        int[][] tileArr = new int[tileColl.size()][2];
        for (int i = 0; i < tileArr.length; i++){
            tileArr[i] = tileColl.pop().getArrayLocation();
        }
        return tileArr;
    }

    public int getGeologicalFeature(int pixelX, int pixelY){
        return getTileinPixels(pixelX,pixelY).getGeoFeature();
    }
}
