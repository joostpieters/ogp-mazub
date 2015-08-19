package jumpingalien.part2.tests;

import jumpingalien.common.sprites.JumpingAlienSprites;
import jumpingalien.model.Mazub;
import jumpingalien.model.World;
import jumpingalien.part2.facade.IFacadePart2;
import jumpingalien.util.Util;
import org.junit.Test;

import static jumpingalien.tests.util.TestUtils.doubleArray;
import static jumpingalien.tests.util.TestUtils.spriteArrayForSize;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

class MazubtestPart2 {
	public static final int FEATURE_AIR = 0;
	public static final int FEATURE_SOLID = 1;
	public static final int FEATURE_WATER = 2;
	public static final int FEATURE_MAGMA = 3;

	@Test
	public void testConstructor() {
		IFacadePart2 facade = new jumpingalien.part2.facade.Facade();

		World world = facade.createWorld(5, 4, 3, 1, 1, 1, 1);
		Mazub mazub = new Mazub(0, 0, JumpingAlienSprites.ALIEN_SPRITESET);
		int temp[] = {0, 0};
		assertArrayEquals(temp, mazub.getLocation());
	}

	@Test
	public void testJump(){
		IFacadePart2 facade = new jumpingalien.part2.facade.Facade();
		World world = facade.createWorld(500, 1, 2, 1, 1, 1, 1);
		facade.setGeologicalFeature(world, 0, 0, FEATURE_SOLID);
		Mazub mazub = facade.createMazub(0, 499, spriteArrayForSize(3, 3));
		facade.setMazub(world, mazub);

		facade.startJump(mazub);
		assertEquals(8, mazub.getVelocity()[1], Util.DEFAULT_EPSILON);
		facade.advanceTime(world,0.1);
		// new y-velocity: -10 * 0.1 + 8 = 7
		// y_new [m] = 0 + 7 [m/s] * 0.1 [s] =
		// 0.7 [m] = 70 [cm], which falls into pixel (0, 70)
		assertEquals(569, mazub.getLocation()[1]);
	}

	//Test zowel de initiele beweging na 1 seconde als de maximumsnelheid na 20/9 sec
	@Test
	public void testMoveLeft(){
		IFacadePart2 facade = new jumpingalien.part2.facade.Facade();
		World world = facade.createWorld(500, 1, 2, 1, 1, 1, 1);
		facade.setGeologicalFeature(world, 0, 0, FEATURE_SOLID);
		Mazub mazub = facade.createMazub(100, 499, spriteArrayForSize(3, 3));
		facade.setMazub(world, mazub);

		facade.startMoveLeft(mazub);
		facade.advanceTime(world, 0.1);
		// new x-velocity: -0.9 * 0.1 - 1 = -1.09

		// x_new [m] = 5 - 1.09 [m/s] * 0.1 [s] =
		// .891 [m] = 89.1 [cm], which falls into pixel (89, 0)
		assertEquals(89, mazub.getLocation()[0]);

		for (int i = 0; i < 100; i++) {
			facade.advanceTime(world, 0.2 / 9);
		}
		assertArrayEquals(doubleArray(-3, 0), facade.getVelocity(mazub), Util.DEFAULT_EPSILON);
	}

	//Test zowel de initiele beweging na 1 seconde als de maximumsnelheid na 20/9 sec
	@Test
	public void testMoveRight(){
		IFacadePart2 facade = new jumpingalien.part2.facade.Facade();
		World world = facade.createWorld(500, 1, 2, 1, 1, 1, 1);
		facade.setGeologicalFeature(world, 0, 0, FEATURE_SOLID);
		Mazub mazub = facade.createMazub(0, 499, spriteArrayForSize(3, 3));
		facade.setMazub(world, mazub);

		facade.startMoveRight(mazub);
		facade.advanceTime(world, 0.1);
		// new x-velocity: 0.9 * 0.1 + 1 = 1.09

		// x_new [m] = 0 + 1.09 [m/s] * 0.1 [s] =
		// 0.109 [m] = 10.9 [cm], which falls into pixel (10, 0)
		assertEquals(10, mazub.getLocation()[0]);

		for (int i = 0; i < 100; i++) {
			facade.advanceTime(world, 0.2 / 9);
		}
		assertArrayEquals(doubleArray(3, 0), facade.getVelocity(mazub), Util.DEFAULT_EPSILON);
	}

	@Test
	public void testSprites(){
		IFacadePart2 facade = new jumpingalien.part2.facade.Facade();
		World world = facade.createWorld(500, 1, 2, 1, 1, 1, 1);
		facade.setGeologicalFeature(world, 0, 0, FEATURE_SOLID);
		Mazub mazub = new Mazub(0, 0, JumpingAlienSprites.ALIEN_SPRITESET);
		facade.setMazub(world, mazub);



		assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[0],mazub.getCurrentSprite());
		facade.startDuck(mazub);
		facade.advanceTime(world, 0.1);
		assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[1],mazub.getCurrentSprite());
		facade.endDuck(mazub);
		facade.startMoveRight(mazub);
		facade.advanceTime(world, 0.1);
		facade.endMoveRight(mazub);
		facade.advanceTime(world, 0.1);
		assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[2],mazub.getCurrentSprite());
		facade.startMoveLeft(mazub);
		facade.advanceTime(world, 0.1);
		facade.endMoveLeft(mazub);
		facade.advanceTime(world, 0.1);
		assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[3],mazub.getCurrentSprite());
		facade.startJump(mazub);
		facade.startMoveRight(mazub);
		facade.advanceTime(world,0.1);
		assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[4],mazub.getCurrentSprite());
		facade.endMoveRight(mazub);
		facade.startMoveLeft(mazub);
		facade.advanceTime(world,0.1);
		assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[5],mazub.getCurrentSprite());
		facade.endJump(mazub);
		facade.endMoveLeft(mazub);
		facade.startDuck(mazub);
		facade.startMoveRight(mazub);
		facade.advanceTime(world, 0.1);
		assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[6],mazub.getCurrentSprite());
		facade.endMoveRight(mazub);
		facade.startMoveLeft(mazub);
		facade.advanceTime(world, 0.1);
		assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[7],mazub.getCurrentSprite());
		facade.endMoveLeft(mazub);
		facade.endDuck(mazub);
		facade.startMoveRight(mazub);
		for(int i = 8; i < 18; i++){
			facade.advanceTime(world, 0.1);
			assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[i+1],mazub.getCurrentSprite());
		}
		facade.endMoveRight(mazub);
		facade.startMoveLeft(mazub);
		for(int i = 19; i < 29; i++){
			facade.advanceTime(world, 0.1);
			assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[i+1],mazub.getCurrentSprite());
		}





	}





}