package game.minipatapon.stage.midground;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.tiled.TiledObject;
import com.badlogic.gdx.graphics.g2d.tiled.TiledObjectGroup;
import com.badlogic.gdx.math.MathUtils;

import game.minipatapon.application.MiniPataponManager;
import game.minipatapon.datasource.assets.MusicAssets;
import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.SoundAssets;
import game.minipatapon.effectpresent.audioplayer.MusicManage;
import game.minipatapon.effectpresent.audioplayer.SoundManage;
import game.minipatapon.effectpresent.background.ParaBackgroundLevel1;
import game.minipatapon.effectpresent.dialog.Dialog;
import game.minipatapon.effectpresent.dialog.SlideDialog;
import game.minipatapon.effectpresent.spriter.SpriterObject;
import game.minipatapon.effectpresent.spriter.action.MoveAction;

import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.stage.background.BackgroundStage;

public class Level1Stage extends GameStage {

	SpriterObject standard_bearer;
	SpriterObject spear;
	SpriterObject axe;
	SpriterObject sword;
	SpriterObject hero;

	SpriterObject end_mark_tower;

	SlideDialog dialog;

	Music tumMusic;
	Music backMusic;

	Sound windSound;
	Sound rainSound;
	Sound howlSound;
	Sound thunderSound;

	Sound gameCompleteSound;
	Sound gameFailedSound;

	Sound forwordSound1;
	Sound forwordSound2;
	Sound cheerSound;

	Sound startLevelSound;
	Sound arriveDestSound;

	float distance = Gdx.graphics.getWidth()*3/10;
	float heightDistance = Gdx.graphics.getHeight()/8;
	
	
	
	public Level1Stage(float width, float height, boolean stretch) {
		super(width, height, stretch);
		// TODO Auto-generated constructor stub

		init();
	}

	public Level1Stage(float width, float height, boolean stretch, int level) {
		super(width, height, stretch, level);
		// TODO Auto-generated constructor stub

		init();
	}

	public void init() {
		initMap();
		initSpriterObject();
		initDialog();
		initMusic();
		initSound();
		initActor();
		MiniPataponManager.getInstance().GetLayeredScreen().getBackScreen().navigate(
				new BackgroundStage(MiniPataponManager.getInstance().GetLayeredScreen().getBackScreen(),
						width, height, stretch, ParaBackgroundLevel1.class));
		
	}
	
	
	public void initActor(){
		
	}

	public void initSpriterObject() {

	}

	public void initMap() {
		for (TiledObjectGroup group : map.objectGroups) {
			for (TiledObject object : group.objects) {
				if ("standard_bearer".equals(object.name)) {
					standard_bearer = SpriterObject.initSpriterObject(
							"standard_bearer", "standard_bearerSCML", "move",
							object.x, 0, 1, 1, this,SpriterObject.moveAttack);
					setLockSpriter(standard_bearer);
				} else if ("spear".equals(object.name)) {
					spear = SpriterObject.initSpriterObject("infantry",
							"infantrySCML", "move", object.x, 0, 1, 1, this,SpriterObject.moveAttack);
				} else if ("axe".equals(object.name)) {
					axe = SpriterObject.initSpriterObject("axe", "axeSCML",
							"move", object.x, 0, 1, 1, this,SpriterObject.moveAttack);
				} else if ("sword".equals(object.name)) {
					sword = SpriterObject.initSpriterObject("sword",
							"swordSCML", "move", object.x, 0, 1, 1, this,SpriterObject.moveAttack);
				} else if ("hero".equals(object.name)) {
					hero = SpriterObject.initSpriterObject("blueHero",
							"blueHeroSCML", "move", object.x, 0, 1, 1, this,SpriterObject.moveAttack);
				} else if ("end_mark_tower".equals(object.name)) {
					end_mark_tower = SpriterObject.initSpriterObject("tower",
							"towerSCML", "attacted", object.x, 0, 2, 2, this,SpriterObject.moveAttack);
				}

			}
		}
	}

	public void initDialog() {
		dialog = new SlideDialog("slideDialog", "", this);

		// 使用 dialog.show(target, text);
	}

	public void initSound() {
		this.howlSound = ResourceLoader.loadSound(SoundAssets.howlSoundStr);
		this.windSound = ResourceLoader.loadSound(SoundAssets.windSoundStr);
//		this.rainSound = ResourceLoader.loadSound(SoundAssets.rainSoundStr);
//		this.thunderSound = ResourceLoader.loadSound(SoundAssets.thunderSoundStr);
		this.gameCompleteSound = ResourceLoader
				.loadSound(SoundAssets.missionCompleteSoundStr);
		this.gameFailedSound = ResourceLoader
				.loadSound(SoundAssets.missionFailedSoundStr);

		this.forwordSound1 = ResourceLoader
				.loadSound(SoundAssets.forwordSoundStr);
		this.forwordSound2 = ResourceLoader
				.loadSound(SoundAssets.forwordSound2Str);
		this.cheerSound = ResourceLoader.loadSound(SoundAssets.cheerSoundStr);

		this.startLevelSound = ResourceLoader
				.loadSound(SoundAssets.startLevelSoundStr);
		this.arriveDestSound = ResourceLoader
				.loadSound(SoundAssets.arriveDestSoundStr);
	}

	public void initMusic() {

		this.tumMusic = ResourceLoader.loadMusic(MusicAssets.drumTwoRhythmStr);
		this.backMusic = ResourceLoader.loadMusic(MusicAssets.level1MusicStr);
		
	}
	
	
	@Override
	public void OnDefenseCommand() {
		// TODO Auto-generated method stub
		
	
		//DefaultLogger.getDefaultLogger().log(0, "  command for","");

	}

	@Override
	public void OnForwardCommand() {
		// TODO Auto-generated method stub
	//	DefaultLogger.getDefaultLogger().log(0, "  command for","");
		
		new SlideDialog("That's it!!!", hero, this, 2);
		
		standard_bearer.simpleMove("", distance);
        spear.simpleMove("", distance);
		axe.simpleMove("", distance);
		sword.simpleMove("", distance);
		hero.simpleMove("", distance);
		end_mark_tower.simpleMove("", distance);
		SoundManage.playSound(this.forwordSound1);

	}

	@Override
	public void OnFailCommand() {
		// TODO Auto-generated method stub
	//	DefaultLogger.getDefaultLogger().log(0, "  command for","");
		
		
//		new SlideDialog("Match the rhythm! 'PATA' 'PATA' 'PATA' 'PON' will forword...", hero, this, 2);
		
		new SlideDialog("That's it!!!", hero, this, 2);
//		standard_bearer.simpleMove("", distance);
//        spear.simpleMove("", distance);
//		axe.simpleMove("", distance);
//		sword.simpleMove("", distance);
		//hero.simpleMove("", distance);
		hero.action(MoveAction.simpleMove(hero, heightDistance));
		standard_bearer.action(MoveAction.simpleMove(standard_bearer, distance));
		
        spear.action(MoveAction.simpleMove(spear, distance/2));
		axe.action(MoveAction.simpleMove(axe, distance));
		sword.action(MoveAction.simpleMove(sword, distance));
		
		SoundManage.playSound(this.forwordSound1);
		
	}
	@Override
	public void OnGameStart() {
		// TODO Auto-generated method stub
		DefaultLogger.getDefaultLogger().log(0, "  start!","");
		MusicManage.setLoopingMusic(tumMusic, true);
		MusicManage.playMusic(tumMusic);
		
		float random = MathUtils.random(0, 100);
		if(random>75f)
			SoundManage.playSound(rainSound);
		else if(random>50f&&random<=75f)
			SoundManage.playSound(howlSound);
//		else if(random>25f&&random<=50f)
//			SoundManage.playSound(windSound);
//		else if (random<=25f) {
//			SoundManage.playSound(thunderSound);
//		}
	}

	@Override
	public void OnGameEnd() {
		// TODO Auto-generated method stub
		
	}

}
