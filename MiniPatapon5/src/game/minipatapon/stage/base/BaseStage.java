package game.minipatapon.stage.base;

import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class BaseStage extends Stage {

	public BaseStage(float width, float height, boolean stretch) {
		super(width, height, stretch);
	}

	public abstract void hide();

	public abstract void pause();

	public abstract void resize(int width, int height);

	public abstract void resume();

	public abstract void show();
}

