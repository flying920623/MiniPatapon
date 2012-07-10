package game.minipatapon.stage.midground;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.effectpresent.spriter.SpriterObject;
import game.minipatapon.effectpresent.spriter.action.MoveAction;
import game.minipatapon.effectpresent.spriter.action.SpriterObjectAccessor;
import game.minipatapon.effectpresent.spriter.util.SpriterDrawer;
import game.minipatapon.effectpresent.spriter.util.SpriterImporter;
import game.minipatapon.effectpresent.spriter.util.TexturePackProvider;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.stage.base.BaseStage;

public class TestSpriterImport extends BaseStage implements ActorLoader{

//	、、private ContentScreen contentScreen;
	private SpriterObject spriterObjectHero;
	private float timeElapsed = 0;
	
	private final Map<String, Texture> textures = new HashMap<String, Texture>();
	
	TexturePackProvider provier = new TexturePackProvider();
	
	public TestSpriterImport(float width, float height,
			boolean stretch) {
		super(width, height, stretch);
		// TODO Auto-generated constructor stub

//		loadContent(screen);
		init();
	}

//	@Override
//	public void loadContent(ContentScreen screen) {
//		// TODO Auto-generated method stub
//		this.contentScreen = screen;
//
//	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		Tween.registerAccessor(SpriterObject.class, new SpriterObjectAccessor());
		
		try {
			spriterObjectHero = SpriterImporter.importFile(
					"hero", Gdx.files.internal( "data/images/AnimationActor/axeSCML"), "animation_000", provier);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

//		spriterObjectHero.x = 100;
//		spriterObjectHero.y = 100;
		spriterObjectHero.scaleX = 0.4f;
		spriterObjectHero.scaleY = 0.4f;
		//spriterObjectHero.rotation=30;
		
	//	spriterObjectHero.action(MoveAction.simpleMove(spriterObjectHero).delay(2));
		//SpriterDrawer.setDrawerProvider( new RegionDrawerProvider() );
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	
	
	/** Disposes the stage */
	public void dispose () {
		
		spriterObjectHero.disposeAllRegions();
		
		batch.dispose();
		
	}
	
	public void draw() {
		this.timeElapsed += Gdx.graphics.getDeltaTime();
		
		camera.update();
	
		
//		BaseSpriterDrawer.draw(0.2f, 0.2f, camera, batch, spriterObjectHero, "walk", timeElapsed * 100, 0, 0, true,
//		        true);
//		
//		BaseSpriterDrawer.draw(0.3f, 0.3f, camera, batch, spriterObjectHero, "walk", timeElapsed * 100, 0, 0, true,
//		        true);
//		
//		BaseSpriterDrawer.draw(0.5f, 0.5f, camera, batch, spriterObjectHero, "walk", timeElapsed * 100, 0, 0, true,
//		        true);
		
//		ScaleSpriterDrawer.draw(0.5f, 0.5f, this, batch, spriterObjectHero, "animation_000", timeElapsed * 80,
//		        0, 0, true, true);
		
//		ScaleSpriterDrawer.draw(0.5f, 0.5f, this, batch, spriterObjectHero, "walk", timeElapsed * 100,
//		        0, 0, true, true);
		
		
//		
//		ScaleSpriterDrawer.draw(0.5f, 0.5f, this, batch, spriterObjectHero, "walk", timeElapsed * 100,
//		        20, 0, true, true);
		
		
		

//		batch.setProjectionMatrix( secondCamera.combined);
//		
//	
//		batch.begin();
//	
//	    SpriterDrawer.draw(batch, spriterObjectHero, "walk", timeElapsed * 100, 300, 200, true,
//	        true);
//	    SpriterDrawer.draw(batch, spriterObjectHero, "walk", timeElapsed * 100,
//	        150 + (timeElapsed * 120 % 250), 50, true, true);
//
//		batch.end();
//		
//		batch.setProjectionMatrix( camera.combined);
		
		
		
		batch.begin();
		
		spriterObjectHero.draw(batch,1);
		
//		SpriterDrawer.draw(batch, spriterObjectHero, "animation_000", timeElapsed * 80,
//		        300, 0, true, true);
		
//		SpriterDrawer.draw(batch, spriterObjectHero, "idle_healthy", timeElapsed * 100, 0, 0,
//		        true, true);
//		SpriterDrawer.draw(batch, spriterObjectHero, "walk", timeElapsed * 100,
//		        150 + (timeElapsed * 120 % 250), 50, true, true);
		root.draw(batch, 1);
		
		batch.end();
	}
	


}
