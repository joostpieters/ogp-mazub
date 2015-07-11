package jumpingalien.part2.internal;

import java.awt.Graphics2D;

import jumpingalien.common.gui.painters.AbstractAlienPainter;
import jumpingalien.common.sprites.ImageSprite;

public final class HealthPainter extends AbstractAlienPainter<Part2GameScreen> {

	private static final int H_MARGIN = 30;
	private static final int WIDTH = 30;
	private static final int V_MARGIN = 30;

	public HealthPainter(Part2GameScreen screen) {
		super(screen);
	}

	@Override
	protected JumpingAlienGamePart2 getGame() {
		return (JumpingAlienGamePart2) super.getGame();
	}

	@Override
	public void paintScreenPost(Graphics2D g) {
		getGame().getAlienInfoProvider().getAlienHealth()
				.ifPresent(health -> paintHealth(g, health));
	}

	private void paintHealth(Graphics2D g, Integer health) {
		int count = 0;
		int origHealth = health;
		if (origHealth > 0) {
			while (health > 0) {
				count += 1;
				int digit = health % 10;
				health = health / 10;
				ImageSprite image = Resources.NUMBER_SPRITES[digit];
				g.drawImage(image.getImage(), getScreenWidth() - H_MARGIN
						- count * WIDTH, V_MARGIN, null);
			}
		} else {
			count += 1;
			ImageSprite image = Resources.NUMBER_SPRITES[0];
			g.drawImage(image.getImage(), getScreenWidth() - H_MARGIN - count
					* WIDTH, V_MARGIN, null);
		}
		
		if (origHealth >= 66) {
			g.drawImage(Resources.HEALTH_FULL.getImage(), getScreenWidth()
					- H_MARGIN - count * WIDTH
					- Resources.HEALTH_FULL.getImage().getWidth(), V_MARGIN,
					null);
		} else if (origHealth >= 33) {
			g.drawImage(Resources.HEALTH_HALF.getImage(), getScreenWidth()
					- H_MARGIN - count * WIDTH
					- Resources.HEALTH_HALF.getImage().getWidth(), V_MARGIN,
					null);
		} else {
			g.drawImage(Resources.HEALTH_EMPTY.getImage(), getScreenWidth()
					- H_MARGIN - count * WIDTH
					- Resources.HEALTH_EMPTY.getImage().getWidth(), V_MARGIN,
					null);
		}
	};
}
