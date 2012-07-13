package game.minipatapon.application;

/** 
 * @description	: Game Manager, Singleton mode
 * @author		: 黄攀
 * @created		: 2012-1-2
 */

import aurelienribon.tweenengine.Tween;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

import game.minipatapon.dataprocess.datafactory.MusicHandle;
import game.minipatapon.dataprocess.resourcemanage.LoadManage;
import game.minipatapon.dataprocess.resourcemanage.TextureManage;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.localization.Language;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.logger.Loggable;
import game.minipatapon.screen.LayeredScreen;
import game.minipatapon.screen.ProcessableScreen;

public class MiniPataponManager implements ApplicationListener,
		ScreenManageable {

	public int initWidth = 0;
	public int initHeight = 0;

	boolean init = false;

	// The only instance
	private static MiniPataponManager instance = null;

	private LayeredScreen screen = null;

	public LayeredScreen GetLayeredScreen()
	{
		return this.screen;
	}
	
	public static MiniPataponManager getInstance() {

		if (instance == null)
			instance = new MiniPataponManager();
		return instance;
	}

	Loggable logger;

	// Private constructor
	private MiniPataponManager() {
		// Here for local test!
		logger = DefaultLogger.getDefaultLogger();
		logger.logWithSignature(this, "语言测试:%1$s",
				Language.translate("MiniPatapon"));
	}

	@Override
	public void create() {
		logger.logWithSignature(this, "create");
		// MusicManager.setBackgroundMusic("background.ogg");
		// MusicManager.play(true);
		this.navigate(new LayeredScreen());
	}

	@Override
	public void dispose() {
		logger.logWithSignature(this, "dispose");
		
		if (screen != null)
			this.screen.dispose();
		
		LoadManage.dispose();
		
		
	}

	@Override
	public void pause() {
		logger.logWithSignature(this, "pause");

		if (screen != null)
			this.screen.pause();
	}

	@Override
	public void render() {

		if (screen != null) {
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			float dt = Gdx.graphics.getDeltaTime();
			this.screen.render(dt);
		}
	}

	@Override
	public void resize(int width, int height) {


		
		logger.logWithSignature(this, "resize(%1$d,%2$d)", width, height);
		if (screen != null)
			this.screen.resize(width, height);
	}

	@Override
	public void resume() {
		logger.logWithSignature(this, "resume");
		if (screen != null)
			this.screen.resume();
	}

	@Override
	public void navigate(LayeredScreen screen) {
		logger.logWithSignature(this, "navigate(%1$s)", screen.getClass()
				.getSimpleName());
		this.screen = screen;
		Gdx.input.setInputProcessor(screen);
		if (screen != null)
			screen.show();
	}

}
