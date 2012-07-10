package game.minipatapon.stage.midground;

import game.minipatapon.datasource.assets.MusicAssets;
import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.actor.FlatImage;
import game.minipatapon.effectpresent.actor.HighlightItemChangeListener;
import game.minipatapon.effectpresent.actor.Image;
import game.minipatapon.effectpresent.actor.NavigateImage;
import game.minipatapon.effectpresent.actor.RotateGroup;
import game.minipatapon.effectpresent.animation.AnimateImage;
import game.minipatapon.effectpresent.animation.HeroAnimateImage;
import game.minipatapon.effectpresent.audioplayer.MusicManage;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.screen.ContentScreen;
import game.minipatapon.stage.base.BaseStage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ChooseHeroStage extends BaseStage implements ActorLoader{
	@SuppressWarnings("unused")
	private ContentScreen contentScreen;
	
	private Image blackImage;
	
	Music music = ResourceLoader.loadMusic(MusicAssets.chooseHeroMusicStr);
	public ChooseHeroStage(float width, float height, boolean stretch) {
		super(width, height, stretch);
		// TODO Auto-generated constructor stub
		MusicManage.setLoopingMusic(music, true);
		MusicManage.playMusic(music);
//		this.loadContent(screen);
		this.init();
	}

//	@Override
//	public void loadContent(ContentScreen screen) {
//		// TODO Auto-generated method stub
//		
//		this.contentScreen = screen;
//		
//	}


	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unused")
		float width = this.width;
		float height = this.height;
		
		blackImage = new Image("black", ResourceLoader.loadTextureRegionFromPacker(TextureAssets.BlackBgImg).get(0));
		blackImage.x=0;
		blackImage.y=0;
		blackImage.width =Gdx.graphics.getWidth();
		blackImage.height =Gdx.graphics.getHeight();
		this.addActor(blackImage);
		
//		NavigateImage level1Image = new NavigateImage("level1", ResourceLoader.loadTextureRegionFromPacker(TextureAssets.PataButton).get(0), 0f, height/2 - 100/2,this, ChooseLevelStage.class);
//
//		
//	//	TextureRegion level2 = ResourceLoader.loadTexture("hero/hero2/lowlight_up.png");
//		NavigateImage level2Image = new NavigateImage("level2", ResourceLoader.loadTextureRegionFromPacker(TextureAssets.PonButton).get(0), 100f, height/2 - 100/2, this,ChooseLevelStage.class);
//		
//		//TextureRegion level3 = ResourceLoader.loadTexture("hero/hero3/lowlight_up.png");
//		NavigateImage level3Image = new NavigateImage("level3", ResourceLoader.loadTextureRegionFromPacker(TextureAssets.CakaButton).get(0), 200f, height/2 - 100/2,this, ChooseLevelStage.class);
//		
 //       AnimateImage animateImage = new AnimateImage(ResourceLoader.loadTextureRegionFromPacker(TextureAssets.HeroPoint), width/2, height/2, this, 3f);
		HeroAnimateImage hero1 = new HeroAnimateImage(ResourceLoader.loadTextureRegionFromPacker(TextureAssets.HeroPoint), 
				ResourceLoader.loadTextureRegionFromPacker(TextureAssets.Hero1),
				ResourceLoader.loadTextureRegionFromPacker(TextureAssets.HeroCircle1),0f, height/2 - 100/2, this, 3f,ChooseLevelStage.class);
		HeroAnimateImage hero2 = new HeroAnimateImage(ResourceLoader.loadTextureRegionFromPacker(TextureAssets.HeroPoint), 
				ResourceLoader.loadTextureRegionFromPacker(TextureAssets.Hero2),
				ResourceLoader.loadTextureRegionFromPacker(TextureAssets.HeroCircle2),100f, height/2 - 100/2, this, 3f,ChooseLevelStage.class);
		HeroAnimateImage hero3 = new HeroAnimateImage(ResourceLoader.loadTextureRegionFromPacker(TextureAssets.HeroPoint), 
				ResourceLoader.loadTextureRegionFromPacker(TextureAssets.Hero3),
				ResourceLoader.loadTextureRegionFromPacker(TextureAssets.HeroCircle3),200f, height/2 - 100/2, this, 3f,ChooseLevelStage.class);
		
		RotateGroup group = new RotateGroup("",this, hero1, hero2, hero3);

		//this.addActor(animateImage);
		this.addActor( group );
		this.root.keyboardFocus(group);
		
		group.setCurrentItemChangeListener( new HighlightItemChangeListener(){

			@Override
			public void onItemChange(Actor actor) {
				// TODO Auto-generated method stub
				DefaultLogger.getDefaultLogger().logWithSignature(this, "curent level name:%s", actor.name );
			}
			
		});
		
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		MusicManage.pauseMusic(music);
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

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		MusicManage.stopMusic(music);
		super.dispose();
	}
	
	
}
