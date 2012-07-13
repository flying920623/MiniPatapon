package game.minipatapon.stage.midground;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.effectpresent.actor.Image;
import game.minipatapon.effectpresent.actor.NavigateImage;
import game.minipatapon.effectpresent.spriter.SpriterObject;
import game.minipatapon.effectpresent.spriter.SpriterObjectIniArg;
import game.minipatapon.effectpresent.spriter.action.MoveAction;

import game.minipatapon.effectpresent.spriter.util.SpriterGroup;
import game.minipatapon.effectpresent.spriter.util.SpriterImporter;
import game.minipatapon.event.EventListener;
import game.minipatapon.event.gamecmd.GameCommandArg;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.logical.GameRule.GameStateListener;
import game.minipatapon.logical.playControl.PlayerCommand;
import game.minipatapon.map.MapControl;
import game.minipatapon.repository.Repository;
import game.minipatapon.stage.base.BaseStage;
import game.minipatapon.util.MathHelper;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.tiled.TileMapRenderer;
import com.badlogic.gdx.graphics.g2d.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sun.opengl.impl.packrect.Rect;

public class GameStage extends BaseStage implements PlayerCommand,GameStateListener {

	protected OrthographicCamera gameCamera;

	// protected final SpriterGroup spriterRoot;

	private SpriterObject lockObject = null;

	TileMapRenderer mapRender;
	TiledMap map;

	protected HashMap<String, Actor> enemyActors;
	protected HashMap<String, Actor> justiceActors;
	
	
	Image blackGround ;
	Image missionImg ;
	
	public static float blackGroundHeight = 0;
	
	TweenManager tweenManager = new TweenManager();

	boolean gameOver  = false ;

	
	public GameStage(float width, float height, boolean stretch) {
		super(width, height, stretch);
		// TODO Auto-generated constructor stub
		// spriterRoot = new SpriterGroup();

		gameCamera = new OrthographicCamera(camera.viewportWidth,
				camera.viewportHeight);
		gameCamera.position.set(camera.position);

		enemyActors = new HashMap<String, Actor>();
		justiceActors = new HashMap<String, Actor>();
		
		blackGroundHeight = height/9;
		initBlackGround();
		
	}

	public GameStage(float width, float height, boolean stretch, int level) {
		this(width, height, stretch);

		String mapPath = "data/maps/level/";
		String mapName = "level" + String.valueOf(level);
		mapRender = MapControl.importMap(mapPath, mapName);
		map = mapRender.getMap();

		// DefaultLogger.getDefaultLogger().logWithSignature(this, "");
	}

	protected void initBlackGround()
	{
		blackGround = new Image("blackGround", TextureAssets.GetTextureRegionFromPacker(TextureAssets.BlackBgImg));

		blackGround.width = width*4;
		blackGround.height = blackGroundHeight;
		blackGround.y -= blackGroundHeight;
		addActor(blackGround);
	}
	
	public void OverSlideShow(TextureRegion missionRegion)
	{
		missionImg = new Image("", missionRegion);
		missionImg.height = height/3;
		missionImg.width = width;
		missionImg.x = gameCamera.position.x-width/2-missionImg.width;
		missionImg.y = height/2 - missionImg.height/2;
		this.addActor(missionImg);
		
		Timeline.createSequence()
		.pushPause(0.2f)
		.push(Tween.to(missionImg, ActorAccessor.POS_XY, 1f)
				.targetRelative(missionImg.width, 0))
		
		.start(tweenManager);
		
		
		
	}
	
	public void missionComplete()
	{

		gameCamera.position.set(lockObject.x+lockObject.width, gameCamera.position.y, gameCamera.position.z);
		OverSlideShow( TextureAssets.GetTextureRegionFromPacker(TextureAssets.MissionCompleted) );
		gameOver = true;
		
		
	}
	
	public void missionFailed()
	{
		OverSlideShow( TextureAssets.GetTextureRegionFromPacker(TextureAssets.MissionFailed) );
	}
	
	
	public void addActor(Actor actor)
	{
		actor.y += blackGroundHeight;
		super.addActor(actor);
	}
	
	public void draw() {

		camera.update();
		
		
		moveCameraWidthLockSpriter();
		gameCamera.update();
		
		batch.setProjectionMatrix(gameCamera.combined);
		
		batch.begin();
		root.draw(batch, 1);
		// spriterRoot.draw(batch);

		if (mapRender != null)
			//mapRender.render(gameCamera);
		batch.end();
		
		batch.setProjectionMatrix(camera.combined);

		checkAttackEnemy();
	}

	public void addEnemy(Actor actor) {

		enemyActors.put(actor.name, actor);
	}

	public void addEnemis(ArrayList<Actor> enemies) {
		for (int i = 0; i < enemies.size(); i++) {
			addEnemy(enemies.get(i));
		}
	}

	public void removeEnemy(String name) {
		this.enemyActors.remove(name);

	}

	public void clearEnemies() {
		this.enemyActors.clear();
	}

	public void addJustice(Actor actor) {

		justiceActors.put(actor.name, actor);
	}

	public void addJustices(ArrayList<Actor> actors) {
		for (int i = 0; i < actors.size(); i++) {
			addEnemy(justiceActors.get(i));
		}
	}

	public void removeJustice(String name) {
		this.justiceActors.remove(name);

	}

	public void clearJustices() {
		this.justiceActors.clear();
	}

	public Actor checkAttackEnemy() {

		for (Actor justice : justiceActors.values()) {
			for (Actor enemy : enemyActors.values()) {

				if (enemy instanceof SpriterObject
						&& justice instanceof SpriterObject) {

					SpriterObject justiceObject = (SpriterObject) justice;
					SpriterObject enemyObject = (SpriterObject) enemy;

					Rectangle weaponRec = justiceObject.getWeaponRec();
					Rectangle enemyRec = new Rectangle(enemyObject.x,
							enemyObject.y, enemyObject.getWidth(),
							enemyObject.getHeith());
					//
					// DefaultLogger.getDefaultLogger().logWithSignature(this,
					// "%s ,  %s ", weaponRec.toString(), enemyRec.toString());

					// if (weaponRec.contains(enemyRec)) {
					// DefaultLogger.getDefaultLogger().logWithSignature(this,
					// "%s 攻击了  %s ", justiceObject.name, enemyObject.name);
					// return enemyObject;
					// }
					//
					if (MathHelper.collide(weaponRec, enemyRec)) {
						// DefaultLogger.getDefaultLogger().logWithSignature(this,
						// "%s 攻击了  %s ", justiceObject.name, enemyObject.name);
						return enemyObject;
					}

				}

			}
		}

		return null;
	}

	// public void addSpriterObject(SpriterObject spriterObject) {
	// spriterRoot.addSpriterObject(spriterObject);
	// }
	//
	// public SpriterGroup getSpriterGroup() {
	// return spriterRoot;
	// }
	//
	// public SpriterObject findSpriter(String name) {
	// return spriterRoot.findSpriterObject(name);
	// }

	// /** @return all top level {@link Actor}s */
	// public List<SpriterObject> getSpriters() {
	// return spriterRoot.getSpriterObjects();
	// }
	//
	//

	void setLockSpriter(SpriterObject object) {
		this.lockObject = object;
	}

	private void moveCameraWidthLockSpriter() {
		if (lockObject == null)
			return;

		Vector3 pos = gameCamera.position;

		if (pos.x - lockObject.x < width/4)
		{
			if( !gameOver )
			{
				gameCamera.position.set(lockObject.x + width/4, pos.y, pos.z);
				blackGround.x = gameCamera.position.x - width/2;
			}
			
		}
			
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

	public boolean keyDown(int keycode) {

//		SpriterObject object = (SpriterObject) root.findActor("knight");
//		if (object != null)
//			object.attack("attack", (SpriterObject) root.findActor("monster"));
//		
//		SpriterObject object2 = (SpriterObject) root.findActor("toxotae");
//		if (object2 != null)
//			object2.attack("attack", (SpriterObject) root.findActor("monster"));
//		
//		SpriterObject object3 = (SpriterObject) root.findActor("bird_a");
//		if (object3 != null)
//			object3.setCurrentState(MoveAction.repeatMove(object3, 100, 1), "attack");
		
		for( int i=0; i<root.getActors().size();i++ )
		{
			 
			if( root.getActors().get(i) instanceof SpriterObject )
			{
				SpriterObject object = (SpriterObject)root.getActors().get(i);
				object.simpleMove("move", width/4);
			}
		}

		return root.keyDown(keycode);
	}

	/**
	 * Called when a key was released
	 * 
	 * @param keycode
	 *            one of the constants in {@link Keys}
	 * @return whether the input was processed
	 */
	@Override
	public boolean keyUp(int keycode) {
		return root.keyUp(keycode);// && spriterRoot.keyUp(keycode);
	}

	/**
	 * Called when a key was typed
	 * 
	 * @param character
	 *            The character
	 * @return whether the input was processed
	 */
	@Override
	public boolean keyTyped(char character) {
		return root.keyTyped(character);// && spriterRoot.keyTyped(character);
	}

	public static SpriterObjectIniArg readObjectFromGson() throws Exception {
		SpriterObjectIniArg arg = null;
		
		arg = Repository.fetch(SpriterObjectIniArg.class);
		
		DefaultLogger.getDefaultLogger().log( arg.toString() );
		
		return arg;
	}

	public static void writeObjectToGson(String objectName, String filename,
			String iniAni, float x, float y, float scaleX, float scaleY,
			Stage stage, String attackMode) throws Exception {
		
		DefaultLogger.getDefaultLogger().log(objectName);
		
		SpriterObjectIniArg arg = new SpriterObjectIniArg();
		arg.objectName = objectName;
		arg.filename = filename;
		arg.iniAni = iniAni;
		arg.x = x;
		arg.y = y;
		arg.scaleX = scaleX;
		arg.scaleY = scaleY;
		//arg.stage = stage;
	//	arg.actionListener = actionListener;
        arg.attackMode = attackMode;
		Repository.save(arg);

	}


	@Override
	public void OnAttackCommand() {
		// TODO Auto-generated method stub
		
		DefaultLogger.getDefaultLogger().log(0, "  command fora att","");

	}

	@Override
	public void OnDefenseCommand() {
		// TODO Auto-generated method stub
	
		DefaultLogger.getDefaultLogger().log(0, "  command for den","");

	}

	@Override
	public void OnForwardCommand() {
		// TODO Auto-generated method stub
		DefaultLogger.getDefaultLogger().log(0, "  command for move","");

	}

	@Override
	public void OnFailCommand() {
		// TODO Auto-generated method stub
		DefaultLogger.getDefaultLogger().log(0, "  command for fail" ,"");
	}

	@Override
	public void OnGameStart() {
		// TODO Auto-generated method stub
		DefaultLogger.getDefaultLogger().log(0, "  start!","");

	}

	@Override
	public void OnGameEnd() {
		// TODO Auto-generated method stub
		DefaultLogger.getDefaultLogger().log(0, "  end!","");

	}

}
