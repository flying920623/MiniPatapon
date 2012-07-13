package game.minipatapon.stage.midground;

import game.minipatapon.datasource.assets.FontAssets;
import game.minipatapon.datasource.assets.MusicAssets;
import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.SoundAssets;
import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.effectpresent.audioplayer.MusicManage;
import game.minipatapon.effectpresent.audioplayer.SoundManage;
import game.minipatapon.effectpresent.dialog.Dialog;
import game.minipatapon.effectpresent.dialog.SlideDialog;
import game.minipatapon.effectpresent.spriter.SpriterObject;
import game.minipatapon.effectpresent.spriter.action.MoveAction;
import game.minipatapon.logger.DefaultLogger;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.tiled.TiledObject;
import com.badlogic.gdx.graphics.g2d.tiled.TiledObjectGroup;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Level3Stage extends GameStage {

	SpriterObject standard_bearer;
	SpriterObject sword;
	SpriterObject hero;
	SpriterObject knight;
	SpriterObject infantry_a;
	SpriterObject infantry_b;
	SpriterObject bird;
	SpriterObject axe;
	SpriterObject toxotae;

	SpriterObject enemy;

	SpriterObject end_mark_tower;

	Dialog dialog;

	Music tumMusic;
	// Music backMusic;

	Music howlSound;
	Music windSound;
	Music thunderSound;
	

	Music gameCompleteSound;
	Music gameFailedSound;

	Music forwordSound1;
	// Sound forwordSound2;
	Music atkSound1;
	// Sound atkSound2;
	Music defSound1;
	// Sound defSound2;
	Music cheerSound;
	Music failSound;

	Music startLevelSound;
	Music arriveDestSound;

	Music deathSound;
	
	boolean meetEnemy = false;
	
	int attackNumber = 0;
	
	

	public Level3Stage(float width, float height, boolean stretch) {
		super(width, height, stretch);
		// TODO Auto-generated constructor stub

		init();
	}

	public Level3Stage(float width, float height, boolean stretch, int level) {
		super(width, height, stretch, level);
		// TODO Auto-generated constructor stub

		init();
	}

	public void init() {
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
//		knight = SpriterObject.initSpriterObject("knight",
//				"axeSCML", "move", width/4, 0, 1, 1, this,
//				SpriterObject.moveAttack);
//		
//		knight.action(MoveAction.repeatMove(knight, 20, 1));
		
		
//		enemy = SpriterObject.initSpriterObject("monster",
//				"monsterSCML", "attack", 600, 0, 1.5f, 1.5f,
//				this, SpriterObject.moveAttack);
//		
//		toxotae = SpriterObject.initSpriterObject("toxotae",
//				"toxotaeSCML", "move", 400, 0, 1, 1,
//				this, SpriterObject.throwAttack);
		
//		bird_a = SpriterObject.initSpriterObject("bird_a",
//				"birdSCML", "move", 400, 100, 1, 1,
//				this, SpriterObject.moveAttack);
//		
//		bird_b = SpriterObject.initSpriterObject("bird_b",
//				"birdSCML", "move", 3500, 140, 1, 1,
//				this, SpriterObject.moveAttack);
		
		
		
		initMap();
		initSpriterObject();
		initDialog();
		initMusic();
		initSound();
		initActor();
		
		DefaultLogger.getDefaultLogger().logWithSignature(this, "x, y :  %f, %f", enemy.x, enemy.y);
	}

	public void initActor() {

	}

	public void initSpriterObject() {

	}

	public void initMap() {
		for (TiledObjectGroup group : map.objectGroups) {
			for (TiledObject object : group.objects) {
				if ("standard_bearer".equals(object.name)) {
					standard_bearer = SpriterObject.initSpriterObject(
							"standard_bearer", "standard_bearerSCML", "move",
							object.x, 0, 0.5f, 0.5f, this, SpriterObject.moveAttack);
					setLockSpriter(standard_bearer);
				} else if ("infantry_a".equals(object.name)) {
					infantry_a = SpriterObject.initSpriterObject("infantry_a",
							"infantrySCML", "move", object.x, 0, 1, 1, this,
							SpriterObject.moveAttack);
				} else if ("infantry_b".equals(object.name)) {
					infantry_b = SpriterObject.initSpriterObject("infantry_b",
							"infantrySCML", "move", object.x, 0, 1, 1, this,
							SpriterObject.moveAttack);
				} else if ("sword".equals(object.name)) {
					sword = SpriterObject.initSpriterObject("sword",
							"swordSCML", "move", object.x, -7, 1, 1, this,
							SpriterObject.moveAttack);
				} else if ("hero".equals(object.name)) {
					hero = SpriterObject.initSpriterObject("blueHero",
							"blueHeroSCML", "move", object.x, -7, 0.6f, 0.6f, this,
							SpriterObject.moveAttack);
				} else if ("toxotae".equals(object.name)) {
					toxotae = SpriterObject.initSpriterObject("toxotae",
							"toxotaeSCML", "move", object.x, 0, 0.5f, 0.5f, this,
							SpriterObject.moveAttack);
				} else if ("bird".equals(object.name)) {
					bird = SpriterObject.initSpriterObject("bird",
							"birdSCML", "move", object.x, object.y/2, 1, 1, this,
							SpriterObject.throwAttack);
				} else if ("axe".equals(object.name)) {
					axe = SpriterObject.initSpriterObject("axe",
							"axeSCML", "move", object.x, 0, 1, 1, this,
							SpriterObject.throwAttack);
				} else if ("enemy".equals(object.name)) {
					enemy = SpriterObject.initSpriterObject("monster",
							"monsterSCML", "attack", object.x, 0, 2, 2,
							this, SpriterObject.moveAttack);
					enemy.speed = 50;
				} else if ("end_mark_tower".equals(object.name)) {
//					end_mark_tower = SpriterObject.initSpriterObject("tower",
//							"towerSCML", "attacted", object.x, 0, 1, 1, this,
//							SpriterObject.moveAttack);
				}

			}
		}
	}

	public void initDialog() {
		dialog = new SlideDialog("slideDialog", "", this);
	}

	public void initSound() {
//		this.windSound = ResourceLoader.loadMusic(SoundAssets.windSoundStr);
//		this.howlSound = ResourceLoader.loadMusic(SoundAssets.howlSoundStr);
//		this.thunderSound = ResourceLoader.loadMusic(SoundAssets.thunderSoundStr);
		
		this.gameCompleteSound = MusicAssets.GetMusic(SoundAssets.missionCompleteSoundStr);
		this.gameFailedSound = MusicAssets.GetMusic(SoundAssets.missionFailedSoundStr);

		this.forwordSound1 = MusicAssets.GetMusic(SoundAssets.forwordSoundStr);
//		
//		// this.forwordSound2 = ResourceLoader
//		// .loadMusic(SoundAssets.forwordSound2Str);
		this.atkSound1 = MusicAssets.GetMusic(SoundAssets.atkSoundStr);
		// this.atkSound2 = ResourceLoader.loadMusic(SoundAssets.atkSound2Str);
		this.defSound1 = MusicAssets.GetMusic(SoundAssets.defSoundStr);
		// this.defSound2 = ResourceLoader.loadMusic(SoundAssets.defSound2Str);
//		this.cheerSound = ResourceLoader.loadMusic(SoundAssets.cheerSoundStr);
		this.failSound = MusicAssets.GetMusic(SoundAssets.failSoundStr);
//
//		this.startLevelSound = ResourceLoader
//				.loadMusic(SoundAssets.startLevelSoundStr);
//		this.arriveDestSound = ResourceLoader
//				.loadMusic(SoundAssets.arriveDestSoundStr);
//
//		this.deathSound = ResourceLoader.loadMusic(SoundAssets.deathSoundStr);
	}

	public void initMusic() {
		this.tumMusic = MusicAssets.GetMusic(MusicAssets.drumTwoRhythmStr);
//		this.backMusic = ResourceLoader.loadMusic(MusicAssets.level3MusicStr);
	}

	
	@Override
	public void OnDefenseCommand() {
		// TODO Auto-generated method stub
		
		MusicManage.playMusic(defSound1);
		//DefaultLogger.getDefaultLogger().log(0, "  command for","");
		

		
		for( int i=0; i<root.getActors().size();i++ )
		{
			 
			if( root.getActors().get(i) instanceof SpriterObject )
			{
				
				SpriterObject object = (SpriterObject)root.getActors().get(i);
				if( object== enemy)
					continue;
				float d = MathUtils.random(20, 100);
				object.action( MoveAction.repeatMove(object, -d, 1) );
			}
		}
		
		sword.action(MoveAction.defense(sword,  (enemy.x-sword.x)));
	}

	@Override
	public void OnForwardCommand() {
		// TODO Auto-generated method stub
	//	DefaultLogger.getDefaultLogger().log(0, "  command for","");
		
		if( meetEnemy )
		{
			new SlideDialog("Kill the Dragon, or you can't move!", hero, this, 2);
			return;
		}
		
		if( !meetEnemy )
		{
			new SlideDialog("That's it!!! Let's move!", hero, this, 2);
			
			for( int i=0; i<root.getActors().size();i++ )
			{
				 
				if( root.getActors().get(i) instanceof SpriterObject )
				{
					
					SpriterObject object = (SpriterObject)root.getActors().get(i);
					if( object== enemy)
						continue;
					object.simpleMove("move", width/5);
				}
			}
			
		}
		
		
		MusicManage.playMusic(this.forwordSound1);
	}

	@Override
	public void OnFailCommand() {
		// TODO Auto-generated method stub
	//	DefaultLogger.getDefaultLogger().log(0, "  command for","");
		
		
		if( !meetEnemy )
		{
			new SlideDialog("Match the rhythm! 'PATA' 'PATA' 'PATA' 'PON' will forword...", hero, this, 2);
			
		}else{
			new SlideDialog("'PON' 'PON' 'PATA' 'PON' will Atack enemy!, Just do it!", hero, this, 2);
		}
		hero.jump("move", height/20);
		MusicManage.playMusic(failSound);

//		standard_bearer.simpleMove("", distance);
//        spear.simpleMove("", distance);
//		axe.simpleMove("", distance);
//		sword.simpleMove("", distance);
		//hero.simpleMove("", distance);

	}
	

	@Override
	public void OnAttackCommand() {
		// TODO Auto-generated method stub
		
		if( !meetEnemy )
		{
			new SlideDialog("There is no enemy,Go Go Go!!", hero, this, 2);
			return;
		}
		
		else{
			
			for( int i=0; i<root.getActors().size();i++ )
			{
				 
				if( root.getActors().get(i) instanceof SpriterObject )
				{
					
					SpriterObject object = (SpriterObject)root.getActors().get(i);
					if( object== enemy || object==standard_bearer)
						continue;
					object.attack("attack", enemy);
				}
			
			}

			standard_bearer.action(MoveAction.jump(standard_bearer, height/10));
			bird.setCurrentState(MoveAction.repeatMove(bird, 100, 1), "attack");
			
			attackNumber ++;
			
			if( attackNumber>=6 )
			{
				killEnemy();				
			}
		}

		MusicManage.playMusic(atkSound1);
		
		super.OnAttackCommand();
	}
	

	public void killEnemy()
	{
		enemy.currentAnimation = "dead";
		enemy.repeatAnimation = false;
		
		Timeline.createSequence()
		.pushPause(0.5f)
		.setCallback(new TweenCallback() {
			
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				// TODO Auto-generated method stub
				setLockSpriter(enemy);
				missionComplete();
				MusicManage.playMusic(gameCompleteSound);
				
				for( int i=0; i<root.getActors().size();i++ )
				{					 
					if( root.getActors().get(i) instanceof SpriterObject )
					{
						SpriterObject object = (SpriterObject)root.getActors().get(i);
						if( object== enemy)
							continue;
						object.y = blackGroundHeight;
						object.simpleMove("move", width/5);
					}
				}

			}
		}).start(tweenManager);
		
		
	}
	
	
	@Override
	public void OnGameStart() {
		// TODO Auto-generated method stub
		DefaultLogger.getDefaultLogger().log(0, "  start!","");
		MusicManage.setLoopingMusic(tumMusic, true);
		MusicManage.playMusic(tumMusic);
		
//		float random = MathUtils.random(0, 100);
//		if(random>75f)
//			MusicManage.playMusic(rainSound);
//		else if(random>50f&&random<=75f)
//			MusicManage.playMusic(howlSound);
//		else if(random>25f&&random<=50f)
//			MusicManage.playMusic(windSound);
//		else if (random<=25f) {
//			MusicManage.playMusic(thunderSound);
//		}
	}


	@Override
	public void OnGameEnd() {
		// TODO Auto-generated method stub
		
	}
	
	int dragonChangeTime = 3;
	int elapseTime = 0;
	
	public void draw()
	{
		elapseTime += Gdx.graphics.getDeltaTime();
		
//		if( elapseTime%dragonChangeTime == 0)
//		{
//			int i = MathUtils.random(4);
//			if( i==0 )
//			{
//				enemy.setCurrentState(MoveAction.simpleMove(enemy, 20), "move");
//			}
//			if( i==1)
//			{
//				enemy.setCurrentState(MoveAction.simpleMove(enemy, 20), "attack");
//			}
//		}
		
		tweenManager.update(Gdx.graphics.getDeltaTime());
		if( enemy.x < gameCamera.position.x + width/4 )
		{
			meetEnemy = true;
//			DefaultLogger.getDefaultLogger().log("meet dragon");
		}
		
		super.draw();
	}
}
