package jumpingalien.model;

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
    public Tile getTileInArrPoss(int tileX,int tileY){
        return tileMap[tileX][tileY];
    }

    public Tile getTileinPixels(int pixelX, int pixelY) {
        return getTileInArrPoss((pixelX / iTileSize),(pixelY / iTileSize));
    }

    public LinkedList<Tile> getTilePositionInTiles(int pixelLeft, int pixelBottom, int pixelRight, int pixelTop) {
        LinkedList<Tile> tileColl = new LinkedList<>();
        for (Tile[] tmpRow: tileMap){
            for (Tile tmpTile : tmpRow){

                if (pixelRight < tmpTile.getLocation()[0]){
                    continue;
                }
                if (tmpTile.getLocation()[0] + getTileSize() < pixelLeft){
                    continue;
                }
                if (pixelTop < tmpTile.getLocation()[1]){
                    continue;
                }
                if (tmpTile.getLocation()[1] + getTileSize() < pixelBottom){
                    continue;
                }
                tileColl.add(tmpTile);
            }
        }
        return tileColl;
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
