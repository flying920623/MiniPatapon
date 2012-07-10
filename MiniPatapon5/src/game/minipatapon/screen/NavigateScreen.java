/** 
 * @description	: the base screen to implements some common operations
 * @author		: 黄攀
 * @created		: 2012-1-4
 */

package game.minipatapon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;

import game.minipatapon.event.EventArg;
import game.minipatapon.event.gamecmd.GameState;
import game.minipatapon.event.gamecmd.GameStateArg;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.logger.Loggable;
import game.minipatapon.stage.base.BaseStage;

public class NavigateScreen extends SimpleScreen implements ProcessableScreen,
		Layerable {

	private int layer;

	public NavigateScreen() {
		this.initialize(ScreenLayer.CONTENT);

	}

	public NavigateScreen(int layer) {
		initialize(layer);
	}

	private void initialize(int layer) {
		logger = DefaultLogger.getDefaultLogger();
		// camera = new OrthographicCamera(getWidth(), getHeight());
		camera = new OrthographicCamera(getWidth(), getHeight());

		camera.position.set(getWidth() / 2, getHeight() / 2, 0);
		this.layer = ScreenLayer.CONTENT;
	}

	public int getWidth() {
		return Gdx.graphics.getWidth();
	}

	public int getHeight() {
		return Gdx.graphics.getHeight();
	}

	@Override
	public void pause() {
		if (this.stage != null)
			stage.pause();
	}

	@Override
	public void resume() {
		if (this.stage != null)
			stage.resume();
	}

	public BaseStage stage;
	protected Loggable logger;

	protected Camera camera;

	public void navigate(BaseStage _stage) {
		logger.logWithSignature(this, "Navigate(%1$s)", _stage.getClass()
				.getSimpleName());
		if (this.stage != null) // for Test
		{
			this.stage.dispose();
			logger.logWithSignature(this, "dispose", _stage.getClass()
					.getSimpleName());
		}
		this.stage = _stage;
		this.stage.setCamera(camera);
		this.setProcessor(this.stage);
		this.stage.show();
	}

	@Override
	public void hide() {
		if (stage != null)
			this.stage.hide();
	}

	@Override
	public void show() {
		if (stage != null)
			stage.show();
	}

	@Override
	public void dispose() {
		if (stage != null)
		{
			stage.dispose();
			GameStateArg arg =new GameStateArg(GameState.GameEnd);
			arg.EventArgSent();
		}
		
		
	}

	@Override
	public void render(float dt) {
		if (stage != null) {
			stage.act(dt);
			stage.draw();
		}
	}

	@Override
	public void resize(int width, int height) {
		if (this.stage != null)
			this.stage.resize(width, height);
	}

	private InputProcessor processor;

	@Override
	public boolean keyDown(int keyCode) {
		if (getProcessor() != null)
			return getProcessor().keyDown(keyCode);
		else
			return false;
	}

	@Override
	public boolean keyTyped(char keyCode) {
		if (getProcessor() != null)
			return getProcessor().keyTyped(keyCode);
		else
			return false;
	}

	@Override
	public boolean keyUp(int keyCode) {
		if (getProcessor() != null)
			return getProcessor().keyUp(keyCode);
		else
			return false;
	}

	@Override
	public boolean scrolled(int amount) {
		if (getProcessor() != null)
			return getProcessor().scrolled(amount);
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		if (getProcessor() != null)
			return getProcessor().touchDown(x, y, pointer, button);
		else
			return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		if (getProcessor() != null)
			return getProcessor().touchDragged(arg0, arg1, arg2);
		else
			return false;
	}

	@Override
	public boolean touchMoved(int x, int y) {

		if (getProcessor() != null)
			return getProcessor().touchMoved(x, y);
		else
			return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {

		if (getProcessor() != null)
			return getProcessor().touchUp(x, y, pointer, button);
		return false;
	}

	public InputProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(InputProcessor processor) {
		this.processor = processor;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}
}
