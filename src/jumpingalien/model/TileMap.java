package jumpingalien.model;

import java.util.ArrayList;

/**
 * Created by covert on 02/08/15.
 */
public class TileMap {
    //collection of tiles
    private Tile[][] tileMap;
    private int iTileSize,iTargetTileX,iTargetTileY;
    public TileMap(int nbTileX, int nbTileY, int tileSize, int targetTileX, int targetTileY){
        tileMap = new Tile[nbTileX][nbTileY];
        for (int i = 0; i < nbTileX;i++){
            for (int j = 0; j < nbTileY;j++){
                tileMap[i][j] = new Tile(this,i*tileSize,j*tileSize,i,j);
            }
        }

        iTileSize = tileSize;iTargetTileX = targetTileX; iTargetTileY = targetTileY;

    }

    public int getTileSize(){
        return iTileSize;
    }

    public int[] getMapSize(){
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
    public Tile getTileInArrPoss(int tileX,int tileY){
        return tileMap[tileX][tileY];
    }

    public Tile getTile(int pixelX, int pixelY) {
        return tileMap[pixelX / iTileSize][pixelY / iTileSize];
    }

    public Tile[] getTilePositionsIn(int pixelLeft, int pixelBottom, int pixelRight, int pixelTop) {
        int temp = ((pixelRight - pixelLeft) / iTileSize + 2) * ((pixelTop - pixelBottom) / iTileSize + 2);
        Tile[] iaTile = new Tile[temp];
        int i = 0;
        for (int x = pixelLeft / iTileSize; x * iTileSize <= pixelRight; x++) {
            for (int y = pixelBottom / iTileSize; y * iTileSize <= pixelTop; y++) {
                iaTile[i] = getTileInArrPoss(x, y);
                i++;
            }
        }

        return iaTile;
    }
    public int getGeologicalFeature(int x, int y){
        return getTile(x,y).getGeoFeature();
    }
}
