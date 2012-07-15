package game.minipatapon.stage.midground;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Back;
import aurelienribon.tweenengine.equations.Cubic;
import aurelienribon.tweenengine.equations.Quad;
import aurelienribon.tweenengine.equations.Quart;
import aurelienribon.tweenengine.equations.Quint;

import game.minipatapon.dataprocess.resourcemanage.LoadManage;
import game.minipatapon.datasource.assets.MusicAssets;
import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.effectpresent.actor.FlatImage;
import game.minipatapon.effectpresent.audioplayer.MusicManage;
import game.minipatapon.event.gamecmd.NavLayeredScreenStageArg;

import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.screen.ContentScreen;
import game.minipatapon.stage.base.BaseStage;

public class StartAnimationStage extends BaseStage implements ActorLoader {
	
	private boolean finished = false;
	
	private final FlatImage miniImg = new FlatImage("miniImg",
			ResourceLoader.getRegionFromPacker(TextureAssets.MiniImg));
	private final FlatImage pataImg = new FlatImage("pataImg",
			ResourceLoader.getRegionFromPacker(TextureAssets.PataImg));
	private final FlatImage ponImg = new FlatImage("ponImg",
			ResourceLoader.getRegionFromPacker(TextureAssets.PonImg));
	private final FlatImage stripImg = new FlatImage("stripImg",
			ResourceLoader.getRegionFromPacker(TextureAssets.StripImg));
	private final FlatImage logo2Img = new FlatImage("logo2Img",
			ResourceLoader.getRegionFromPacker(TextureAssets.Logo2Img));
	private final FlatImage poweredImg = new FlatImage("poweredImg",
			ResourceLoader.getRegionFromPacker(TextureAssets.PoweredImg));
	private final FlatImage nuclearLogoImg = new FlatImage("gdxImg",
			ResourceLoader.getRegionFromPacker(TextureAssets.NuclearLogoImg));
	private final FlatImage veilImg = new FlatImage("veilImg",
			ResourceLoader.getRegionFromPacker(TextureAssets.VeilImg));
	private final FlatImage logoImg = new FlatImage("logoImg",
			ResourceLoader.getRegionFromPacker(TextureAssets.LogoImg));
	private final FlatImage blackBgImg = new FlatImage("blackBgImg",
			ResourceLoader.getRegionFromPacker(TextureAssets.BlackBgImg));
	
	private final TweenManager tweenManager = new TweenManager();

	//Music music = ResourceLoader.getMusic(MusicAssets.startMusicStr);
	
	public StartAnimationStage(float width, float height,
			boolean stretch) {
		super(width, height, stretch);
		// TODO Auto-generated constructor stub
		
		init();

	}


	@Override
	public void init() {
		// TODO Auto-generated method stub


		Tween.registerAccessor(FlatImage.class, new ActorAccessor());

		
		//MusicManage.playMusic(music);
		
		initImgSize();
		
		initTimeLine();

	}
	

	
	public void initImgSize()
	{
		float wpw = this.width;
		float wph = this.height;

		FlatImage[] images = new FlatImage[] { blackBgImg, stripImg,
				miniImg, pataImg, ponImg, logo2Img, poweredImg, nuclearLogoImg };
		
		for (FlatImage image : images) {

			image.setOrigin(image.width / 2, image.height / 2);
			this.addActor(image);

		}

		blackBgImg.setPosition(0, 0);
		blackBgImg.setSize(wpw, wph);
		

		pataImg.setSize(width/4, height/8);
		pataImg.setPosition(0, wph / 2 - pataImg.height);
		
		ponImg.setSize(width/4.5f, height/8);
		ponImg.setPosition(wpw, wph / 2 - ponImg.height);
		
		miniImg.setSize(pataImg.width, miniImg.height);
		miniImg.setPosition(wpw / 2 - pataImg.width, wph);
		
		
		
		logo2Img.setSize(height/5, height/5);
		logo2Img.setPosition(wpw / 2 - logo2Img.width/1.8f,
				wph * 0.5f);

		stripImg.setSize(wpw, wph);
		stripImg.setOrigin(wpw / 2, wph / 2);
		stripImg.setPosition(0, 0);
		
		

		poweredImg.setSize(width/5, height/10);
		poweredImg.setPosition(wpw / 2 - 1.2f*poweredImg.width, wph / 2
				- poweredImg.height);
		
		
		nuclearLogoImg.setSize(height/5, height/5);
		nuclearLogoImg.setPosition(wpw / 2, wph / 2 - nuclearLogoImg.height / 2);
		nuclearLogoImg.setOrigin(nuclearLogoImg.width/2, nuclearLogoImg.height/2);

		veilImg.setSize(wpw, wph);
		veilImg.setPosition(-wpw / 2, -wph / 2);
		veilImg.setColor(1, 1, 1, 0);
	}
	
	public void initTimeLine()
	{
		float wpw = this.width;
		float wph = this.height;
		
		Tween.setWaypointsLimit(1);
		
		Timeline.createSequence()
	
				
				.push(Tween.set(pataImg, ActorAccessor.POS_XY).targetRelative(
						-pataImg.width, wph * 0))
				.push(Tween.set(ponImg, ActorAccessor.POS_XY)
						.targetRelative(0, 0))
				.push(Tween.set(miniImg, ActorAccessor.POS_XY)
						.targetRelative(0, 0))
				.push(Tween.set(logo2Img, ActorAccessor.SCALE_XY).target(7, 7))
				.push(Tween.set(logo2Img, ActorAccessor.OPACITY).target(0))
				.push(Tween.set(stripImg, ActorAccessor.SCALE_XY).target(1, 0))
				.push(Tween.set(poweredImg, ActorAccessor.OPACITY).target(0))
				.push(Tween.set(nuclearLogoImg, ActorAccessor.OPACITY).target(0))

				// 开始 需要暂停一下，因为紫云加载的时候 deltatime 很长，前面的动画会直接从 开始值 跳到 结束值
				.pushPause(1f)
				
				.push(Tween.to(stripImg, ActorAccessor.SCALE_XY, 0.8f)
						.target(1, 0.6f).ease(Quart.OUT))
				.push(Tween.to(pataImg, ActorAccessor.POS_XY, 0.8f)
						.targetRelative(wpw * 0.5f, 0).ease(Quart.OUT))
				.push(Tween.to(ponImg, ActorAccessor.POS_XY, 0.8f)
						.targetRelative(wpw * -0.5f, 0).ease(Quart.OUT))
//				.push(Tween.to(miniImg, ActorAccessor.POS_XY, 0.6f)
//						.targetRelative(0, wph * -0.45f).ease(Quint.OUT))
				.pushPause(0.3f)

				.beginParallel()
				.push(Tween.set(logo2Img, ActorAccessor.OPACITY).target(1))
				.push(Tween.to(logo2Img, ActorAccessor.SCALE_XY, 0.3f)
						.target(1, 1).ease(Back.OUT))
				.end()
				.push(Tween.to(stripImg, ActorAccessor.SCALE_XY, 0.5f)
						.target(1, 1).ease(Back.IN))
				.pushPause(0.5f)

				.beginParallel()
				.push(Tween.to(pataImg, ActorAccessor.POS_XY, 0.5f)
						.targetRelative(wpw * 1, 0).ease(Back.IN))
				.push(Tween.to(ponImg, ActorAccessor.POS_XY, 0.5f)
						.targetRelative(wpw * 1, 0).ease(Back.IN))
//				.push(Tween.to(miniImg, ActorAccessor.POS_XY, 0.5f)
//						.targetRelative(wpw * 1, 0).ease(Back.IN))
				.push(Tween.to(logo2Img, ActorAccessor.POS_XY, 0.5f)
						.targetRelative(wpw * 1, 0).ease(Back.IN))
				.end()

				.pushPause(-0.3f)
				.push(Tween.to(poweredImg, ActorAccessor.OPACITY, 0.3f).target(
						1))

				.beginParallel()
				.push(Tween.to(nuclearLogoImg, ActorAccessor.OPACITY, 1.5f).target(1)
						.ease(Cubic.IN))
				.push(Tween.to(nuclearLogoImg, ActorAccessor.ROTATION, 2.0f)
						.target(360 * 15).ease(Quad.OUT))
				.end()

				.pushPause(0.3f)
				.push(Tween.to(nuclearLogoImg, ActorAccessor.SCALE_XY, 0.6f)
						.waypoint(1.6f, 0.4f).target(1.2f, 1.2f).ease(Cubic.OUT))

				.pushPause(0.3f)
				.beginParallel()
				.push(Tween.to(poweredImg, ActorAccessor.POS_XY, 0.5f)
						.targetRelative(wpw * 1, 0).ease(Back.IN))
				.push(Tween.to(nuclearLogoImg, ActorAccessor.POS_XY, 0.5f)
						.targetRelative(wpw * 1, 0).ease(Back.IN)).end()
				.pushPause(0.3f)
				.setCallback(new TweenCallback(){

					@Override
					public void onEvent(int type, BaseTween<?> source) {
						// TODO Auto-generated method stub
						finished = true;
						
					}} )
					
				.start(tweenManager);
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

		tweenManager.update(Gdx.graphics.getDeltaTime());

		if (nuclearLogoImg.rotation > 360*15-20) nuclearLogoImg.setRegion(logoImg.region);

		
		super.draw();
		
		if(finished==true)
		{
			NavLayeredScreenStageArg tempArg = new NavLayeredScreenStageArg(0, MainMenuStage.class);
            tempArg.EventArgSent();
		}
	}

	public void dispose() {
		tweenManager.killAll();
		super.dispose();
	}

}
