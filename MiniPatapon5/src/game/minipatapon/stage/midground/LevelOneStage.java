package game.minipatapon.stage.midground;

import java.io.IOException;
import java.util.Collections;

import aurelienribon.tweenengine.Tween;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.tiled.TiledObject;
import com.badlogic.gdx.graphics.g2d.tiled.TiledObjectGroup;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.List;

import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.effectpresent.actor.FlatImage;
import game.minipatapon.effectpresent.actor.Image;
import game.minipatapon.effectpresent.actor.InputImage;
import game.minipatapon.effectpresent.dialog.Dialog;
import game.minipatapon.effectpresent.dialog.NoteDialog;
import game.minipatapon.effectpresent.dialog.SlideDialog;
import game.minipatapon.effectpresent.spriter.SpriterObject;
import game.minipatapon.effectpresent.spriter.SpriterObjectIniArg;

import game.minipatapon.effectpresent.spriter.action.MoveAction;

import game.minipatapon.effectpresent.spriter.action.SpriterObjectAccessor;
import game.minipatapon.effectpresent.spriter.util.SpriterGroup;
import game.minipatapon.effectpresent.spriter.util.SpriterImporter;
import game.minipatapon.effectpresent.spriter.util.TexturePackProvider;
import game.minipatapon.event.music.MatchMusicType;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.screen.ContentScreen;
import game.minipatapon.stage.base.BaseStage;

public class LevelOneStage extends GameStage implements ActorLoader {

	private Image backImage = new Image("backgroud",
			ResourceLoader.getTexture(TextureAssets.BackgroundImg));

	SpriterObject axeObject;
	SpriterObject birdObject;
	SpriterObject horseObject;
	SpriterObject walkingObject;

	Image image ;
	
	Dialog dialog;
//	private InputImage pataBtn = new InputImage(ResourceLoader.getTexturetureRegion
//			(TextureAssets.PataBtnImg), width/2+50, height/2, this, MatchMusicType.Pata);
//    private InputImage ponBtn = new InputImage(ResourceLoader.getTexturetureRegion
//	(TextureAssets.PonBtnImg), width/2-50, height/2, this, MatchMusicType.Pon);
//    private InputImage chakaBtn = new InputImage(ResourceLoader.getTexturetureRegion
//	(TextureAssets.ChakaBtnImg), width/2, height/2+30, this, MatchMusicType.Chaka);

	public LevelOneStage(float width, float height, boolean stretch) {
		super(width, height, stretch);
		// TODO Auto-generated constructor stub

		DefaultLogger.getDefaultLogger()
				.logWithSignature(this, "%s", "sdfasdf");
		init();
	}

	public LevelOneStage(float width, float height, boolean stretch, int level) {
		super(width, height, stretch, level);
		// TODO Auto-generated constructor stub

		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

		DefaultLogger.getDefaultLogger().logWithSignature(this,
				"enter LevelOneStage.load()");

		backImage.width = width;
		backImage.height = height;
		this.addActor(backImage);

		Tween.registerAccessor(Actor.class, new ActorAccessor());

		initMap();

//		dialog = new SlideDialog("info",
//				"Let's GO!  PATA PATA PATA PON will make us March!", axeObject,
//				this);
//		dialog.show(6);//******时间作为参数
		
		dialog = new NoteDialog("info", "PATA ", 10, 100,
				this);

		dialog.show(1);
		
		this.addJustice(walkingObject);
		this.addEnemy(axeObject);
		
		 
		 
		 
		 
		axeObject.attack = true;


		try {
			GameStage.writeObjectToGson("axe",
					"axeSCML", "animation_000", 0, 0, 1, 1,
					this, SpriterObject.throwAttack);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		image = new FlatImage(ResourceLoader.getRegionFromPacker(TextureAssets.PonImg), 200, 200, this);
		this.addActor(image);
//		this.addActor(chakaBtn);
//		this.addActor(pataBtn);
//		this.addActor(ponBtn);
		
	}

	private void initMap() {

		
		for (TiledObjectGroup group : map.objectGroups) {
			for (TiledObject object : group.objects) {
				if ("standard_bearer".equals(object.name)) {

					
					axeObject = SpriterObject.initSpriterObject("axe",
							"axeSCML", "animation_000", object.x, 0, 1, 1,
							this,SpriterObject.moveAttack);

					this.setLockSpriter(axeObject);

					axeObject.repeatMove("", Gdx.graphics.getWidth()/10);
							

				}

				if ("axe".equals(object.name)) {
					birdObject = SpriterObject.initSpriterObject("axe2",
							"axeSCML", "animation_000", object.x, 0, 1f, 1f,
							this, SpriterObject.moveAttack);

					
				}

				if ("sword".equals(object.name)) {
					horseObject = SpriterObject.initSpriterObject("horse",
							"horseSCML", "move", object.x, 0, 1, 1, this,
							SpriterObject.moveAttack);

					// horseObject.setCurrentState(MoveAction.repeatMove(horseObject),
					// "attack");

				}
				if ("end_mark_tower".equals(object.name)) {
					walkingObject = SpriterObject.initSpriterObject("walking",
							"walkingSCML", "attack", object.x, 0, 1, 1, this,
							SpriterObject.moveAttack);
					
					walkingObject.repeatMove("", Gdx.graphics.getWidth()/10);
					
				}
			}
		}

	}

	public void initaAxe() {
		// birdObject = initSpriterObject( "axeSCML", "animation_000", 0, 0, 1,
		// 1, null);

	}

	public void initBird() {
		// birdObject = initSpriterObject( "bSCML", "animation_000", 50, 0, 1,
		// 1, null);
		// this.setLockSpriter(birdObject);
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

	public void draw() {
		// if( findActor("axe").x>400 )
		// dialog.show();
		// axeObject.checkAttackEnemy(null);

		super.draw();
		// this.act(delta)
		// this.getActors().
		// DefaultLogger.getDefaultLogger().log("%f", axeObject.spritex+1);
		// DefaultLogger.getDefaultLogger().log("%f", birdObject.spritex+2);

		// DefaultLogger.getDefaultLogger().log("%f", horseObject.spritex);
		// DefaultLogger.getDefaultLogger().log("%s",
		// walkingObject.getWeaponRec().toString());
	}

}
