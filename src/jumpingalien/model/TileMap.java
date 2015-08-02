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

    public Tile getTile(int pixelX, int pixelY) {
        return getTileInArrPoss((pixelX / iTileSize),(pixelY / iTileSize));
    }

    public Tile[] getTilePositionInTiles(int pixelLeft, int pixelBottom, int pixelRight, int pixelTop) {
        LinkedList<Tile> tileColl = new LinkedList<>();
        for (Tile[] tmpRow: tileMap){
            for (Tile tmpTile : tmpRow){

                if (pixelLeft + pixelRight - 1 < tmpTile.getLocation()[0]){
                    tileColl.add(tmpTile);
                    continue;
                }
                if (tmpTile.getLocation()[0] + getTileSize() - 1 < pixelLeft){
                    tileColl.add(tmpTile);
                    continue;
                }
                if (pixelBottom + pixelTop - 1 < tmpTile.getLocation()[1]){
                    tileColl.add(tmpTile);
                    continue;
                }
                if (tmpTile.getLocation()[1] + getTileSize() - 1 < pixelBottom){
                    tileColl.add(tmpTile);
                }
            }
            }
        return (Tile[]) tileColl.toArray();
        }
    public int[][] getTilePositionInPixels(int pixelLeft, int pixelBottom, int pixelRight, int pixelTop){
        Tile[] tempArr = getTilePositionInTiles(pixelLeft, pixelBottom, pixelRight, pixelTop);
        int[][] tileArr = new int[tempArr.length][2];
        for (int i = 0; i < tempArr.length; i++){
            tileArr[i] = tempArr[i].getLocation();
        }
        return tileArr;
    }

    public int getGeologicalFeature(int x, int y){
        return getTile(x,y).getGeoFeature();
    }
}
