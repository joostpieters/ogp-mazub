package jumpingalien.model;

import jdk.nashorn.internal.runtime.arrays.IteratorAction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by covert on 12/07/15.
 */
public class World {
    //classe invar
    //collection
    LinkedList<InteractiveObject> colInterActive = new LinkedList<>();
    //omgevings var
    private int iTileSize,iNbTilesX,iNbTilesY,iVisibleWindowWidth,iVisibleWindowHeight;
    //game state vars
    private enum enGameState{
        started,won,lost
    }
    private enGameState eGameState;
    //player
    private Mazub player;

    public World(int tileSize, int nbTilesX, int nbTilesY, int visibleWindowWidth, int visibleWindowHeight){
        iTileSize = tileSize; iNbTilesX = nbTilesX; iNbTilesY = nbTilesY;
        iVisibleWindowHeight = visibleWindowHeight; iVisibleWindowWidth = visibleWindowWidth;
    }
    public void startGame(){
        eGameState = enGameState.started;
    }

    public void setMazub(Mazub alien){
        if (player != null) throw new IllegalStateException("player already set");
        player = alien;
    }

    public boolean isGameOver(){
        switch (eGameState){
            case started:
                return false;
            case won:
                return true;
            case lost:
                return true;
            default:
                throw new IllegalStateException("unexpected gamestate");
        }
    }
    public boolean didPlayerWin(){
        switch (eGameState){
            case won:
                return true;
            default:
                return false;
        }
    }

    public int[] getWorldSizeInPixel(){
        int[] iaSize = new int[2];
        iaSize[0] = iTileSize * iNbTilesX;
        iaSize[1] = iTileSize * iNbTilesY;
        return iaSize;
    }

    public int getTileSize(){
        return iTileSize;
    }

    public void advanceTime(double dt){
        player.advanceTime(dt);
    }
    //left, bottom, right, top
    public int[] getVisibleWindow()throws IllegalStateException {
        int[] iaWindow = new int[4];
        int iMidX = player.getLocation()[0] + player.getSize()[0] / 2;
        int iMidY = player.getLocation()[1] + player.getSize()[1] / 2;
        iaWindow[0] = iMidX - iVisibleWindowWidth / 2;
        if (iaWindow[0] < 0) {
            iaWindow[2] = iVisibleWindowWidth;
            iaWindow[0] = 0;
        }

        iaWindow[1] = iMidY - iVisibleWindowHeight / 2;
        if (iaWindow[1] < 0) {
            iaWindow[3] = iVisibleWindowHeight;
            iaWindow[1] = 0;
        }

        iaWindow[2] = (iaWindow[2] == iVisibleWindowWidth) ? iVisibleWindowWidth : iMidX + iVisibleWindowWidth / 2;
        if (iaWindow[2] > getWorldSizeInPixel()[0]) {
            iaWindow[0] = getWorldSizeInPixel()[0] - iVisibleWindowWidth;
            iaWindow[2] = getWorldSizeInPixel()[0];
        }

        iaWindow[3] = (iaWindow[3] == iVisibleWindowHeight) ? iVisibleWindowHeight : iMidY + iVisibleWindowHeight / 2;
        if (iaWindow[3] > getWorldSizeInPixel()[1]) {
            iaWindow[1] = getWorldSizeInPixel()[1] - iVisibleWindowHeight;
            iaWindow[3] = getWorldSizeInPixel()[1];
        }
        return iaWindow;
    }

    public int[] getBottomLeftPixelOfTile(int tileX, int tileY) {
        int[] pixel = new int[2];
        pixel[0] = iTileSize * tileX;
        pixel[1] = iTileSize * tileY;
        return pixel;
    }


    public int[][] getTilePositionsIn(int pixelLeft, int pixelBottom, int pixelRight, int pixelTop) {
        int temp = ((pixelRight - pixelLeft) / iTileSize + 2) * ((pixelTop - pixelBottom) / iTileSize + 2);
        int[][] iaPos = new int[temp][2];
        int i = 0;
        for (int x = pixelLeft; x <= pixelRight + iTileSize; x += iTileSize) {
            for (int y = pixelBottom; y <= pixelTop + iTileSize; y += iTileSize) {
                iaPos[i] = getTile(x, y);
                i++;
            }
        }

        return iaPos;
    }
    private int[] getTile(int pixelX, int pixelY) {
        return new int[]{pixelX / iTileSize, pixelY / iTileSize};
    }
    public void addObject(InteractiveObject obj){
        colInterActive.add(obj);
    }
    public Collection<?> getCollection(Class obj){
        ArrayList<InteractiveObject> tempCol = new ArrayList<>();
        colInterActive.stream().filter(obj::isInstance).forEach(tempCol::add);
        return tempCol;
    }

}
