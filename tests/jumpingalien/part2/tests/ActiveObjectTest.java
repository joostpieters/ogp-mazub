package jumpingalien.part2.tests;

import jumpingalien.common.sprites.JumpingAlienSprites;
import jumpingalien.model.Shark;
import jumpingalien.model.World;
import jumpingalien.part2.facade.IFacadePart2;
import org.junit.Test;

public class ActiveObjectTest {
	public static final int FEATURE_AIR = 0;
	public static final int FEATURE_SOLID = 1;
	public static final int FEATURE_WATER = 2;
	public static final int FEATURE_MAGMA = 3;

	@Test
	public void testAddObject() {
		IFacadePart2 facade = new jumpingalien.part2.facade.Facade();
		World world = facade.createWorld(500, 1, 2, 1, 1, 1, 1);
		facade.setGeologicalFeature(world, 0, 0, FEATURE_SOLID);

		Shark shark = facade.createShark(50,50, JumpingAlienSprites.ALIEN_SPRITESET);
		facade.addShark(world,shark);

	}
}
