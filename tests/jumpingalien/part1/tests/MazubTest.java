package jumpingalien.part1.tests;
	import jumpingalien.common.sprites.JumpingAlienSprites;
	import jumpingalien.model.Mazub;
	import jumpingalien.part1.facade.Facade;
	import jumpingalien.part1.facade.IFacade;
	import jumpingalien.util.Util;
	import org.junit.Test;

	import static jumpingalien.tests.util.TestUtils.doubleArray;
	import static org.junit.Assert.assertArrayEquals;
	import static org.junit.Assert.assertEquals;

	class Mazubtest {
		Mazub mazub = new Mazub(0, 0, JumpingAlienSprites.ALIEN_SPRITESET);
		IFacade facade = new Facade();

		@Test
		public void testConstructor() {
			Mazub mazub = new Mazub(0, 0, JumpingAlienSprites.ALIEN_SPRITESET);
			int temp[] = {0, 0};
			assertArrayEquals(temp, mazub.getLocation());
		}

		@Test
		public void testJump(){
			facade.startJump(mazub);
			assertEquals(8, mazub.getVelocity()[1], Util.DEFAULT_EPSILON);
			facade.advanceTime(mazub,0.1);
			// new y-velocity: -10 * 0.1 + 8 = 7
			// y_new [m] = 0 + 7 [m/s] * 0.1 [s] =
			// 0.7 [m] = 70 [cm], which falls into pixel (0, 70)
			assertEquals(70, mazub.getLocation()[1]);
		}

		//Test zowel de initiele beweging na 1 seconde als de maximumsnelheid na 20/9 sec
		@Test
		public void testMoveLeft(){
			Mazub mazub = new Mazub(500, 0, JumpingAlienSprites.ALIEN_SPRITESET);
			facade.startMoveLeft(mazub);
			facade.advanceTime(mazub, 0.1);
			// new x-velocity: -0.9 * 0.1 - 1 = -1.09

			// x_new [m] = 5 - 1.09 [m/s] * 0.1 [s] =
			// 4.891 [m] = 489.1 [cm], which falls into pixel (489, 0)
			assertEquals(489, mazub.getLocation()[0]);

			for (int i = 0; i < 100; i++) {
				facade.advanceTime(mazub, 0.2 / 9);
			}
			assertArrayEquals(doubleArray(-3, 0), facade.getVelocity(mazub), Util.DEFAULT_EPSILON);
		}

		//Test zowel de initiele beweging na 1 seconde als de maximumsnelheid na 20/9 sec
		@Test
		public void testMoveRight(){
			Mazub mazub = new Mazub(0, 0, JumpingAlienSprites.ALIEN_SPRITESET);
			facade.startMoveRight(mazub);
			facade.advanceTime(mazub, 0.1);
			// new x-velocity: 0.9 * 0.1 + 1 = 1.09

			// x_new [m] = 0 + 1.09 [m/s] * 0.1 [s] =
			// 0.109 [m] = 10.9 [cm], which falls into pixel (11, 0)
			assertEquals(11, mazub.getLocation()[0]);

			for (int i = 0; i < 100; i++) {
				facade.advanceTime(mazub, 0.2 / 9);
			}
			assertArrayEquals(doubleArray(3, 0), facade.getVelocity(mazub), Util.DEFAULT_EPSILON);
		}

		@Test
		public void testSprites(){
			Mazub mazub = new Mazub(0, 0, JumpingAlienSprites.ALIEN_SPRITESET);
			assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[0],mazub.getCurrentSprite());
			facade.startDuck(mazub);
			facade.advanceTime(mazub, 0.1);
			assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[1],mazub.getCurrentSprite());
			facade.endDuck(mazub);
			facade.startMoveRight(mazub);
			facade.advanceTime(mazub, 0.1);
			facade.endMoveRight(mazub);
			facade.advanceTime(mazub, 0.1);
			assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[2],mazub.getCurrentSprite());
			facade.startMoveLeft(mazub);
			facade.advanceTime(mazub, 0.1);
			facade.endMoveLeft(mazub);
			facade.advanceTime(mazub, 0.1);
			assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[3],mazub.getCurrentSprite());
			facade.startJump(mazub);
			facade.startMoveRight(mazub);
			facade.advanceTime(mazub,0.1);
			assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[4],mazub.getCurrentSprite());
			facade.endMoveRight(mazub);
			facade.startMoveLeft(mazub);
			facade.advanceTime(mazub,0.1);
			assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[5],mazub.getCurrentSprite());
			facade.endJump(mazub);
			facade.endMoveLeft(mazub);
			facade.startDuck(mazub);
			facade.startMoveRight(mazub);
			facade.advanceTime(mazub, 0.1);
			assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[6],mazub.getCurrentSprite());
			facade.endMoveRight(mazub);
			facade.startMoveLeft(mazub);
			facade.advanceTime(mazub, 0.1);
			assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[7],mazub.getCurrentSprite());
			facade.endMoveLeft(mazub);
			facade.endDuck(mazub);
			facade.startMoveRight(mazub);
			for(int i = 8; i < 19; i++){
				facade.advanceTime(mazub, 0.1);
				assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[i],mazub.getCurrentSprite());
			}
			facade.endMoveRight(mazub);
			facade.startMoveLeft(mazub);
			for(int i = 19; i < 30; i++){
				facade.advanceTime(mazub, 0.1);
				assertEquals(JumpingAlienSprites.ALIEN_SPRITESET[i],mazub.getCurrentSprite());
			}





		}





	}
