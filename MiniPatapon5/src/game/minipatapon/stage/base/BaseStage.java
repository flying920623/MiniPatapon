package game.minipatapon.stage.base;

import game.minipatapon.logger.DefaultLogger;

import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class BaseStage extends Stage {

	public BaseStage(float width, float height, boolean stretch) {
		super(width, height, stretch);
	}
	
	public void dispose () {
		root.clear();
		batch.dispose();
		DefaultLogger.getDefaultLogger().logWithSignature(this, "dispose stage: %s", this.getClass().getName());
	}

	public abstract void hide();

	public abstract void pause();

	public abstract void resize(int width, int height);

	public abstract void resume();

	public abstract void show();
}

