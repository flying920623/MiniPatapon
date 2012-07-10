package game.minipatapon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public abstract class SimpleScreen implements Screen {
	public int getWidth() {
		return Gdx.graphics.getWidth();
	}

	public int getHeight() {
		return Gdx.graphics.getHeight();
	}
}
