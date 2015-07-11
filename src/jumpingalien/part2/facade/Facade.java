package jumpingalien.part2.facade;

import jumpingalien.model.Mazub;
import jumpingalien.util.ModelException;
import jumpingalien.util.Sprite;

import java.util.Collection;

/**
 * Created by covert on 12/07/15.
 */
public class Facade implements IFacadePart2 {
    /**
     * Returns the current number of hitpoints of the given alien.
     *
     * @param alien
     */
    @Override
    public int getNbHitPoints(Mazub alien) {
        return 0;
    }

    /**
     * Create a new game world with the given parameters.
     *
     * @param tileSize            Length (in pixels) of a side of each square tile in the world
     * @param nbTilesX            Number of tiles in the horizontal direction
     * @param nbTilesY            Number of tiles in the vertical direction
     * @param visibleWindowWidth  Width of the visible window, in pixels
     * @param visibleWindowHeight Height of the visible window, in pixels
     * @param targetTileX         Tile x-coordinate of the target tile of the created world
     * @param targetTileY
     */
    @Override
    public World createWorld(int tileSize, int nbTilesX, int nbTilesY, int visibleWindowWidth, int visibleWindowHeight, int targetTileX, int targetTileY) {
        return null;
    }

    /**
     * Returns the size of the given game world, in number of pixels.
     *
     * @param world The world for which to return the size.
     * @return The size of the game world, in pixels, as an array of two
     * elements: width (X) and height (Y), in that order.
     */
    @Override
    public int[] getWorldSizeInPixels(World world) {
        return new int[0];
    }

    /**
     * Returns the length of a square tile side in the given world.
     *
     * @param world The game world for which to retrieve the tile length
     * @return The length of a square tile side, expressed as a number of
     * pixels.
     */
    @Override
    public int getTileLength(World world) {
        return 0;
    }

    /**
     * Starts the game that is played in the given world.
     * After this method has been invoked, no further game objects will be added
     * via {@link IFacadePart2#addPlant(World, Plant)},
     * {@link IFacadePart2#addShark(World, Shark)},
     * {@link IFacadePart2#addSlime(World, Slime)}, or
     * {@link IFacadePart2#setMazub(World, Mazub)}), and no geological features
     * will be changed via
     * {@link IFacadePart2#setGeologicalFeature(World, int, int, int)}.
     *
     * @param world
     */
    @Override
    public void startGame(World world) {

    }

    /**
     * Returns whether the game, played in the given game world, is over.
     * The game is over when Mazub has died, or has reached the target tile.
     *
     * @param world The world for which to check whether the game is over
     * @return true if the game is over, false otherwise.
     */
    @Override
    public boolean isGameOver(World world) {
        return false;
    }

    /**
     * Returns whether the game played in the given world has finished and the
     * player has won. The player wins when Mazub has reached the target tile.
     *
     * @param world The world for which to check whether the player won
     * @return true if the game is over and the player has won; false otherwise.
     */
    @Override
    public boolean didPlayerWin(World world) {
        return false;
    }

    /**
     * Advance the time for the world and all its objects by the given amount.
     * <p>
     * This method replaces {@link IFacadePart2#advanceTime(Mazub, double)}.
     *
     * @param world The world whose time needs to advance
     * @param dt    The time interval (in seconds) by which to advance the given
     */
    @Override
    public void advanceTime(World world, double dt) {

    }

    /**
     * @param alien
     * @param dt
     * @deprecated This method no longer needs to be implemented in your facade.
     * It has been replaced by
     * {@link IFacadePart2#advanceTime(World, double)}.
     */
    @Override
    public void advanceTime(Mazub alien, double dt) {
        alien.advanceTime(dt);
    }

    /**
     * Return the coordinates of the rectangular visible window that moves
     * together with Mazub.
     *
     * @param world
     * @return The pixel coordinates of the visible window, in the order
     * <b>left, bottom, right, top</b>.
     */
    @Override
    public int[] getVisibleWindow(World world) {
        return new int[0];
    }

    /**
     * Returns the bottom left pixel coordinate of the tile at the given tile
     * position.
     *
     * @param world The world from which to retrieve the tile.
     * @param tileX The x-position x_T of the tile
     * @param tileY The y-position y_T of the tile
     * @return An array which contains the x-coordinate and y-coordinate of the
     * bottom left pixel of the given tile, in that order.
     */
    @Override
    public int[] getBottomLeftPixelOfTile(World world, int tileX, int tileY) {
        return new int[0];
    }

    /**
     * Returns the tile positions of all tiles within the given rectangular
     * region.
     *
     * @param world       The world from which the tile positions should be returned.
     * @param pixelLeft   The x-coordinate of the left side of the rectangular region.
     * @param pixelBottom The y-coordinate of the bottom side of the rectangular region.
     * @param pixelRight  The x-coordinate of the right side of the rectangular region.
     * @param pixelTop    The y-coordinate of the top side of the rectangular region.
     * @return An array of tile positions, where each position (x_T, y_T) is
     * represented as an array of 2 elements, containing the horizontal
     * (x_T) and vertical (y_T) coordinate of a tile in that order.
     * The returned array is ordered from left to right,
     * bottom to top: all positions of the bottom row (ordered from
     * small to large x_T) precede the positions of the row above that.
     */
    @Override
    public int[][] getTilePositionsIn(World world, int pixelLeft, int pixelBottom, int pixelRight, int pixelTop) {
        return new int[0][];
    }

    /**
     * Returns the geological feature of the tile with its bottom left pixel at
     * the given position.
     *
     * @param world  The world containing the tile for which the
     *               geological feature should be returned.
     * @param pixelX The x-position of the pixel at the bottom left of the tile for
     *               which the geological feature should be returned.
     * @param pixelY The y-position of the pixel at the bottom left of the tile for
     *               which the geological feature should be returned.
     * @return The type of the tile with the given bottom left pixel position,
     * where
     * <ul>
     * <li>the value 0 is returned for an <b>air</b> tile;</li>
     * <li>the value 1 is returned for a <b>solid ground</b> tile;</li>
     * <li>the value 2 is returned for a <b>water</b> tile;</li>
     * <li>the value 3 is returned for a <b>magma</b> tile.</li>
     * </ul>
     * @note This method must return its result in constant time.
     * @throw ModelException if the given position does not correspond to the
     * bottom left pixel of a tile.
     */
    @Override
    public int getGeologicalFeature(World world, int pixelX, int pixelY) throws ModelException {
        return 0;
    }

    /**
     * Modify the geological type of a specific tile in the given world to a
     * given type.
     *
     * @param world    The world in which the geological type of a tile needs to be
     *                 modified
     * @param tileX    The x-position x_T of the tile for which the type needs to be
     *                 modified
     * @param tileY    The y-position y_T of the tile for which the type needs to be
     *                 modified
     * @param tileType The new type for the given tile, where
     *                 <ul>
     *                 <li>the value 0 is provided for an <b>air</b> tile;</li>
     *                 <li>the value 1 is provided for a <b>solid ground</b> tile;</li>
     *                 <li>the value 2 is provided for a <b>water</b> tile;</li>
     *                 <li>the value 3 is provided for a <b>magma</b> tile.</li>
     */
    @Override
    public void setGeologicalFeature(World world, int tileX, int tileY, int tileType) {

    }

    /**
     * Sets the given alien as the player's character in the given world.
     *
     * @param world The world for which to set the player's character.
     * @param alien
     */
    @Override
    public void setMazub(World world, Mazub alien) {

    }

    /**
     * Returns whether the given alien is currently immune against enemies (see
     * section 1.2.5 of the assignment).
     *
     * @param alien The alien for which to retrieve the immunity status.
     * @return True if the given alien is immune against other enemies (i.e.,
     * there are no interactions between the alien and enemy objects).
     */
    @Override
    public boolean isImmune(Mazub alien) {
        return false;
    }

    /**
     * Creates a new plant, located at the provided pixel location (x, y).
     * The returned plant should not belong to a world.
     *
     * @param x       The x-coordinate of the plant's initial position
     * @param y       The y-coordinate of the plant's initial position
     * @param sprites An array of sprites for the new plant
     * @return A new plant, located at the provided location. The returned plant
     * should not belong to a world.
     */
    @Override
    public Plant createPlant(int x, int y, Sprite[] sprites) {
        return null;
    }

    /**
     * Add the given plant as a game object to the given world.
     *
     * @param world The world to which the plant should be added.
     * @param plant
     */
    @Override
    public void addPlant(World world, Plant plant) {

    }

    /**
     * Returns all the plants currently located in the given world.
     *
     * @param world The world for which to retrieve all plants.
     * @return All plants that are located somewhere in the given world. There
     * are no restrictions on the type or order of the returned
     * collection, but each plant may only be returned once.
     */
    @Override
    public Collection<Plant> getPlants(World world) {
        return null;
    }

    /**
     * Returns the current location of the given plant.
     *
     * @param plant The plant of which to find the location
     * @return An array, consisting of 2 integers {x, y}, that represents the
     * coordinates of the given plant's bottom left pixel in the world.
     */
    @Override
    public int[] getLocation(Plant plant) {
        return new int[0];
    }

    /**
     * Return the current sprite image for the given plant.
     *
     * @param plant The plant for which to get the current sprite image.
     * @return The current sprite image for the given plant, determined by its
     * orientation as defined in the assignment.
     */
    @Override
    public Sprite getCurrentSprite(Plant plant) {
        return null;
    }

    /**
     * Creates a new shark, located at the provided pixel location (x, y).
     * The returned shark should not belong to a world.
     *
     * @param x       The x-coordinate of the shark's initial position
     * @param y       The y-coordinate of the shark's initial position
     * @param sprites An array of sprites for the new shark
     * @return A new shark, located at the provided location. The returned shark
     * should not belong to a world.
     */
    @Override
    public Shark createShark(int x, int y, Sprite[] sprites) {
        return null;
    }

    /**
     * Add the given shark as a game object to the given world.
     *
     * @param world The world to which the shark should be added.
     * @param shark
     */
    @Override
    public void addShark(World world, Shark shark) {

    }

    /**
     * Returns all the sharks currently located in the given world.
     *
     * @param world The world for which to retrieve all sharks.
     * @return All sharks that are located somewhere in the given world. There
     * are no restrictions on the type or order of the returned
     * collection, but each shark may only be returned once.
     */
    @Override
    public Collection<Shark> getSharks(World world) {
        return null;
    }

    /**
     * Returns the current location of the given shark.
     *
     * @param shark The shark of which to find the location
     * @return An array, consisting of 2 integers {x, y}, that represents the
     * coordinates of the given shark's bottom left pixel in the world.
     */
    @Override
    public int[] getLocation(Shark shark) {
        return new int[0];
    }

    /**
     * Return the current sprite image for the given shark.
     *
     * @param shark The shark for which to get the current sprite image.
     * @return The current sprite image for the given shark, determined by its
     * orientation as defined in the assignment.
     */
    @Override
    public Sprite getCurrentSprite(Shark shark) {
        return null;
    }

    /**
     * Creates a new slime school.
     *
     * @return A new school for slimes, without any members.
     */
    @Override
    public School createSchool() {
        return null;
    }

    /**
     * Creates a new slime, located at the provided pixel location (x, y).
     * The returned slime should not belong to a world.
     *
     * @param x       The x-coordinate of the slime's initial position
     * @param y       The y-coordinate of the slime's initial position
     * @param sprites An array of sprites for the new slime
     * @param school  The initial school to which the new slime belongs
     * @return A new slime, located at the provided location and part of the
     * given school. The returned slime should not belong to a world.
     */
    @Override
    public Slime createSlime(int x, int y, Sprite[] sprites, School school) {
        return null;
    }

    /**
     * Add the given slime as a game object to the given world.
     *
     * @param world The world to which the slime should be added.
     * @param slime
     */
    @Override
    public void addSlime(World world, Slime slime) {

    }

    /**
     * Returns all the slimes currently located in the given world.
     *
     * @param world The world for which to retrieve all slimes.
     * @return All slimes that are located somewhere in the given world. There
     * are no restrictions on the type or order of the returned
     * collection, but each slime may only be returned once.
     */
    @Override
    public Collection<Slime> getSlimes(World world) {
        return null;
    }

    /**
     * Returns the current location of the given slime.
     *
     * @param slime The slime of which to find the location
     * @return An array, consisting of 2 integers {x, y}, that represents the
     * coordinates of the given slime's bottom left pixel in the world.
     */
    @Override
    public int[] getLocation(Slime slime) {
        return new int[0];
    }

    /**
     * Return the current sprite image for the given slime.
     *
     * @param slime The slime for which to get the current sprite image.
     * @return The current sprite image for the given slime, determined by its
     * orientation as defined in the assignment.
     */
    @Override
    public Sprite getCurrentSprite(Slime slime) {
        return null;
    }

    /**
     * Returns the current school to which the given slime belongs.
     *
     * @param slime The slime for which to retrieve the school.
     * @return The current school of the given slime.
     */
    @Override
    public School getSchool(Slime slime) {
        return null;
    }

    /**
     * Create an instance of Mazub.
     *
     * @param pixelLeftX
     *            The x-location of Mazub's bottom left pixel.
     * @param pixelBottomY
     *            The y-location of Mazub's bottom left pixel.
     * @param sprites
     *            The array of sprite images for Mazub.
     *
     * @return
     */
    Mazub createMazub(int pixelLeftX, int pixelBottomY, Sprite[] sprites);

    /**
     * Return the current location of the given alien.
     *
     * @param alien
     *            The alien of which to get the location.
     *
     * @return an array, consisting of 2 integers {x, y}, that represents the
     *         coordinates of the given alien's bottom left pixel in the world.
     */
    int[] getLocation(Mazub alien);

    /**
     * Return the current velocity (in m/s) of the given alien.
     *
     * @param alien
     *            The alien of which to get the velocity.
     *
     * @return an array, consisting of 2 doubles {vx, vy}, that represents the
     *         horizontal and vertical components of the given alien's current
     *         velocity, in units of m/s.
     */
    double[] getVelocity(Mazub alien);

    /**
     * Return the current acceleration (in m/s^2) of the given alien.
     *
     * @param alien
     *            The alien of which to get the acceleration.
     *
     * @return an array, consisting of 2 doubles {ax, ay}, that represents the
     *         horizontal and vertical components of the given alien's current
     *         acceleration, in units of m/s^2.
     */
    double[] getAcceleration(Mazub alien);

    /**
     * Return the current size of the given alien.
     *
     * @param alien
     *            The alien of which to get the size.
     *
     * @return An array, consisting of 2 integers {w, h}, that represents the
     *         current width and height of the given alien, in number of pixels.
     */
    int[] getSize(Mazub alien);

    /**
     * Return the current sprite image for the given alien.
     *
     * @param alien
     *            The alien for which to get the current sprite image.
     *
     * @return The current sprite image for the given alien, determined by its
     *         state as defined in the assignment.
     */
    Sprite getCurrentSprite(Mazub alien);

    /**
     * Make the given alien jump.
     *
     * @param alien
     *            The alien that has to start jumping.
     */
    void startJump(Mazub alien);

    /**
     * End the given alien's jump.
     *
     * @param alien
     *            The alien that has to stop jumping.
     */
    void endJump(Mazub alien);

    /**
     * Make the given alien move left.
     *
     * @param alien
     *            The alien that has to start moving left.
     */
    void startMoveLeft(Mazub alien);

    /**
     * End the given alien's left move.
     *
     * @param alien
     *            The alien that has to stop moving left.
     */
    void endMoveLeft(Mazub alien);

    /**
     * Make the given alien move right.
     *
     * @param alien
     *            The alien that has to start moving right.
     */
    void startMoveRight(Mazub alien);

    /**
     * End the given alien's right move.
     *
     * @param alien
     *            The alien that has to stop moving right.
     */
    void endMoveRight(Mazub alien);

    /**
     * Make the given alien duck.
     *
     * @param alien
     *            The alien that has to start ducking.
     */
    void startDuck(Mazub alien);

    /**
     * End the given alien's ducking.
     *
     * @param alien
     *            The alien that has to stop ducking.
     */
    void endDuck(Mazub alien);

    /**
     * Advance the state of the given alien by the given time period.
     *
     * @param alien
     *            The alien whose time has to be advanced.
     * @param dt
     *            The time interval (in seconds) by which to advance the given
     *            alien's time.
     */
    void advanceTime(Mazub alien, double dt);

}