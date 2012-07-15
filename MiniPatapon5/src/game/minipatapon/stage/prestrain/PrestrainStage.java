package game.minipatapon.stage.prestrain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import game.minipatapon.datasource.assets.Assets;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.actor.FlatImage;
import game.minipatapon.logger.DefaultLogger;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PrestrainStage extends Stage {

	public boolean isLoaded = false;

	protected String loadMethod;

	protected float loadPercent = 0f;

	FlatImage bar;
	FlatImage processBar;

	public PrestrainStage(float width, float height, boolean stretch,
			String loadMethod) {
		super(width, height, stretch);
		// TODO Auto-generated constructor stub

		this.loadMethod = loadMethod;

		init();
	}

	public void init() {
		initLoadImg();
		load();
	}

	public void initLoadImg() {

		TextureAtlas atlas = new TextureAtlas("data/images/"
				+ TextureAssets.LoadingBarImg.get(0));

		TextureRegion barRegion = atlas
				.findRegion(TextureAssets.LoadingProcessBarImg.get(1));
		TextureRegion processBarRegion = atlas
				.findRegion(TextureAssets.LoadingBarImg.get(1));

		bar = new FlatImage(barRegion, width / 2
				- processBarRegion.getRegionWidth() / 2 + 10, height / 2
				- processBarRegion.getRegionHeight() / 2 + 15, this);
		processBar = new FlatImage(processBarRegion, width / 2
				- processBarRegion.getRegionWidth() / 2, height / 2
				- processBarRegion.getRegionHeight() / 2, this);

		bar.width = processBar.width - 20;
		bar.originX = 0;
		bar.scaleX = 0;
	}

	public void load() {

		Class<?> manager = null;

		try {
			manager = Class
					.forName("game.minipatapon.dataprocess.resourcemanage.LoadManage");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Method load = manager.getMethod(loadMethod);
			load.invoke(manager.newInstance());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw() {

		if (isLoaded) {

		} else {
			loadPercent = Assets.inst().getProgress();
			bar.scaleX = loadPercent;
			if (loadPercent < 1) {
				Assets.inst().update();
				super.draw();

			} else {
				DefaultLogger.getDefaultLogger().logWithSignature(this,
						"%s finished!", loadMethod);
				isLoaded = true;
			}
		}

	}
}