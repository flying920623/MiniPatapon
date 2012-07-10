package game.minipatapon.effectpresent.background;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class PLParallaxBackground {

	private PLParallaxLayer[] layers;
	private Camera camera;
	private SpriteBatch batch;
	private Vector2 speed = new Vector2();

	/**
	 * @param layers
	 *            The background layers
	 * @param width
	 *            The screenWith
	 * @param height
	 *            The screenHeight
	 * @param speed
	 *            A Vector2 attribute to point out the x and y speed
	 */
	public PLParallaxBackground(PLParallaxLayer[] layers, float width,
			float height, Vector2 speed) {
		this.layers = layers;
		this.speed.set(speed);
		camera = new OrthographicCamera(width, height);
		batch = new SpriteBatch();
	}

	public void render(float delta) {
		this.camera.position.add(speed.x * delta, speed.y * delta, 0);
		for (PLParallaxLayer layer : layers) {
			batch.setProjectionMatrix(camera.projection);
			batch.begin();
			float currentX = -camera.position.x * layer.parallaxRatio.x
					% (layer.region.getRegionWidth() + layer.padding.x);

			if (speed.x < 0)
				currentX += -(layer.region.getRegionWidth() + layer.padding.x);
			do {
				float currentY = -camera.position.y * layer.parallaxRatio.y
						% (layer.region.getRegionHeight() + layer.padding.y);
				if (speed.y < 0)
					currentY += -(layer.region.getRegionHeight() + layer.padding.y);
				do {
//					batch.draw(layer.region, -this.camera.viewportWidth / 2
//							+ currentX + layer.startPosition.x,
//							-this.camera.viewportHeight / 2 + currentY
//									+ layer.startPosition.y);
					batch.draw(layer.region, -this.camera.viewportWidth / 2
							+ currentX + layer.startPosition.x,
							-this.camera.viewportHeight / 2 + currentY
									+ layer.startPosition.y, layer.region.getRegionWidth()/2, layer.region.getRegionY()/2, 
									layer.region.getRegionWidth()*layer.scale.x, layer.region.getRegionHeight()*layer.scale.y,
									1f, 1f, 0f);
					currentY += (layer.region.getRegionHeight() + layer.padding.y);
				} while (currentY < camera.viewportHeight);
				currentX += (layer.region.getRegionWidth() + layer.padding.x);
			} while (currentX < camera.viewportWidth);
			batch.end();
		}
	}
}