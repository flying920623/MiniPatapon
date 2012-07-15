package game.minipatapon.stage.midground;

import game.minipatapon.application.MiniPataponManager;
import game.minipatapon.datasource.assets.MusicAssets;
import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.SoundAssets;
import game.minipatapon.effectpresent.audioplayer.MusicManage;
import game.minipatapon.effectpresent.audioplayer.SoundManage;
import game.minipatapon.effectpresent.background.ParaBackgroundLevel2;
import game.minipatapon.effectpresent.dialog.Dialog;
import game.minipatapon.effectpresent.dialog.SlideDialog;
import game.minipatapon.effectpresent.spriter.SpriterObject;
import game.minipatapon.stage.background.BackgroundStage;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.tiled.TiledObject;
import com.badlogic.gdx.graphics.g2d.tiled.TiledObjectGroup;

public class Level2Stage extends GameStage {

	SpriterObject standard_bearer;
	SpriterObject spear;
	SpriterObject axe;
	SpriterObject sword;
	SpriterObject hero;
	SpriterObject toxotae;
	SpriterObject bird;

	SpriterObject barrier_tower;

	SpriterObject end_mark_tower;

	Dialog dialog;

	Music tumMusic;
	Music backMusic;

	Sound howlSound;
	Sound windSound;
	// Sound barrierDestroySound;

	Sound gameCompleteSound;
	Sound gameFailedSound;

	Sound forwordSound1;
	Sound forwordSound2;
	Sound atkSound1;
	Sound atkSound2;
	Sound cheerSound;
	Sound failSound;

	Sound startLevelSound;
	Sound arriveDestSound;

	public Level2Stage(float width, float height, boolean stretch) {
		super(width, height, stretch);
		// TODO Auto-generated constructor stub

		init();
	}

	public Level2Stage(float width, float height, boolean stretch, int level) {
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
						width, height, stretch, ParaBackgroundLevel2.class));
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
				} else if ("toxotae".equals(object.name)) {
					 toxotae = SpriterObject.initSpriterObject("toxotae",
								"toxotaeSCML", "move", object.x, 0, 1, 1, this,SpriterObject.moveAttack);
				} else if ("bird".equals(object.name)) {
					 bird = SpriterObject.initSpriterObject("bird",
								"birdSCML", "move", object.x, object.y, 1, 1, this,SpriterObject.moveAttack);
				} else if ("barrier_tower".equals(object.name)) {
					barrier_tower = SpriterObject.initSpriterObject("tower",
							"towerSCML", "attacted", object.x, 0, 1.5f, 1.5f, this,SpriterObject.moveAttack);
				} else if ("end_mark_tower".equals(object.name)) {
					end_mark_tower = SpriterObject.initSpriterObject("tower",
							"towerSCML", "attacted", object.x, 0, 1, 1, this,SpriterObject.moveAttack);
				}

			}
		}
	}

	public void initDialog() {
		dialog = new SlideDialog("slideDialog", "", this);
	}

	public void initSound() {
		this.windSound = ResourceLoader.getSound(SoundAssets.windSoundStr);
		this.howlSound = ResourceLoader.getSound(SoundAssets.howlSoundStr);
		this.gameCompleteSound = ResourceLoader
				.getSound(SoundAssets.missionCompleteSoundStr);
		this.gameFailedSound = ResourceLoader
				.getSound(SoundAssets.missionFailedSoundStr);

		this.forwordSound1 = ResourceLoader
				.getSound(SoundAssets.forwordSoundStr);
		this.forwordSound2 = ResourceLoader
				.getSound(SoundAssets.forwordSound2Str);
		this.atkSound1 = ResourceLoader.getSound(SoundAssets.atkSoundStr);
		this.atkSound2 = ResourceLoader.getSound(SoundAssets.atkSound2Str);
		this.cheerSound = ResourceLoader.getSound(SoundAssets.cheerSoundStr);
		this.failSound = ResourceLoader.getSound(SoundAssets.failSoundStr);

		this.startLevelSound = ResourceLoader
				.getSound(SoundAssets.startLevelSoundStr);
		this.arriveDestSound = ResourceLoader
				.getSound(SoundAssets.arriveDestSoundStr);
	}

	public void initMusic() {
		this.tumMusic = ResourceLoader.getMusic(MusicAssets.drumTwoRhythmStr);
		this.backMusic = ResourceLoader.getMusic(MusicAssets.level2MusicStr);
	}

	@Override
	public void OnAttackCommand() {
		// TODO Auto-generated method stub
		super.OnAttackCommand();
		SoundManage.playSound(atkSound1);
	}

	@Override
	public void OnForwardCommand() {
		// TODO Auto-generated method stub
		super.OnForwardCommand();
		SoundManage.playSound(forwordSound1);
	}

	@Override
	public void OnFailCommand() {
		// TODO Auto-generated method stub
		SoundManage.playSound(failSound);
		super.OnFailCommand();
	}

	@Override
	public void OnGameStart() {
		// TODO Auto-generated method stub
		super.OnGameStart();
		MusicManage.setLoopingMusic(tumMusic, true);
		MusicManage.playMusic(tumMusic);
	}

	@Override
	public void OnGameEnd() {
		// TODO Auto-generated method stub
		super.OnGameEnd();
	}
	
	
}
